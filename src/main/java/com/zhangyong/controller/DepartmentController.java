package com.zhangyong.controller;

import com.zhangyong.bean.Department;
import com.zhangyong.bean.Msg;
import com.zhangyong.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author 张勇
 * @Date 2019/12/29 20:39
 * @Version 1.0
 * 处理部门的Controller
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts() {
        /**
         * 查询出所有部门的信息
         */
        List<Department> list = departmentService.getDepts ();
        if (list != null) {
            return Msg.success ().add ("depts", list);
        } else {
            return Msg.fail ();
        }
    }
}
