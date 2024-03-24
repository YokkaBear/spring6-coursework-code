package com.cicc.iocxml.bean;

import com.cicc.iocxml.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserDao {
    private final Logger logger = LoggerFactory.getLogger(TestUserDao.class);

    @Test
    public void testUserDaoClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // test userDao
        // equals to: 接口实例 = 实现类的对象
        //   UserDao userDao = new UserDaoImpl();
        //   UserDao userDao = new PersonDaoImpl();
        // ioc getBean by class: 从类的维度获取bean，一个类/接口只能获取一个实例化bean对象
        // 如果一个类/接口getBean多次执行则会抛出expected singleton异常
        UserDao userDao = context.getBean(UserDao.class);
        logger.debug("userDao bean: " + userDao);
        userDao.run();
    }

    @Test
    public void testUserDaoImplClass() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        // test userDaoImpl & personDaoImpl
        // equals to:
        // UserDao userDaoImpl = new UserDaoImpl();
        // UserDao personDaoImpl = new personDaoImpl();
        UserDao userDaoImpl = context.getBean(UserDaoImpl.class);
        UserDao personDaoImpl = context.getBean(PersonDaoImpl.class);
        logger.debug("userDaoImpl bean: " + userDaoImpl);
        logger.debug("personDaoImpl bean: " + personDaoImpl);
        userDaoImpl.run();
        personDaoImpl.run();
    }

    @Test
    public void testUserDaoName() {
        // ioc getBean by name: 从对象的维度获取bean，逐个bean获取而不会报错
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        UserDao userDaoImpl = (UserDao)context.getBean("userDaoImpl");
        UserDao personDaoImpl = (UserDao)context.getBean("personDaoImpl");
        logger.debug("userDaoImpl: " + userDaoImpl);
        logger.debug("personDaoImpl: " + personDaoImpl);
        userDaoImpl.run();
        personDaoImpl.run();
    }
}
