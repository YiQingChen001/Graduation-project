package com.pcc.booking.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String orderId;

    private Long userId;

    private String orderMovie;

    private String orderSeats;

    private Float orderPrice;

    private Date orderDate;

    private String orderCinema;


}