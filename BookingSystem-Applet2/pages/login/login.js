const app = getApp()
Page({
    data:{
        isShow:true,
        canIUse: wx.canIUse('button.open-type.getUserInfo')
    },
    login(e){
    
        wx.getUserProfile({
          desc: 'desc',  //desc不可删除 

          success:res=>{
            if(res.userInfo){
              
                console.log(res.userInfo); //成功回调
                wx.setStorageSync('userInfo', res.userInfo),
                wx.switchTab({
                  url: '/pages/index/index',
                })
                // var user={
                //   userId:"",
                //   userName:res.userInfo.nickName,
                //   userEmail:"",
                //   userPhone:"",
                //   userHeadimg:"",
                //   userNumber:"",
                //   userPassword:"",
  
                // }

                wx.request({
                  url: 'http://localhost:8080/user/insert',
                  header: {"Content-Type": "application/x-www-form-urlencoded"},
                  method: 'post',
                  data:{
                    userName:res.userInfo.nickName
                  },
                  success: (result)=>{
                    app.globalData.userId=result.data.data;
                    console.log(result.data.data);
                  },
                  fail: ()=>{},
                  complete: ()=>{}
              })
            }
            else{

            }
          },
          fail:res=>{
            wx.showModal({
              title: '警告' ,
              content:  '您点击了拒绝授权，将无法进入小程序，请授权之后再进入!' ,
              showCancel: false,
              confirmText: '返回授权' ,
              success: function(res) {
              }
            });
          }
        })
      }
})