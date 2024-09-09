package com.atguigu.spring6.autowired.controller;

import com.atguigu.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // No.1 属性注入 根据类型实现注入
//    @Autowired
//    private UserService userService;

//    // No.2 setter方法注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

//    // No.3 构造方法注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // No.4 形参上注入
    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("controller...");
        userService.add();
    }
}
