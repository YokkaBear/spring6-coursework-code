package com.cicc.itgm.junit4;

import com.cicc.itgm.junit5.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit4 {
    // 注入
    @Autowired
    private User user;

    // junit4测试方法
    @Test
    public void testUser() {
        System.out.println(user);
        user.run();
    }
}
