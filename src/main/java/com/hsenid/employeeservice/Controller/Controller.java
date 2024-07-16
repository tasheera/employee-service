package com.hsenid.employeeservice.Controller;


import com.hsenid.employeeservice.entity.Employee;
import com.hsenid.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getallemployee")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }


}
