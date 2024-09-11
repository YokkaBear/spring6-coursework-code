package com.atguigu.spring6.resource.dao;

import org.springframework.stereotype.Repository;

@Repository("pgUserDao")
public class UserDaoPgImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("pg dao...");
    }
}
