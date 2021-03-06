package com.pcc.booking.service.impl;

import com.pcc.booking.entity.Cinema;
import com.pcc.booking.mapper.CinemaMapper;
import com.pcc.booking.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;
    @Override
    public Cinema getCinema(String cinemaName) {

        return cinemaMapper.selectByName(cinemaName);
    }

    /**
     * 得到所有的影院信息
     * @return 影院列表
     */
    @Override
    public List<Cinema> cinemaList() {
        return cinemaMapper.cinemaList();
    }
}
