package com.pcc.booking.service;

import com.pcc.booking.entity.Cinema;

import java.util.List;

public interface CinemaService {

    Cinema getCinema(String cinemaName);

    List<Cinema> cinemaList();
}
