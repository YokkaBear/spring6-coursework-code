package com.atguigu.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository("redisUserDao")
public class UserDaoRedisImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("redis dao...");
    }
}
