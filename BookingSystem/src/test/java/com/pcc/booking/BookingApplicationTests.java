package com.pcc.booking;

import com.pcc.booking.mapper.TicketMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookingApplicationTests {

    @Autowired
    private TicketMapper ticketMapper;
    @Test
    void contextLoads() {

        String s="1排2座";
        System.out.println(s.length());
        System.out.println(s.charAt(1));
    }

}
