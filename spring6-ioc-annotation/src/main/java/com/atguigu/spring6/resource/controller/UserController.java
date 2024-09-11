package com.atguigu.spring6.resource.controller;

import com.atguigu.spring6.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    // 1. 根据名称name注入
//    @Resource(name = "myUserService")
//    private UserService userService;

    // 3. 根据类型注入
    @Resource
    private UserService userService;

    public void add() {
        System.out.println("controller...");
        userService.add();
    }
}
