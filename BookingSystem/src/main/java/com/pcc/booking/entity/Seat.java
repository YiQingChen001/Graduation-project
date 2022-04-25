package com.pcc.booking.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Seat {
    private Integer seatId;
    private String cinemaName;
    private Integer hallId;
    private Integer seatRow;
    private Integer seatColumn;
    private Date time;
    private String movieName;
}
