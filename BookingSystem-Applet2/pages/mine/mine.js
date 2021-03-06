const app = getApp()

Page({
    data: {
        showShare: false,
    options: [
      [
        { name: '微信', icon: 'wechat' },
        { name: '微博', icon: 'weibo' },
        { name: 'QQ', icon: 'qq' },
      ],
      [
        { name: '复制链接', icon: 'link' },
        { name: '分享海报', icon: 'poster' },
        { name: '二维码', icon: 'qrcode' },
      ],
    ],
        userInfo: {},
    },
    onClick(event) {
        this.setData({ showShare: true });
      },
    
      onClose() {
        this.setData({ showShare: false });
      },
    
      onSelect(event) {
        Toast(event.detail.name);
        this.onClose();
      },

    onLoad() {
      var userinfo=wx.getStorageSync('userInfo')
      this.setData({
        userInfo:userinfo
      })

    },
    login(e){
    
      wx.getUserProfile({
        desc: 'desc',  
        success:res=>{

          if(res.userInfo){
              wx.setStorageSync('userInfo', res.userInfo),
              this.setData({
                userInfo:res.userInfo
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
                // header: {"Content-Type": "application/x-www-form-urlencoded"},
                method: 'post',
                data:{
                  userName:res.userInfo.nickName
                },
                success: (result)=>{
                  app.globalData.userId=result.data.data;
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
    },
    logout(){
      wx.removeStorageSync('userInfo')
      this.onLoad()
      app.globalData.userId="",
      wx.showToast({
        title: '已退出登录',

      })
    }

    
})