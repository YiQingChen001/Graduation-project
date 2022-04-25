package com.pcc.booking.mapper;


import com.pcc.booking.entity.Seat;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface SeatMapper {

    @Select("select * from seat where cinema_name=#{cinemaName} and hall_id=#{hallId} and movie_name=#{movieName} and time=#{time}")
    List<Seat> getDetail(@Param("cinemaName") String cinemaName, @Param("hallId") Integer hallId, @Param("time") Date time,@Param("movieName") String movieName);


    @Insert("insert into seat (cinema_name,hall_id,seat_row,seat_column,time,movie_name) values(#{cinemaName},#{hallId},#{seatRow},#{seatColumn},#{time},#{movieName})")
    @Options(useGeneratedKeys=true, keyProperty="seatId")
    void insert(Seat seat);
}
