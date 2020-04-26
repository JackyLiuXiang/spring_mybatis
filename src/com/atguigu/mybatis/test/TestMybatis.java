package com.atguigu.mybatis.test;

import com.atguigu.mybatis.beans.Employee;
import com.atguigu.mybatis.dao.EmployeeMapper;
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

    public SqlSessionFactory getSqlSessionFactory() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Test
    public void testCRUD() throws Exception {
        SqlSessionFactory ssf = getSqlSessionFactory();

        SqlSession session = ssf.openSession();
        //ssf.openSession(true);

        try {
            //获取Mapper接口的代理实现类对象
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
            //查询
            Employee employee =mapper.getEmployeeById(1);
            System.out.println(employee);

            //添加

//			employee  =
//						new Employee(null, "苍老师", "cls@sina.com", "1");
//			mapper.addEmployee(employee);
//			System.out.println("返回的主键值: " + employee.getId());
			/*
			JDBC操作获取新插入数据的主键值:
			Connection conn = null ;
			PreparedStatement  ps = conn.prepareStatement("sql", PreparedStatement.RETURN_GENERATED_KEYS);
			ps.executeUpdate();
			ps.getGeneratedKeys();
			*/
            //修改
//			 employee  =
//					new Employee(3, "敏敏", "mm@sina.com", "0");
//			mapper.updateEmployee(employee);

            //删除

			Boolean  result= mapper.deleteEmployeeById(1);
			System.out.println(result );



            //提交
            session.commit();
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
            EmployeeMapper dao = session.getMapper(EmployeeMapper.class);
            Employee employee = dao.getEmployeeById(1);
            System.out.println("aaaa");
            System.out.println(employee);
        } finally {
            session.close();
        }
    }

}


