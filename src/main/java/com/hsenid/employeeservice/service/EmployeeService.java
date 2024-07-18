package com.hsenid.employeeservice.service;


import com.hsenid.employeeservice.entity.Employee;
import com.hsenid.employeeservice.repo.EmployeeRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public List<Employee> find5YearsAnd90NIC(){
        return employeeRepo.find5YearsAnd90NIC();
    }

    public void addEmployee(Employee employee) {
        employeeRepo.save(employee);
    }


    public List<Employee> getEmployeesByDepartmentName(String depName) {
        return employeeRepo.getEmployeesByDepartmentName(depName);
    }

    public void editEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepo.delete(employee);
    }

    public Employee deleteEmployeeByEmployeeId(int employeeId) {
        Employee employee = employeeRepo.findById(employeeId).orElse(null);
        employeeRepo.deleteById(employeeId);
        return employee;
    }

    public List<Employee> getAllEmployeesByName(String name) {
        return employeeRepo.viewEmployeeByName(name);
    }

    public Employee getEmployeeByEmployeeId(int employeeId) {
        return employeeRepo.findById(employeeId).get();
    }

}
