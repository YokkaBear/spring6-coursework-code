package com.atguigu.spring6.autowired.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoPgImpl implements UserDao{
    @Override
    public void add() {
        System.out.println("pg dao...");
    }
}
