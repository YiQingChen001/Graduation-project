package com.pcc.booking.service;

import com.pcc.booking.entity.Movie;
import com.pcc.booking.entity.Order;
import com.pcc.booking.entity.User;

import java.util.List;

public interface UserService {

    //创建用户并返回用户id
    long insertUser(User user);

    //更新用户信息并返回用户id
    long updateUser(User user);

    User selectByName(String userName);




}
