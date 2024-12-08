package com.cicc.itgm.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtil {
    public static SqlSession getSqlSession(String configFile) {
        SqlSession sqlSession = null;
        try {
            InputStream is = Resources.getResourceAsStream(configFile);
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
            sqlSession = sqlSessionFactory.openSession(true); // 事务自动提交 autoCommit
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
