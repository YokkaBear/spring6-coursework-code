package com.cicc.itgm.springAop.annotationAop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestCalculator {

    @Test
    public void testAdd() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.add(3, 5);
        System.out.println("Add result is " + result);
    }

    @Test
    public void testSub() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.sub(5, 3);
        System.out.println("Sub result is " + result);
    }

    @Test
    public void testMul() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.mul(5, 6);
        System.out.println("Mul result is " + result);
    }

    @Test
    public void testDiv() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Calculator calculator = context.getBean(Calculator.class);
        int result = calculator.div(12, 0);
        System.out.println("Div result is " + result);
    }
}
