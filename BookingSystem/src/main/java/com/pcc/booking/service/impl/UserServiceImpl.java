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

    /**
     * 根据用户得到用户id
     * @param user
     * @return 用户id
     */
    @Override
    @Transactional
    public long insertUser(User user) {
        //根据传进来的用户名称查询用户是否存在
        User user1 = selectByName(user.getUserName());
        //如果用户不存在，就执行插入语句，并得到用户id返回；否则就直接返回用户id
        if(user1==null) {
            userMapper.insertSelective(user);
            return user.getUserId();
        }
        return user1.getUserId();

    }

    /**
     * 更新用户信息
     * @param user
     * @return 用户id
     */
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
