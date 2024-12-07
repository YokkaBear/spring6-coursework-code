package com.cicc.itgm.mybatis.pojo;

/**
 * 映射类
 */
public class User {
    private Integer id;
    private String userName;
    private String password;
    private Integer age;
    private String sex;
    private String email;

    public User(Integer id, String userName, String password, Integer age, String sex, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.email = email;
    }

    public User() {}

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
