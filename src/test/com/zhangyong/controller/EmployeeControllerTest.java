package com.zhangyong.controller;


import com.github.pagehelper.PageInfo;
import com.zhangyong.bean.Employee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @Author 张勇
 * @Date 2019/12/27 22:52
 * @Version 1.0
 * 使用Spring测试模块提供的测试请求功能，测试crud请求的准确性
 * spring4测试的时候，需要3.0以上的Servlet Api以上
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:spring-mvc.xml"})
public class EmployeeControllerTest {

    //传入SpringMVC的ioc
    @Autowired
    WebApplicationContext context;
    //虚拟MVC请求，获取到处理结果
    MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup (context).build ();
    }

    @Test
    public void getEmps() throws Exception {
        //模拟请求拿到的返回值
        MvcResult result = mockMvc.perform (MockMvcRequestBuilders.get ("/emps").param ("pn", "1"))
                .andReturn ();
        //请求成功以后，请求域中会有PageInfo，取出pageInfo进行验证
        MockHttpServletRequest request = result.getRequest ();
        PageInfo pi = (PageInfo) request.getAttribute ("pageInfo");
        System.out.println ("当前页码：" + pi.getPageNum ());
        System.out.println ("总页码" + pi.getPages ());
        System.out.println ("总记录数" + pi.getTotal ());
        System.out.println ("在页面需要连续显示的页码");
        int[] nums = pi.getNavigatepageNums ();
        for (int num : nums) {
            System.out.print (" " + num);
        }

        //获取员工数据
        List<Employee> list = pi.getList ();
        for (Employee employee : list) {
            System.out.println ("ID:" + employee.getEmpId () + "====>Name:" + employee.getEmpName ());
        }
    }
}