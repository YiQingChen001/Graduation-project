package com.pcc.booking.controller;


import com.pcc.booking.entity.User;
import com.pcc.booking.mapper.UserMapper;
import com.pcc.booking.reponse.CommonReturnType;
import com.pcc.booking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("update")
    public CommonReturnType update(@RequestBody User user){
        userService.updateUser(user);
        return new CommonReturnType("success",null);
    }

    @RequestMapping("insert")
    public CommonReturnType insertUser(@RequestParam("userName") String userName){
        User user = new User();
        user.setUserName(userName);
        long userId = userService.insertUser(user);

        return new CommonReturnType("success",userId);

    }
}
