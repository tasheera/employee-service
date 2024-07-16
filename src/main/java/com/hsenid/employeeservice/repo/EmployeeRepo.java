package com.hsenid.employeeservice.repo;

import com.hsenid.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {


}
