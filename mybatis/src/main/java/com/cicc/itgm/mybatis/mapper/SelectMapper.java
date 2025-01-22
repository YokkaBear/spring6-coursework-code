package com.cicc.itgm.mybatis.mapper;

import com.cicc.itgm.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /**
     * @param id 用户id
     * @return User的List集合
     * 按id查询用户信息
     */
    List<User> getUserById(@Param("id") String id);

    /**
     * @return User的List集合
     * 查询所有的用户信息
     */
    List<User> getAllUsers();

    /**
     * @return 用户记录总条数
     */
    Integer getCount();

    /**
     * @param id 用户唯一id
     * @return 单个用户信息用Map类型返回，其中key为单条记录字段名，value为单条记录字段值
     */
    Map<String, Object> getUserByIdToMap(@Param("id") String id);

    /**
     * @return 返回全部用户信息并组装成map
     * Note: 如果返回结果为多个map（多条数据记录的键值对），要么将返回值声明成map的List集合，要么用@MapKey注解返回以某个字段为key的map
     */
//    List<Map<String, Object>> getAllUsersToMap();
    @MapKey("id")
    Map<String, Object> getAllUsersToMap();
}
