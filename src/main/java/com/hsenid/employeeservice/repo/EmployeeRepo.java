package com.hsenid.employeeservice.repo;

import com.hsenid.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee WHERE join_date <= DATE_SUB(CURDATE(), INTERVAL 5 YEAR) and nic like '90%'", nativeQuery = true)
    List<Employee> find5YearsAnd90NIC();

    @Query(value = "select * from employee where name= ?1", nativeQuery = true)
    List<Employee> viewEmployeeByName(String name);

    @Query(value = "select employee.id, employee.name, employee.nic, employee.email, employee.join_date, employee.department_id from employee join department on department.id= employee.department_id where department.department_name=?1", nativeQuery = true)
    List<Employee> getEmployeesByDepartmentName(String depName);



}
