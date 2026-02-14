package com.EmployeeManagement.Repo;

import com.EmployeeManagement.Entity.Managers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagersRepo extends JpaRepository<Managers,Integer> {
}
