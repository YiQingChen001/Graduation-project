package com.pcc.booking.service.impl;

import com.pcc.booking.entity.Order;
import com.pcc.booking.entity.Seat;
import com.pcc.booking.mapper.OrderMapper;
import com.pcc.booking.mapper.SeatMapper;
import com.pcc.booking.service.OrderService;
import com.pcc.booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private SeatService seatService;

    @Autowired
    private SeatMapper seatMapper;

    /**
     * 创建订单
     * @param order
     * @return
     */
    @Transactional//开启事务
    @Override
    public int createOrder(Order order) {
        String[] arr=order.getOrderSeats().split("\\s+");
        String hall=arr[0];
        for(int i=1;i<arr.length;i++){
            Seat seat = new Seat();
            seat.setCinemaName(order.getOrderCinema());
            seat.setHallId(hall.charAt(0)-'0');
            seat.setTime(order.getOrderDate());
            seat.setSeatRow(arr[i].charAt(0)-'0');
            seat.setSeatColumn(arr[i].charAt(2)-'0');
            seat.setMovieName(order.getOrderMovie());
            seatMapper.insert(seat);
        }

        return orderMapper.insertSelective(order);

    }

    /**
     * 根据用户id得到该用户的订单列表
     * @param userId
     * @return 订单列表
     */
    @Override
    public List<Order> orderList(long userId) {
        return orderMapper.orderList(userId);
    }
}
