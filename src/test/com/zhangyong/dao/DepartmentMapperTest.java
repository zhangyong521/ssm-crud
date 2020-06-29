package com.zhangyong.dao;

import com.zhangyong.bean.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @Author 张勇
 * @Date 2019/12/27 20:46
 * @Version 1.0
 * 推荐使用spring的单元测试，可以自动生成组件
 * 1、导入springTest模块
 * 2、@ContextConfiguration指定spring配置文件的位置
 * 3、直接@Autowired要使用的组件进行注入
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class DepartmentMapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void countByExample() {
        System.out.println (departmentMapper);
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
        departmentMapper.insertSelective (new Department (null, "外呼部"));
        departmentMapper.insertSelective (new Department (null,"后勤部"));
    }

    @Test
    public void selectByExample() {
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}