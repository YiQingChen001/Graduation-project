package com.pcc.booking.service;

import com.pcc.booking.entity.Order;

import java.util.List;

public interface OrderService {
    //创建订单
    int createOrder(Order order);

    List<Order> orderList(long userId);
}
