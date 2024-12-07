package com.cicc.itgm.mybatis.test;

import com.cicc.itgm.mybatis.mapper.UserMapper;
import com.cicc.itgm.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void testMyBatis() throws IOException {
        // 1. 加载配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 2. 创建SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 3. 创建SqlSessionFactory （基于inputStream）
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        // 4. 创建SqlSession
        SqlSession session = sqlSessionFactory.openSession(true); // 自动提交事务
        // 5. 创建mapper接口对象
        UserMapper mapper = session.getMapper(UserMapper.class);
        // 6. 执行sql语句
        int result = mapper.insertUser();
        /*// 7. 手动提交事务（通过SqlSession）
        session.commit();*/
        // 8. 检查返回结果
        System.out.println("result is " + result);
    }

    @Test
    public void testCRUD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        int result = mapper.updateUser(); // 测试更新User表
//        int result = mapper.deleteUser(); // 测试删除User表数据
//        User user = mapper.getUserById(); // 测试查询User表单条记录
        List<User> users = mapper.getAllUsers(); // 测试查询User全表数据
//        System.out.println("result is " + result);
//        System.out.println(user);
        users.forEach(System.out::println);
    }
}
