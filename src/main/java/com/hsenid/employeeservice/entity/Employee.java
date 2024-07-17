package com.hsenid.employeeservice.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor//using these dont want to create constructors
@AllArgsConstructor//using these dont want to create constructors
@Data
public class Employee {

    @Id
    private int id;
    private String name;
    private String nic;
    private String email;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")// change the data format , otherwise it returns long number
    private Date joinDate;
    private int departmentId;
}
