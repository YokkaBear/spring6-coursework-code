package com.atguigu.spring6.resource.service;

import com.atguigu.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service("myUserService")
public class UserServiceImpl implements UserService {

    // 2. 根据属性名称进行注入 defaultUserDao/redisUserDao/pgUserDao
//    @Resource
////    private UserDao defaultUserDao;
////    private UserDao redisUserDao;
//    private UserDao pgUserDao;

    // 3. 根据类型注入（报错：同一个类型找到了多个bean）-> 改成通过名称注入
    @Resource(name = "pgUserDao")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}
