package com.pcc.booking.mapper;

import com.pcc.booking.entity.Cinema;

import java.util.List;

public interface CinemaMapper {
    int deleteByPrimaryKey(Long cinemaId);

    int insert(Cinema record);

    int insertSelective(Cinema record);

    Cinema selectByPrimaryKey(Long cinemaId);

    int updateByPrimaryKeySelective(Cinema record);

    int updateByPrimaryKey(Cinema record);

    List<Cinema> cinemaList();

    Cinema selectByName(String cinemaName);
}