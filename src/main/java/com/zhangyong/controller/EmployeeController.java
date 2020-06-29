package com.zhangyong.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhangyong.bean.Employee;
import com.zhangyong.bean.Msg;
import com.zhangyong.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 张勇
 * @Date 2019/12/27 22:20
 * @Version 1.0
 * 处理员工的CRUD请求
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 查询员工数据(分页查询)
     *
     * @return
     */
    /**
     * 使用普通方式返回
     */
    /*@RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model) {
        //添加分页查询:引入PageHelper分页插件
        //在查询之前只需要调用,传入页码，以及每页大小
        PageHelper.startPage (pn,5);
        //startPage后面紧跟的查询就是一个分页查询

        List<Employee> emps = employeeService.getAll ();

        //使用PageInfo来包装查询结果，只需要将PageInfo交给页面就行了
        //PageInfo封装了很多方法便于我们使用（如：总页数，上一页，下一页……）
        //5表示连续显示的页数
        PageInfo page = new PageInfo (emps,5);

        //使用model将值带入前端
        model.addAttribute ("pageInfo",page);

        return "list";
    }*/

    /**
     * 使用Json返回数据
     *
     * @param pn
     * @return
     */
    @RequestMapping("/emps")
    @ResponseBody
    public Msg getEmpsWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //添加分页查询:引入PageHelper分页插件
        //在查询之前只需要调用,传入页码，以及每页大小
        PageHelper.startPage (pn, 5);
        List<Employee> emps = employeeService.getAll ();
        //使用PageInfo来包装查询结果，只需要将PageInfo交给页面就行了
        //PageInfo封装了很多方法便于我们使用（如：总页数，上一页，下一页……）
        //5表示连续显示的页数
        PageInfo page = new PageInfo (emps, 5);
        if (page != null) {
            return Msg.success ().add ("pageInfo", page);
        }
        return Msg.fail ();
    }


    /**
     * 保存员工信息
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result) {

        Map<String, Object> map = new HashMap<> ();
        if (result.hasErrors ()) {
            //校验失败，在模态框中显示失败信息
            List<FieldError> fieldErrors = result.getFieldErrors ();
            for (FieldError fieldError : fieldErrors) {
                System.out.println ("错误的字段名：" + fieldError.getField ());
                System.out.println ("错误信息：" + fieldError.getDefaultMessage ());
                map.put (fieldError.getField (), fieldError.getDefaultMessage ());
            }
            return Msg.fail ().add ("errorFields", map);
        } else {
            employeeService.saveEmp (employee);
            return Msg.success ();
        }
    }

    /**
     * 校验用户名是否可用
     *
     * @param empName
     * @return
     */
    @RequestMapping("/checkUser")
    @ResponseBody
    public Msg checkUser(@RequestParam("empName") String empName) {
        // 先判断用户名是否是合法的表达式
        String regx = "(^[a-zA-Z0-9-_]{6,16}$)|(^[\\u2e80-\\u9fff]{2,5})";
        if (!empName.matches (regx)) {
            return Msg.fail ().add ("va_msg", "用户名可以是2-5位中文，或者6-16位英文和数字的组合");
        }
        // 数据库用户名重复校验
        boolean b = employeeService.checkUser (empName);
        if (b) {
            return Msg.success ();
        } else {
            return Msg.fail ().add ("va_msg", "用户名不可用");
        }
    }

    /**
     * 根据Id查询员工
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Msg getEmp(@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmp (id);
        return Msg.success ().add ("emp", employee);
    }


    /**
     * 员工更新
     *
     * @param employee
     * @return
     */
    @RequestMapping(value = "/emp/{empId}", method = RequestMethod.PUT)
    @ResponseBody
    public Msg saveEmp(Employee employee) {
        employeeService.updateEmp (employee);
        return Msg.success ();
    }

    /**
     * 单个和批量删除二合一
     *
     * @param ids
     * @return
     */
    @RequestMapping(value = "/emp/{ids}", method = RequestMethod.DELETE)
    @ResponseBody
    public Msg deleteEmpById(@PathVariable("ids") String ids) {
        //多个删除
        if (ids.contains ("-")) {
            String[] str_ids = ids.split ("-");
            List<Integer> del_ids = new ArrayList<> ();
            // 组装id 的集合
            for (String str : str_ids) {
                del_ids.add (Integer.parseInt (str));
            }
            employeeService.deleteBatch (del_ids);
        } else { //单个删除
            Integer id = Integer.parseInt (ids);
            employeeService.deleteEmp (id);
        }
        return Msg.success ();
    }

}
