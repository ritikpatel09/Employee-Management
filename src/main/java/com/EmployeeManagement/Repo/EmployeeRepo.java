package com.EmployeeManagement.Repo;

import com.EmployeeManagement.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employees, Integer> {
}
