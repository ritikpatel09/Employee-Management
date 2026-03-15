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

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Managers managers;


    @ManyToOne
    @JoinColumn(name = "teamLead_id")
    private TeamLeads teamLeads;

}
