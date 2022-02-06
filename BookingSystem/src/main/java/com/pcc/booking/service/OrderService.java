package com.pcc.booking.service;

import com.pcc.booking.entity.Order;

public interface OrderService {
    //创建订单
    int createOrder(Order order);
}
