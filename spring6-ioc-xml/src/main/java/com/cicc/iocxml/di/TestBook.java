package com.cicc.iocxml.di;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBook {
    @Test
    public void testSetter() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book book = context.getBean("book", Book.class);
        System.out.println(book);
    }

    @Test
    public void testConstructor() {
        // 如果bean-di.xml中通过<property>标签注入的配置不注掉 创建对象是默认调用无参构造方法
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        Book bookConstruct = context.getBean("bookConstruct", Book.class);
        System.out.println(bookConstruct);
    }
}
