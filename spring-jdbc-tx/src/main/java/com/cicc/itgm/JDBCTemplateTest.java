package com.cicc.itgm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.junit.jupiter.api.Test; // 引入junit5的包才能从SpringJUnitConfig导入配置文件及定义的bean

import java.util.List;

@SpringJUnitConfig(locations = "classpath:beans.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    //测试增删改功能
    public void testUpdate(){
        // 添加功能
//        String sql1 = "insert into spring.employee values(null,?,?,?)";
//        int result1 = jdbcTemplate.update(sql1, "陶喆", 30, "男");
//        System.out.println(result1);

        // 修改功能
//        String sql2 = "update spring.employee set age=? where name=?";
//        int result2 = jdbcTemplate.update(sql2, "42", "陶喆");
//        System.out.println(result2);

        // 删除功能
        String sql3 = "delete from spring.employee where id=?";
        int result3 = jdbcTemplate.update(sql3, 2);
        System.out.println(result3);
    }

    // 查询返回单个对象
    @Test
    public void testSelectObject() {
        // 写法1
        String sql = "select * from spring.employee where id=?";
        Employee result =  jdbcTemplate.queryForObject(
                sql,
                (rs, rowNum) -> Employee.builder()
                        .id(rs.getInt("id"))
                        .age(rs.getInt("age"))
                        .sex(rs.getString("sex"))
                        .name(rs.getString("name"))
                        .build(),
                3
        );
        System.out.println(result);

        // 写法2
//        String sql = "select * from spring.employee where id=?";
//        Employee employee = jdbcTemplate.queryForObject(
//                sql,
//                new BeanPropertyRowMapper<>(Employee.class),
//                4
//        );
//        System.out.println(employee);
    }

    // 查询返回列表
    @Test
    public void testSelectList() {
        String sql = "select * from spring.employee";
        List<Employee> result = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(Employee.class)
        );
        result.stream().map(Employee::getName).forEach(System.out::println);
    }

    @Test
    public void selectCount() {
        String sql = "select count(id) from spring.employee";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(count);
    }

    @Test
    public void selectMax() {
        String sql = "select max(age) from spring.employee";
        Integer age = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(age);
    }
}
