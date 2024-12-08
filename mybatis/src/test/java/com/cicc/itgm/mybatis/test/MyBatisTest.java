package com.cicc.itgm.mybatis.test;

import com.cicc.itgm.mybatis.mapper.UserMapper;
import com.cicc.itgm.mybatis.pojo.User;
import com.cicc.itgm.mybatis.utils.SqlSessionUtil;
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

    @Test
    public void testCRUD1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.getAllUsers();
        users.forEach(System.out::println);
    }

    /**
     * MyBatis获取参数值的两种方式：${} 或 #{}
     * ${} 本质上是字符串拼接
     * #{} 本质上是占位符赋值
     * MyBatis获取参数类型的各种情况
     * 1. mapper接口方法参数为单个字面量参数
     *  可通过${}或#{}以任意名称（最好见名识义）获取参数值，需要注意${}的单引号问题
     * todo
     */
    @Test
    public void testSelect() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUserName("liudehua");
        System.out.println(user);
    }
}
