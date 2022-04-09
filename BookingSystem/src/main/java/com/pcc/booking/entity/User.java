package com.pcc.booking.entity;

import lombok.Data;

@Data
public class User {
    private Long userId;

    private String userName;

    private String userEmail;

    private String userPhone;

    private String userHeadimg;

}