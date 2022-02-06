// pages/movie/movie.js
const app=getApp();
Page({

    /**
     * 热映电影的信息
     */
    data: {
        allMovies: []
    },
    //初始化所有正在上映的影片
    onShow() {
         wx.request({
            url: 'http://localhost:8080/movie/movies_list',
            header: {'content-type':'application/json'},
            method: 'GET',
            success: (result)=>{
                console.log(result.data.data)
                this.setData({
                    allMovies:result.data.data
                })
            },
            fail: ()=>{},
            complete: ()=>{}
        });

    },
    toCinemas(e){
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
    }

})