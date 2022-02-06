package com.pcc.booking.controller;

import com.pcc.booking.entity.Order;
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
                                        @RequestParam("orderSeats") String orderSeats){

        Order order = new Order();
        order.setOrderId(getUUID());
        order.setOrderMovie(orderMovie);
        order.setOrderCinema(orderCinema);
        order.setOrderPrice(orderPrice);
        order.setOrderDate(orderDate);
        order.setOrderSeats(orderSeats);

        orderService.createOrder(order);
        System.out.println(order.toString());
        return new CommonReturnType("success",null);
    }
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器

    }
}
