package com.EmployeeManagement.Repo;

import com.EmployeeManagement.Entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Departments,Integer> {
    boolean existsByDepartmentName(String departmentName);

}
