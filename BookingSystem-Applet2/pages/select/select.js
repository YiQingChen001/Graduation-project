
Page({
    data: {
        seat_position: [],//电影院座位数组
        select_seats: [],//被选中的位置数组    
        movie: {},
        ticket:{
            ticketMovie:'',
            ticketSeats:[],
            ticketCinema:'',
            ticketAddress:'',
            ticketPicture:'',
            ticketPrice:'',
            ticketDay:'',
            ticketHall:'',
            ticketTime:''
        }
    },
    //初始化影院座位表
    init(){
        var row = 8;//电影院座位的行数
        var col = 11;//电影院座位的列数
        var temp = {};
        var seat_position = new Array(row);
        //遍历电影院所有座位进行初始化
        for (var i = 0; i < row; i++) {
            seat_position[i] = new Array(col);
            for (var j = 0; j < col; j++) {
                temp.num = j;
                temp.src = "before-select.png";
                seat_position[i][j] = temp;
                temp = {};
            }
        }
        this.setData({
            seat_position: seat_position
        })
    },
    onLoad(e) {
        let temp=JSON.parse(e.address);
        
        this.setData({
            movie: JSON.parse(e.selectmovie),
            ['ticket.ticketCinema']:temp.cinemaName,
            ['ticket.ticketAddress']:temp.cinemaAddress,
            ['ticket.ticketDay']:e.day,
            ['ticket.ticketHall']:e.hall,
            ['ticket.ticketTime']:e.time,
        })
        this.init();
        //根据电影和影院得到票价
        wx.request({
            url: 'http://localhost:8080/price/getprice',
            data: {
                ticketMovie:this.data.movie.movieName,
                ticketCinema:this.data.ticket.ticketCinema,
            },
            header: {
              // 'content-type':'application/json'
              'content-type': 'application/x-www-form-urlencoded' 
          },
            method: 'post',
            success: (res)=>{
                if(res.data.data){
                    this.setData({
                        ['ticket.ticketPrice']:res.data.data
                    })

                }
                //票价默认为30
                else{
                    this.setData({
                        ['ticket.ticketPrice']:30
                    })
                }
                
                console.log(this.data.ticket.ticketPrice)
            },
            fail: ()=>{},
            complete: ()=>{}
          });
    },
    onChange(event) {
        this.setData({
            checked: event.detail,
        });
    },
    //点击座位时
    getPosition(e) {
        //当前鼠标点击位置的坐标
        var seat_src = e.currentTarget.dataset.src;
        var seat_location = {
            x: e.currentTarget.dataset.x + 1,
            y: e.currentTarget.dataset.y + 1,
        }
        var src = 'seat_position[' + e.currentTarget.dataset.x + '][' + e.currentTarget.dataset.y + '].src'
        if (seat_src == "before-select.png") {
            var arr = new Array();
            if (this.data.select_seats.length < 4) {
                arr = this.data.select_seats;
                arr.push(seat_location);
                this.setData({
                    [src]: "after-select.png",
                    select_seats: arr
                })
                wx.showToast({
                    title: (e.currentTarget.dataset.x + 1) + '排 ' + (e.currentTarget.dataset.y + 1) + '座',
                    icon: 'none'
                })
            } else {
                wx.showToast({
                    title: '每人限购4张',
                    icon: 'none'
                })
            }

        } else if (seat_src == "after-select.png") {

            var arr = new Array();
            arr = this.data.select_seats;
            for (var i = 0; i < arr.length; i++) {
                if (arr[i].x == seat_location.x && arr[i].y == seat_location.y) {
                    arr.splice(i, 1);
                }
            }
            this.setData({
                [src]: "before-select.png",
                select_seats: arr
            })
            wx.showToast({
                title: '已取消',
                icon: 'none'
            })


        } else if (seat_src == "no-select.png") {
            wx.showToast({
                title: '该位置不可选',
                icon: 'none'
            })
        }
    },
    delete(e) {
        var seat_location = e.currentTarget.dataset.position
        var arr = new Array();
        var src = 'seat_position[' + (seat_location.x - 1) + '][' + (seat_location.y - 1) + '].src'
        arr = this.data.select_seats;
        for (var i = 0; i < arr.length; i++) {
            if (arr[i].x == seat_location.x && arr[i].y == seat_location.y) {
                arr.splice(i, 1);
            }
        }
        this.setData({
            [src]: "before-select.png",
            select_seats: arr
        })
    },
    //确认选座
    confirmseat(e) {
        
        this.setData({
            ['ticket.ticketMovie']:this.data.movie.movieName,
            ['ticket.ticketPicture']:this.data.movie.moviePicture,
            //这里需要注意一下，如果没有下面这句，当在支付界面返回到选座界面再取消座位时再去支付界面，会出现票数未变的情况
            ['ticket.ticketSeats']:[],

        })
        for(var i=0;i<this.data.select_seats.length;i++){
            var xx='ticket.ticketSeats['+i+'].x'
            var yy='ticket.ticketSeats['+i+'].y'
            this.setData({
                [xx]:this.data.select_seats[i].x,
                [yy]:this.data.select_seats[i].y,
            })
        }
        console.log(this.data.ticket);
        let ticket=JSON.stringify(this.data.ticket);
        wx.navigateTo({
            url: '/pages/pay/pay?ticket='+ticket,
            success: (result) => {
            },
            fail: () => {
            },
            complete: () => {
            }
          });
    }
    

});
