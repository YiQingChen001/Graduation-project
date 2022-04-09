package com.pcc.booking.controller;

import com.pcc.booking.entity.Ticket;
import com.pcc.booking.mapper.TicketMapper;
import com.pcc.booking.reponse.CommonReturnType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/price")
public class TicketController {

    @Autowired
    private TicketMapper ticketMapper;
    @PostMapping("/getprice")
    public CommonReturnType getPrice(@RequestParam("ticketMovie") String ticketMovie,
                                     @RequestParam("ticketCinema") String ticketCinema){
        BigDecimal price = ticketMapper.getPrice(ticketMovie, ticketCinema);
        return new CommonReturnType("success",price);
    }


}
