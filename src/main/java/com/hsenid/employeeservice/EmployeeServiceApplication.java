package com.hsenid.employeeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class EmployeeServiceApplication {

	public static void main(String[] args) {


		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");

		EmployeeService employee= context.getBean("employee", EmployeeService.class);



		System.out.println(employee.fetchEmployee());

		context.close();
	}

}
