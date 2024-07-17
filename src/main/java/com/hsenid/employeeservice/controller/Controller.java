package com.hsenid.employeeservice.controller;


import com.hsenid.employeeservice.entity.Employee;
import com.hsenid.employeeservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getallemployee/{name}")
    public List<Employee> getEmployeesByName(@PathVariable String name) {
        return employeeService.getAllEmployeesByName(name);
    }

    @GetMapping("/find5YearsAnd90NIC")
    public List<Employee> find5YearsAnd90NIC() {
        return employeeService.find5YearsAnd90NIC();
    }

    @PostMapping("/addemployee")
    public Employee save(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return employee;
    }

    @PutMapping("/editemployee")
    public Employee update(@RequestBody Employee employee) {
        employeeService.editEmployee(employee);
        return employee;
    }

    @DeleteMapping("/deleteemployee")
    public String delete(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
        return "Employee deleted successfully";
    }

    @DeleteMapping("/deleteemployee/{id}")
    public Employee delete(@PathVariable int id) {
        return employeeService.deleteEmployeeByEmployeeId(id);
    }

    @GetMapping("/employeebydepartmentname/{depname}")
    public List<Employee> getEmployeeByDepartment(@PathVariable String depname) {
        return employeeService.getEmployeesByDepartmentName(depname);
    }


}
