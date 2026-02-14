package com.EmployeeManagement.Repo;

import com.EmployeeManagement.Entity.TeamLeads;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamLeadsRepo extends JpaRepository<TeamLeads,Integer> {
}
