package com.itcast.controller;

import com.itcast.domain.Employee;
import com.itcast.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * web层的处理器
 */
@Controller
@RequestMapping("/employee")
public class EmpController {
    @Autowired
    @Qualifier("empService")
    private IEmpService service;

    @RequestMapping("/testFindAll")
    public String findAll(Model model){
        System.out.println("表现层查询所有用户信息");
        List<Employee> employees = service.doFindAll();
        model.addAttribute("list",employees);
        return "success";
    }
    @RequestMapping("/testSave")
    public String Save(Employee employee){
        System.out.println("表现层查询所有用户信息");
        service.doSave(employee);
        return "success";
    }
}
