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
    }

}
