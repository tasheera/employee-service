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


    public void getEmployeesByDepartmentName(String departmentName) {
        employeeRepo.getEmployeesByDepartmentName(departmentName);
    }

    public void editEmployee(Employee employee){
        employeeRepo.save(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeRepo.delete(employee);
    }

}
