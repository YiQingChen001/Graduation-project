package com.pcc.booking.controller;

import com.pcc.booking.entity.Cinema;
import com.pcc.booking.reponse.CommonReturnType;
import com.pcc.booking.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cinema")
public class CinemaController {

//    @RequestMapping("/getAddressDetail")
//    public CommonReturnType getAddressDetail(@RequestParam("cinemaAddress") String cinemaAddress){
//    }

    @Autowired
    private CinemaService cinemaService;

    @RequestMapping("/cinema_list")
    public CommonReturnType getAllCinema(){
        List<Cinema> cinemas = cinemaService.cinemaList();
        return new CommonReturnType("success",cinemas);
    }
}
