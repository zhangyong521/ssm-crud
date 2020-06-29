package com.zhangyong.dao;


import com.zhangyong.bean.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @Author 张勇
 * @Date 2019/12/27 21:21
 * @Version 1.0
 */
@RunWith (SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;

    @Test

    void countByExample() {
    }

    @Test
    void deleteByExample() {
    }

    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
        //批量生成员工
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
    for (int i=0;i<1000;i++){
        //随机生成name
        String uid = UUID.randomUUID ().toString ().substring (0, 5)+i;
        Employee employee = Employee.builder ()
                .empName (uid)
                .email (uid+"@qq.com")
                .empId (1)
                .build ();

        mapper.insertSelective (employee);
    }
    }

    @Test
    void selectByExample() {
    }

    @Test
    void selectByPrimaryKey() {
    }

    @Test
    void selectByExampleWithDept() {
    }

    @Test
    void selectByPrimaryKeyWithDept() {
    }

    @Test
    void updateByExampleSelective() {
    }

    @Test
    void updateByExample() {
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }
}