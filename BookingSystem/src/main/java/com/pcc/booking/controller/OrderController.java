package com.pcc.booking.controller;

import com.pcc.booking.entity.Order;
import com.pcc.booking.mapper.OrderMapper;
import com.pcc.booking.reponse.CommonReturnType;
import com.pcc.booking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.pcc.booking.utils.UUIDUtil.getUUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @RequestMapping("/createorder")
    public CommonReturnType createOrder(@RequestParam("orderMovie") String orderMovie,
                                        @RequestParam("orderCinema") String orderCinema,
                                        @RequestParam("orderPrice") float orderPrice,
                                        @RequestParam("orderDate") Date orderDate,
                                        @RequestParam("orderSeats") String orderSeats,
                                        @RequestParam("userId") Long userId){

        Order order = new Order();
        order.setOrderId(getUUID());
        order.setOrderMovie(orderMovie);
        order.setOrderCinema(orderCinema);
        order.setOrderPrice(orderPrice);
        order.setOrderDate(orderDate);
        order.setOrderSeats(orderSeats);
        order.setUserId(userId);

        orderService.createOrder(order);
        return new CommonReturnType("success",null);
    }

    @RequestMapping("/orderList")
    public CommonReturnType orderList(@RequestParam("userId") Long userId){
        List<Order> orders= orderService.orderList(userId);
//        System.out.println(orders.size());
        return new CommonReturnType("success",orders);

    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器

    }
}
