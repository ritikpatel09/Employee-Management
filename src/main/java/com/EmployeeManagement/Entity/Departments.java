package com.EmployeeManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String departmentName;

    @OneToMany(mappedBy = "departments",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<Employees> employees;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.PERSIST)
    private List<Managers> managers;

    @OneToMany(mappedBy = "departments", cascade = CascadeType.PERSIST)
    private List<TeamLeads> teamLeads;
}
