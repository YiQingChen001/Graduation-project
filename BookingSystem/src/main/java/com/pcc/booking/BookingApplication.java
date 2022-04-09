package com.pcc.booking;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.pcc.booking.utils.UUIDUtil.getUUID;

@SpringBootApplication
@MapperScan("com.pcc.booking.mapper")
public class BookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingApplication.class, args);
    }



}
