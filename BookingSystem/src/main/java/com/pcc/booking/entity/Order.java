package com.pcc.booking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String orderId;

    private Long userId;

    private String orderMovie;

    private String orderSeats;

    private Float orderPrice;

    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderDate;

    private String orderCinema;


}