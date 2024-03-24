package com.cicc.itgm;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.InvocationTargetException;

public class TestUser {

    private final Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject() {
        // 加载spring配置文件 完成对象创建
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // 获取创建对象
        User user = (User)context.getBean("user");
        System.out.println("1:" + user);

        // 调用方法
        System.out.print("2:");
        user.add();

        // 手动在控制台打印日志
        logger.debug("控制台手动打印日志信息");
        logger.info("### testUserObject Test finished ###");
        logger.info("### 测试执行完成 ###");
    }

    @Test
    public void testReflection() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("com.cicc.itgm.User");
//        User user = (User)clazz.newInstance();
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);
        System.out.println("4:user is instanceOf " + user.getClass());
    }
}
