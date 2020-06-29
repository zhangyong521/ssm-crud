package com.zhangyong.service;

import com.zhangyong.bean.Employee;
import com.zhangyong.bean.EmployeeExample;
import com.zhangyong.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Author 张勇
 * @Date 2019/12/27 22:25
 * @Version 1.0
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 查询所有员工
     *
     * @return
     */
    public List<Employee> getAll() {
        return employeeMapper.selectByExampleWithDept (null);
    }

    /**
     * 保存员工信息
     *
     * @param employee
     */
    public void saveEmp(Employee employee) {
        employeeMapper.insertSelective (employee);
    }

    /**
     * 校验用户名是否存在
     *
     * @param empName
     * @return true 代表可用，fasle代表不可用
     */
    public boolean checkUser(String empName) {
        EmployeeExample example = new EmployeeExample ();
        EmployeeExample.Criteria criteria = example.createCriteria ();
        criteria.andEmpNameEqualTo (empName);
        long count = employeeMapper.countByExample (example);
        return count == 0;
    }

    /**
     * 按照Id查询员工
     *
     * @param id
     * @return
     */
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey (id);
        return employee;
    }

    /**
     * 根据主键有选择的更新
     *
     * @param employee
     */
    public void updateEmp(Employee employee) {
        employeeMapper.updateByPrimaryKeySelective (employee);
    }

    /**
     * 根据主键删除
     *
     * @param id
     */
    public void deleteEmp(Integer id) {
        employeeMapper.deleteByPrimaryKey (id);
    }

    /**
     * 多个删除
     *
     * @param ids
     */
    public void deleteBatch(List<Integer> ids) {
        EmployeeExample example = new EmployeeExample ();
        EmployeeExample.Criteria criteria = example.createCriteria ();
        // 条件拼装
        criteria.andEmpIdIn (ids);
        employeeMapper.deleteByExample (example);
    }
}
