
var util = require('../../utils/util.js')

const app = getApp()
Page({
  data: {
    movie: {},
    cinemas: [],
    date: [],
    day:"",
    hall:"",
    time:"",
    is_collect:false,
    option1: [],
    option2:[
      { text: '一号厅', value: 0 },
      { text: '二号厅', value: 1 },
      { text: '三号厅', value: 2 },
      { text: '四号厅', value: 3 }
    ],
    option3:[
      { text: '12:00', value: 0 },
      { text: '15:00', value: 1 },
      { text: '18:00', value: 2 },
      { text: '21:00', value: 3 }
    ],
    value1:0,
    value2:0,
    value3:0,
    activeNames: 0,
  },

  // dealTime: function (num) {     // num：未来天数
  //   var time = new Date()
  //   var date = new Date(time.setDate(time.getDate() + num)).getDate()
  //   var month = time.getMonth() + 1
  //   var day = time.getDay()
  //   switch (day) {             //  格式化
  //     case 0: day = "(周日)"
  //       break
  //     case 1: day = "(周一)"
  //       break
  //     case 2: day = "(周二)"
  //       break
  //     case 3: day = "(周三)"
  //       break
  //     case 4: day = "(周四)"
  //       break
  //     case 5: day = "(周五)"
  //       break
  //     case 6: day = "(周六)"
  //       break
  //   }
  //   var obj = {
  //     date: date,
  //     day: day,
  //     month: month,
  //     newday: month + '-' + date
  //   }
  //   return obj
  // },
  onLoad: function (e) {
    this.setData({
      hall:this.data.option2[0].text,
      time:this.data.option3[0].text,
    })
    let temp = JSON.parse(e.selectmovie);
    this.setData({
      movie: temp
    })
    //获取今天和后四天日期
    // for(var i=0;i<5;i++){
    //     var str='date['+i+']'
    //     this.setData({
    //         [str]:this.dealTime(i).newday
    //     })
    // }
    var list=new Array();
    var date = new Date();
    var todate = date.getFullYear() + "-" + ((date.getMonth() + 1) < 10 ? ("0" + (date.getMonth() + 1)) : date.getMonth() + 1) + "-" + (date.getDate() < 10 ? ("0" + date.getDate()) : date.getDate());
    for(var i=0;i<5;i++){
      var obj=util.dateLater(todate,i)
      list.push(obj.year+'-'+obj.month+'-'+obj.day);
    }
    this.setData({
      date:list
    })

    this.init_date();
    wx.request({
      url: 'http://localhost:8080/cinema/cinema_list',
      header: { 'content-type': 'application/json' },
      method: 'GET',
      success: (result) => {
        // console.log(result.data.data)
        this.setData({
          cinemas: result.data.data
        })
      },
      fail: () => { },
      complete: () => { }
    });
  },
  onShow(e){
    this.init_collcet();
  },
  onChange1(event) {
    this.setData({
      activeNames: event.detail,
    });
  },
  onChange2(e){
    this.setData({
      day:this.data.option1[e.detail].text
    })
  },
  onChange3(e){
    this.setData({
      hall:this.data.option2[e.detail].text
    })
  },
  onChange3(e){
    this.setData({
      time:this.data.option3[e.detail].text
    })
  },
  toSelect(e) {
    let selectmovie=JSON.stringify(this.data.movie);
    let address=JSON.stringify(e.currentTarget.dataset.address);
    wx.navigateTo({
      url: '/pages/select/select?selectmovie='+selectmovie+
      "&address="+address+
      '&day='+this.data.day+
      '&hall='+this.data.hall+
      '&time='+this.data.time,
      success: (result) => {
      },
      fail: () => {
      },
      complete: () => {
      }
    });
  },
  //收藏电影
  collect(e){
    var arr=app.globalData.collect_movie;
    if(this.data.is_collect){//如果电影已经收藏
      this.setData({
        is_collect:false
      })
      wx.showToast({
        title: '取消收藏',
        icon:'none'
      })
      // for(var i=0;i<arr.length;i++){
      //   if(arr[i].movieId==this.data.movie.movieId){
      //     arr.splice(i,1);break;
      //   }
      // }
      wx.request({
        url: 'http://localhost:8080/collection/delete',
        header: {"Content-Type": "application/x-www-form-urlencoded"},
        method: 'post',
        data:{
          userId:app.globalData.userId,
          movieId:this.data.movie.movieId
        },
        success: (result)=>{},
        fail: ()=>{},
        complete: ()=>{}
    })
    }else{//如果电影还未收藏
      this.setData({
        is_collect:true
      })
      wx.showToast({
        title: '已收藏',
        icon:'none'
      }),
      // arr.push(this.data.movie);
      wx.request({
        url: 'http://localhost:8080/collection/insert',
        header: {"Content-Type": "application/x-www-form-urlencoded"},
        method: 'post',
        data:{
          userId:app.globalData.userId,
          movieId:this.data.movie.movieId
        },
        success: (result)=>{},
        fail: ()=>{},
        complete: ()=>{}
    })
    }
    // app.globalData.collect_movie=arr;
  },
  init_collcet(e){
    // var movies=app.globalData.collect_movie;
    // for(var i=0;i<movies.length;i++){
    //   if(movies[i].movieId==this.data.movie.movieId){
    //     this.setData({
    //       is_collect:true
    //     })
    //   }
    // }
    wx.request({
      url: 'http://localhost:8080/collection/is_collection',
      header: {"Content-Type": "application/x-www-form-urlencoded"},
      method: 'post',
      data:{
        userId:app.globalData.userId,
        movieId:this.data.movie.movieId
      },
      success: (result)=>{
        console.log(result.data.data)
        if(result.data.data==1){
          this.setData({
            is_collect:true
          })
        }
        
      },
      fail: ()=>{},
      complete: ()=>{}
  })
  },
  init_date(){
    var arr=this.data.date
    var arr1=new Array()
    var temp={}
    for(var i=0;i<arr.length;i++){
      temp.text=arr[i],
      temp.value=i;
      arr1.push(temp);
      temp={}
    }
    this.setData({
      option1:arr1
    })
    this.setData({
      day:this.data.option1[0].text
    })
  }
})