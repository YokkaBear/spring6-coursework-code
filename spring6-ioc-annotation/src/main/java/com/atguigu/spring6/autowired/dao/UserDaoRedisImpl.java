package com.atguigu.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoRedisImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao redis...");
    }
}
