package com.pcc.booking.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.pcc.booking.entity.User;
import com.pcc.booking.mapper.UserMapper;
import com.pcc.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    @Transactional
    public long insertUser(User user) {
        User user1 = selectByName(user.getUserName());
        if(user1==null) {
            userMapper.insertSelective(user);
            return user.getUserId();
        }
        return user1.getUserId();

    }

    @Override
    public long updateUser(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return user.getUserId();
    }

    @Override
    public User selectByName(String userName) {
        return userMapper.selectByName(userName);

    }
}
