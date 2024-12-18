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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 2. mapper接口参数为多个时
     *  此时myBatis会将参数放在一个map哈希表中，键值对关系如下：
     *  a. 以arg0, arg1为键，以参数为值
     *  b. 以param1, param2为键，以参数为值
     * 只需要通过${}货${}通过键的方式访问值，注意${}字符串拼接的单引号问题
     * 3. 当参数为多个时，可手动将参数放在一个map中存储，访问参数值的方式同2
     * 4. 当传参为实体类对象，参数访问方式同2，通过#{}或${}进行访问
     * 5. 使用@Param注解命名参数：自定义myBatix参数map中的键，通过@Param注解实现。存储在map中的键值对关系如下：
     *  a. 以@Param注解中的value（注解的值）为键
     *  b. 以param1, param2为键
     *  访问方式仍然可以用#{}或'${}'这两种方式
     * 综上，整合成两种情况：
     * a. 传参为实体类对象（案例4）
     * b. 传参为@Param注解及参数（案例1,2,3,5，其实都可以合并成案例5）
     */
    @Test
    public void testSelect() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserByUserName("liudehua");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLogin("liudehua", "556677");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "liudehua");
        map.put("password", "556677");
        User user = userMapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUserByDTO() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "liming", "123456", 50, "1", "liming@qq.com");
        int result = userMapper.insertUserByDTO(user);
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByParam() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.checkLoginByParam("liudehua", "556677");
        System.out.println(user);
    }
}
