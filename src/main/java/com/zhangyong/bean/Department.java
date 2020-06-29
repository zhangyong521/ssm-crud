package com.zhangyong.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author 17616
 * 部门信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Department {
    private Integer deptId;


    private String deptName;

}