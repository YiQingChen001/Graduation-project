// pages/collect/collect.js
const app=getApp();
Page({

    /**
     * 页面的初始数据
     */
    data: {
        movies:[]
    },

    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
        this.setData({
            movies:app.globalData.collect_movie
        })
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

    /**
     * 生命周期函数--监听页面初次渲染完成
     */
    onReady: function () {

    },

    /**
     * 生命周期函数--监听页面显示
     */
    onShow: function () {
        this.setData({
            movies:app.globalData.collect_movie
        })
    },

    /**
     * 生命周期函数--监听页面隐藏
     */
    onHide: function () {

    },

    /**
     * 生命周期函数--监听页面卸载
     */
    onUnload: function () {

    },

    /**
     * 页面相关事件处理函数--监听用户下拉动作
     */
    onPullDownRefresh: function () {

    },

    /**
     * 页面上拉触底事件的处理函数
     */
    onReachBottom: function () {

    },

    /**
     * 用户点击右上角分享
     */
    onShareAppMessage: function () {

    }
})