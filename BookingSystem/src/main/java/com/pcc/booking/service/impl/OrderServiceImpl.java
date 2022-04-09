package com.pcc.booking.service.impl;

import com.pcc.booking.entity.Order;
import com.pcc.booking.mapper.OrderMapper;
import com.pcc.booking.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Transactional//开启事务
    @Override
    public int createOrder(Order order) {
        return orderMapper.insertSelective(order);
    }

    @Override
    public List<Order> orderList(long userId) {

        return orderMapper.orderList(userId);
    }
}
