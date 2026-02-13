package com.EmployeeManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String departmentName;

    @OneToOne(mappedBy = "departments",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Employees employees;
}
