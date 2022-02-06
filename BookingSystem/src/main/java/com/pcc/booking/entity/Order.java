package com.pcc.booking.entity;

import java.util.Date;

public class Order {
    private String orderId;

    private Long userId;

    private String orderMovie;

    private String orderSeats;

    private Float orderPrice;

    private Date orderDate;

    private String orderCinema;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOrderMovie() {
        return orderMovie;
    }

    public void setOrderMovie(String orderMovie) {
        this.orderMovie = orderMovie;
    }

    public String getOrderSeats() {
        return orderSeats;
    }

    public void setOrderSeats(String orderSeats) {
        this.orderSeats = orderSeats;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderCinema() {
        return orderCinema;
    }

    public void setOrderCinema(String orderCinema) {
        this.orderCinema = orderCinema;
    }
}