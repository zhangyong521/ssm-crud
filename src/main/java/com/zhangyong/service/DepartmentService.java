package com.zhangyong.service;

import com.zhangyong.bean.Department;
import com.zhangyong.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 张勇
 * @Date 2019/12/29 20:42
 * @Version 1.0
 */
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    /**
     * 查询部门所有信息
     * @return
     */
    public List<Department> getDepts() {
        List<Department> list = departmentMapper.selectByExample (null);
        return list;
    }
}
