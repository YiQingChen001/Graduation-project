package com.pcc.booking.service;

import com.pcc.booking.entity.Movie;
import com.pcc.booking.entity.Order;
import com.pcc.booking.entity.User;

import java.util.List;

public interface UserService {

    long insertUser(User user);

    long updateUser(User user);

    User selectByName(String userName);


}
