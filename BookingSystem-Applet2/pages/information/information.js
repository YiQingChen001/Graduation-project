const app = getApp()

Page({
    data: {
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


    onLoad() {
      var userinfo=wx.getStorageSync('userInfo')
      var stringName="userInfo.userName"
      var stringId="userInfo.userId"
      var stringImg="userInfo.userHeadimg"
      this.setData({
        imageUrl:userinfo.avatarUrl,
        [stringName]:userinfo.nickName,
        [stringId]:app.globalData.userId,
        [stringImg]:userinfo.avatarUrl,
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
    },
    getnumber(e){
        var stringPhone="userInfo.userPhone"
        this.setData({
          [stringPhone]:e.detail.value
        })
      },
      getName(e){
        var stringName="userInfo.userName"
        this.setData({
            [stringName]:e.detail.value
          })

      },
      getemail(e){
        var stringEmail="userInfo.userEmail"
        this.setData({
            [stringEmail]:e.detail.value
          })

      },
      submitInformation(e){
          wx.showToast({
            title: '保存成功',
            icon:'success'
          })
          console.log(this.data.userInfo)
          wx.request({
            url: 'http://localhost:8080/user/update',
            data: this.data.userInfo,
            header: {
              'content-type':'application/json'
            //   'content-type': 'application/x-www-form-urlencoded' 
          },
            method: 'post',
            success: (result)=>{
              
            },
            fail: ()=>{},
            complete: ()=>{}
          });
      }
    
})