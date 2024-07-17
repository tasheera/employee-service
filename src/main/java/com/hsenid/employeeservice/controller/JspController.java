package com.hsenid.employeeservice.controller;

import com.hsenid.employeeservice.entity.Employee;
import com.hsenid.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class JspController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/")
    public String getEmployees(Model model) {
        return "employees";// jsp file name

    }
}
