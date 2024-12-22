package com.cicc.itgm.springAop.xmlAop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCalculator {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beanAop.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.add(3, 5);
        System.out.println("Add result is " + result);
    }
}
