package com.EmployeeManagement.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Managers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managerId;

    private String managerNames;

    @ManyToOne
    @JoinColumn(name="department_id")
    private Departments departments;

    @OneToMany(mappedBy = "managers", cascade = CascadeType.PERSIST)
    private List<TeamLeads> teamLeads;

    @OneToMany(mappedBy = "managers",cascade = CascadeType.PERSIST)
    private List<Employees> employees;
}
