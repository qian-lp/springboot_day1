package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    //登录
    @RequestMapping("login")
    public String login(User user) {
        System.out.println(user + "-----------");
        User user1 = userService.selectByName(user.getUsername());
        System.out.println(user1 + "--------");
        if (user1 == null) {
            return "loginview";
        } else if (user1.getPassword().equals(user.getPassword())) {

            return "redirect:/product/showAll";
        } else {
            return "loginview";
        }
    }

    @RequestMapping("regist")
    public String regist(User user) {
        user.setId(UUID.randomUUID().toString());
        userService.add(user);
        return "loginview";
    }
}
