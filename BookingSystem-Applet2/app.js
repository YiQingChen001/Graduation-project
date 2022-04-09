//Page Object
App({
    globalData:{
        ticket_record:[],
        price:30,
        userId:"",
        userInfo: {
            userId:"",
            userName:"",
            userEmail:"",
            userPhone:"",
            userHeadimg:"",
            userNumber:"",
            userPassword:"",
    },
	},
  data: {
      
  },

  onLoad: function (options) {
    // var userinfo=wx.getStorageSync('userInfo')
    // if(userinfo==null){
    //   wx.navigateTo({
    //     url: 'pages/login/login',
    //   })
    // }
  },
});
