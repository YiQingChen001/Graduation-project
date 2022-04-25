package com.pcc.booking.service;

import com.pcc.booking.entity.Seat;

import java.util.Date;
import java.util.List;

public interface SeatService {

    List<Seat> initSeat(String cinemaName, int hallId, Date time,String movieName);
}
