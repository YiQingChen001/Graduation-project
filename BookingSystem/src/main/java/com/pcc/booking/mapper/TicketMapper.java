package com.pcc.booking.mapper;


import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.math.BigDecimal;


public interface TicketMapper {
    @Select("select price from ticket where ticket_movie=#{ticketMovie} and ticket_cinema=#{ticketCinema}")
    public BigDecimal getPrice(@Param("ticketMovie") String ticketMovie,
                               @Param("ticketCinema") String ticketCinema);


}
