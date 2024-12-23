package com.cicc.itgm.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:bean.xml")
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit5 {
    // 注入User对象
    @Autowired
    private User user;

    // junit5测试方法
    @Test
    public void testUser() {
        System.out.println(user);
        user.run();
    }

}
