package com.atguigu.spring6.autowired.service;

import com.atguigu.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//     No.1 属性注入 通过Qualifier注解指定注入类型的实现类
    @Autowired
    @Qualifier("userDaoPgImpl")
    private UserDao userDao;

//    // No.2 setter方法注入
//    private UserDao userDao;
//
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    // No.3 构造方法注入 通过Qualifier注解指定注入类型的实现类
//    private UserDao userDao;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    // No.4 形参上注入
//    private UserDao userDao;
//
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

//    // No.5 当只有一个有参构造函数，无需注解即可注入
//    private UserDao userDao;
//
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void add() {
        System.out.println("service...");
        userDao.add();
    }
}
