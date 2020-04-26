package com.atguigu.mybatis.dao;

import com.atguigu.mybatis.beans.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface EmployeeMapper {

    //根据id查询Employee
    public Employee getEmployeeById(Integer id );

    //添加一个新的Employee
    public void addEmployee(Employee employee);

    //修改一个Employee
    public void updateEmployee(Employee employee);

    //删除一个Employee
    public Boolean   deleteEmployeeById(Integer id );

}
