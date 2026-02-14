package com.EmployeeManagement.Entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class TeamLeads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teamLeadId;

    private String teamLeadName;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments departments;

    @ManyToOne
    @JoinColumn(name ="manager_id" )
    private Managers managers;

    @OneToMany(mappedBy = "teamLeads", cascade = CascadeType.PERSIST)
    private List<Employees> employees;


}
