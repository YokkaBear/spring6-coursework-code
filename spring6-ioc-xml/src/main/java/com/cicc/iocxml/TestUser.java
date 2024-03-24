package com.cicc.iocxml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Logger logger = LoggerFactory.getLogger(TestUser.class);

        // 根据id获取bean
        User user1 = (User)context.getBean("user");
        logger.info("根据id获取bean: " + user1);

        // 根据class获取bean
        User user2 = context.getBean(User.class);
        logger.info("根据class获取bean: " + user2);

        // 根据id和类型获取bean
        User user3 = context.getBean("user", User.class);
        logger.info("根据id和类型获取bean: " + user3);

    }
}
