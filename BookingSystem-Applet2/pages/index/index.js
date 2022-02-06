//Page Object
Page({
    data: {
        hotmovie: [],
        swiperList: [
            'https://pic.ydpcdn.cn/pictures/homeparameter/2021-12/a6ca803d-9b4d-4bdd-860c-e5d83985a665.png',
            'https://pic.ydpcdn.cn/pictures/homeparameter/2021-12/91fd3fe8-04ff-46b6-b355-3490162b0d80.png',
            'https://pic.ydpcdn.cn/pictures/homeparameter/2021-12/c6d56a7c-3951-4c0d-889a-d58dd872533f.png'
        ],
        popular_movies: [],
        value:''
    },
    //options(Object)
    onLoad: function (options) {
        wx.request({
            url: 'http://localhost:8080/movie/get_hotmovie',
            header: {'content-type':'application/json'},
            method: 'GET',
            success: (result)=>{
                console.log(result.data.data)
                this.setData({
                    hotmovie:result.data.data
                })
            },
            fail: ()=>{},
            complete: ()=>{}
        })
    },
    onShow(e){
        this.setData({
            value:''
        })
        
    },
    //搜索电影
    onSearch: function (e) {

        let temp = e.detail;
        wx.request({
            url: 'http://localhost:8080/movie/getdetail',
            header: { 'content-type': 'application/json' },
            data: { movieName: temp },
            method: 'GET',
            success: (result) => {
                let status=result.data.status;
                
                if(status=="success"){
                    let movie=result.data.data;
                    wx.navigateTo({
                        url: '/pages/cinema/cinema?selectmovie=' + JSON.stringify(movie),
                        success: (result) => {

                        },
                        fail: () => {                  
                        }
                    });
                }else{
                    wx.navigateTo({
                        url: '/pages/empty/empty',
                    });
                }
                    
            },
            fail: () => {

            },
            complete: () => {

            }
        });
    },
    toMovie(e){
        let selectmovie=JSON.stringify(e.currentTarget.dataset.selectmovie);
        wx.navigateTo({
            url: '/pages/cinema/cinema?selectmovie='+selectmovie,
            success: (result) => {
            },
            fail: () => {
            },
            complete: () => {
            }
        });
    },
    //分享给好友
    onShareAppMessage(e){
        return{
            title:'',
            path:'/pages/index/index'
        }
    },
    //分享到朋友圈
    onShareTimeline(e){
        return{
            title:'',
            path:'/pages/index/index'
        }
    }
});
