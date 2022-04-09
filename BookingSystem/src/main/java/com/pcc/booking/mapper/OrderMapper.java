package com.pcc.booking.mapper;

import com.pcc.booking.entity.Order;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    @Select("select * from ticket_order where user_id=#{userId}")
    List<Order> orderList(Long userId);
}