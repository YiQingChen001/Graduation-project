package com.pcc.booking.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Ticket {
    private Integer ticketId;
    private  String ticketMovie;
    private  String ticketCinema;
    private BigDecimal price;
}
