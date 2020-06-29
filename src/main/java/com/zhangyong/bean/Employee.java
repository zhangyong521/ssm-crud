package com.zhangyong.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Pattern;

/**
 * @author 17616
 * 员工信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Employee {
    private Integer empId;

    @Pattern(regexp = "(^[a-zA-Z0-9-_]{6,16}$)|(^[\\u2e80-\\u9fff]{2,5})",
            message = "用户名必须是2-5位中文，或者6-16位英文和数字的组合")
    private String empName;

    private String gender;

    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message = "邮箱格式不正确")
    private String email;


    private Integer dId;

    /**
     * 希望查询员工的同时部门信息也是查询出来
     */
    private Department department;


}