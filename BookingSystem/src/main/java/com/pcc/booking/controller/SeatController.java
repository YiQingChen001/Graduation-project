package com.pcc.booking.controller;

import com.pcc.booking.entity.Seat;
import com.pcc.booking.reponse.CommonReturnType;
import com.pcc.booking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @RequestMapping("getAll")
    public CommonReturnType getAll(@RequestParam("cinemaName") String cinemaName,
                                   @RequestParam("hallId") Integer hallId,
                                   @RequestParam("time")Date time,
                                   @RequestParam("movieName") String movieName){

        List<Seat> seats = seatService.initSeat(cinemaName, hallId, time,movieName);
        return new CommonReturnType("success",seats);
    }
    //将前端传过来的String转为Date类型
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器

    }
}
