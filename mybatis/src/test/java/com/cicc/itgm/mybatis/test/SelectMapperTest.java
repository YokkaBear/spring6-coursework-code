package com.cicc.itgm.mybatis.test;

import com.cicc.itgm.mybatis.mapper.SelectMapper;
import com.cicc.itgm.mybatis.mapper.UserMapper;
import com.cicc.itgm.mybatis.pojo.User;
import com.cicc.itgm.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    /**
     * 若查询结果条数为1条，可以用实体类对象或List或Map集合接收（User/List/Map）
     * 若查询结果条数为多条（可能为多条），则只能用集合类接收（List/Map），如果用实体类接收会报TooManyResultsException
     *   可以用实体类的List接收
     *   可以用map的List接收
     * MyBatis对 resultType 等地方用到的Java数据类型设置了类型别名，映射关系如下：
     *   java.lang.Integer -> Int, int, Integer, integer
     *   int -> _int, _integer
     *   Map -> map
     *   String -> string
     */
    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getUserById("1");
        System.out.println(users);
    }

    @Test
    public void testGetAllUsers() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> users = mapper.getAllUsers();
        System.out.println(users);
    }

    @Test
    public void getCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        int count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> result = mapper.getUserByIdToMap("1");
        System.out.println(result);
        System.out.println(result.get("id"));
        System.out.println(result.get("password"));
        System.out.println(result.get("email"));
    }

    @Test
    public void testGetAllUsersToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession("mybatis-config.xml");
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> result = mapper.getAllUsersToMap();
        System.out.println(result);
    }
}
