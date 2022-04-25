package com.pcc.booking.service.impl;

import com.pcc.booking.entity.Seat;
import com.pcc.booking.mapper.SeatMapper;
import com.pcc.booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;
    @Override
    public List<Seat> initSeat(String  cinemaName, int hallId, Date time,String movieName) {
        return seatMapper.getDetail(cinemaName,hallId,time,movieName);
    }
}
