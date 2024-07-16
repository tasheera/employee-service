package com.hsenid.employeeservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor//using these dont want to create constructors
@AllArgsConstructor//using these dont want to create constructors
@Data
public class Department {

    @Id
    private int id;

    @Enumerated(EnumType.STRING)
    private DepartmentName departmentName;
}

