const app=getApp();
Page({


    data: {
        orders:[]
    },

    onLoad: function (options) {
        // this.setData({
        //     orders:app.globalData.ticket_record
        // })
        // console.log(this.data.orders);
        
    },

    onShow: function () {
        // this.setData({
        //     orders:app.globalData.ticket_record
        // })
        wx.request({
            url: 'http://localhost:8080/order/orderList',
            header: {"Content-Type": "application/x-www-form-urlencoded"},
            method: 'post',
            data:{
              userId:app.globalData.userId
            },
            success: (result)=>{
              console.log(result.data.data)
              this.setData({
                  orders:result.data.data
              })
              
            },
            fail: ()=>{},
            complete: ()=>{}
        })
    },

})