package com.zhangyong.dao;

import com.zhangyong.bean.Department;
import com.zhangyong.bean.DepartmentExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author 17616
 */
public interface DepartmentMapper {
    /**
     * 根据条件查询总条数
     *
     * @param example
     * @return
     */
    long countByExample(DepartmentExample example);

    /**
     * 根据条件删除
     *
     * @param example
     * @return
     */
    int deleteByExample(DepartmentExample example);

    /**
     * 根据主键删除
     *
     * @param deptId
     * @return
     */
    int deleteByPrimaryKey(Integer deptId);

    /**
     * 全插入
     *
     * @param record
     * @return
     */
    int insert(Department record);

    /**
     * 带条件的插入
     *
     * @param record
     * @return
     */
    int insertSelective(Department record);

    /**
     * 带条件的查询
     *
     * @param example
     * @return
     */
    List<Department> selectByExample(DepartmentExample example);

    /**
     * 根据主键进行查询
     *
     * @param deptId
     * @return
     */
    Department selectByPrimaryKey(Integer deptId);

    /**
     * 带条件有选择的更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    /**
     * 带条件的更新
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    /**
     * 根据主键有选择的进行更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Department record);

    /**
     * 根据主键进行更新
     *
     * @param record
     * @return
     */
    int updateByPrimaryKey(Department record);
}