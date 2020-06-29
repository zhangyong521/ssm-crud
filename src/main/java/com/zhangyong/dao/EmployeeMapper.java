package com.zhangyong.dao;

import com.zhangyong.bean.Employee;
import com.zhangyong.bean.EmployeeExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author 17616
 */

public interface EmployeeMapper {


    /**
     * 按照条件进行统计
     *
     * @param example
     * @return
     */
    long countByExample(EmployeeExample example);

    /**
     * 按照条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(EmployeeExample example);

    /**
     * 按照主键删除
     *
     * @param empId
     * @return
     */
    int deleteByPrimaryKey(Integer empId);

    /**
     * 带有Id的添加
     *
     * @param record
     * @return
     */
    int insert(Employee record);

    /**
     * 有选择的进行添加
     *
     * @param record
     * @return
     */
    int insertSelective(Employee record);

    /**
     * 带条件的查询
     *
     * @param example
     * @return
     */
    List<Employee> selectByExample(EmployeeExample example);

    /**
     * 根据主键查询
     *
     * @param empId
     * @return
     */
    Employee selectByPrimaryKey(Integer empId);

    /**
     * 带条件的查询,并且查出部门信息
     * @param example
     * @return
     */
    List<Employee> selectByExampleWithDept(EmployeeExample example);

    /**
     * 根据Id查询,并且查出部门信息
     *
     * @param empId
     * @return
     */
    Employee selectByPrimaryKeyWithDept(Integer empId);

    /**
     * 按照条件有选择的进行更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);


    /**
     * 全更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    /**
     * 根据主键有选择的更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Employee record);

    /**
     * 按照主键全更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Employee record);
}