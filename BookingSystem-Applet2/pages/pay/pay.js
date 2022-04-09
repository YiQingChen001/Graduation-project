
const app=getApp();
Page({

 
    data: {
        ticket:{},
        total_price:'',
        phonenumber:'',
        checked: false,
        instruction_content:'1.付款成功后30分钟内为您出票\n2.请确认购买时间、场次和手机号码无误，付款成功后不支持退票、改签\n3.出票成功后系统会通过微信服务通知提醒您，点击通知进入可查看取票信息，在影院任意自助机或前台取票\n4.用户下单即同意《用户协议》'
        
    },
    getnumber(e){
      this.setData({
        phonenumber:e.detail.value
      })
    },
    toPay(e){
      var num=this.data.phonenumber;
      var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1})|(17[0-9]{1}))+\d{8})$/;//判断电话号码合法
      if(num==''){//如果未输入电话号码
          wx.showModal({
            title: '',
            content: '电话号码不能为空',
            success (res) {
            }
          })
      }else if(!myreg.test(num)){//如果电话号码不合法
        wx.showModal({
          title: '',
          content: '电话号码不合法',
          success (res) {
          }
        })
      }
      else{//当前输入的电话号码合法，去支付并生成订单
        var temp=new Array();
        var ticket=this.data.ticket;
        console.log(ticket);
        ticket.phonenumber=this.data.phonenumber;
        temp.push(ticket);
        app.globalData.ticket_record=temp;

        wx.showModal({
          title:'提示',
          content:'支付功能未能实现',
          success:res=>{
            
          }
        })
        var position=this.data.ticket.ticketHall;
        var seats=this.data.ticket.ticketSeats;
        for(var i=0;i<seats.length;i++){
          position+=seats[i].x+'排'+seats[i].y+'座 '
        }
        wx.request({
          url: 'http://localhost:8080/order/createorder',
          data: {
            orderMovie:this.data.ticket.ticketMovie,
            orderCinema:this.data.ticket.ticketCinema,
            orderPrice:this.data.ticket.ticketPrice*this.data.ticket.ticketSeats.length,
            orderDate:this.data.ticket.ticketDay+' '+this.data.ticket.ticketTime+':00',
            orderSeats:position,
            userId:app.globalData.userId

          },
          header: {
            // 'content-type':'application/json'
            'content-type': 'application/x-www-form-urlencoded' 
        },
          method: 'post',
          success: (result)=>{
            
          },
          fail: ()=>{},
          complete: ()=>{}
        });
      } 
    },
    onChange(event) {
      this.setData({
        checked: event.detail,
      });
    },
    onLoad: function (e) {
        let ticket=JSON.parse(e.ticket);
        this.setData({
            ticket:ticket
        })
    },
})