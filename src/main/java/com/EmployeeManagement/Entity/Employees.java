package com.EmployeeManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    private String empName;

    @OneToOne
    @JoinColumn(name = "department_id")
    private Departments departments;

}
