package com.atguigu.mybatis.test;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestMybatis {
    @Test
    public void testsqlsessionfactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);

        SqlSession session  = sqlSessionFactory.openSession();
        try {
            Employee employee =
                    session.selectOne("suibian.selectEmployee", 1);
            System.out.println(employee);
        } finally {
            session.close();
        }
    }


    @Test
    public void testsqlsessionFactoryMapper() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        System.out.println(sqlSessionFactory);

        SqlSession session  = sqlSessionFactory.openSession();

        try {
            //Mapper接口:获取Mapper接口的 代理实现类对象
            EmployeeDao dao = session.getMapper(EmployeeDao.class);
            Employee employee = dao.getEmployeeById(1);
            System.out.println("aaaa");
            System.out.println(employee);
        } finally {
            session.close();
        }
    }

}


