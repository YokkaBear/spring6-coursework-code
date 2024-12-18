package com.cicc.itgm.mybatis.mapper;

import com.cicc.itgm.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * mapper映射接口
 */
public interface UserMapper {
    // 一、两个一致
    // 1. mapper映射文件的namespace和mapper接口全类名一致
    // 2. 映射文件中sql语句的id与mappder接口的方法名一致
    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 删除用户信息
     */
    int deleteUser();

    /**
     * 查询单个用户信息
     */
    User getUserById();

    /**
     * 查询全部用户信息
     */
    List<User> getAllUsers();

    /**
     * 根据用户名查询用户信息
     */
    User getUserByUserName(String userName);

    /**
     * 用户登录验证
     */
    User checkLogin(String userName, String password);

    /**
     * 用户登录验证（传参为Map）
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 通过实体类插入数据（传参为User对象）
     */
    Integer insertUserByDTO(User user);

    /**
     * 通过@Param命名参数的方式执行查询
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
