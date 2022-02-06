const app=getApp();
Page({


    data: {
        orders:[]
    },

    onLoad: function (options) {
        this.setData({
            orders:app.globalData.ticket_record
        })
        console.log(this.data.orders);
    },

    onShow: function () {
        this.setData({
            orders:app.globalData.ticket_record
        })
    },

})