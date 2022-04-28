package com.qf.oa.controller;

import com.qf.oa.entity.Employee;
import com.qf.oa.service.IEmpService;
import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.ch.IOUtil;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    
    @Autowired
    private IEmpService iEmpService;

    @RequiresPermissions("/emp/emplist")
    @RequestMapping("/emplist")
    public  String empManger(Model model){
        List<Employee> employees = iEmpService.queryAll();
        model.addAttribute("emps",employees);
        return "emplist";
    }

    @RequiresPermissions("/emp/insert")
    @RequestMapping("/insert")
    public  String insetEmp(Employee employee){
        System.out.println("进来了");
        iEmpService.insertOrUpdatetEmp(employee);
        return "redirect:/emp/emplist";
    }

    @RequestMapping("/querById")
    @ResponseBody
    public  Employee  querById(Integer  eid){
        Employee emp = iEmpService.queryOne(eid);
        return emp;
    }

}
