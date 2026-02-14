package com.EmployeeManagement.Service;

import com.EmployeeManagement.Dto.Request.DepartmentRequestDto;
import com.EmployeeManagement.Entity.Departments;
import com.EmployeeManagement.Repo.DepartmentRepo;
import com.EmployeeManagement.Repo.EmployeeRepo;
import com.EmployeeManagement.Repo.ManagersRepo;
import com.EmployeeManagement.Repo.TeamLeadsRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EMService {

    private DepartmentRepo departmentRepo;
    private EmployeeRepo employeeRepo;
    private TeamLeadsRepo teamLeadsRepo;
    private ManagersRepo managersRepo;

    public String addListOfDepartment(List<String> departmentNames){
        for (String name : departmentNames) {

            if (name == null || name.trim().isEmpty()) {
                continue;
            }

            String trimmedName = name.trim();

            if (departmentRepo.existsByDepartmentName(trimmedName)) {
                return "Department '" + trimmedName + "' already present";
            }
        }

        List<Departments> departmentsList = new ArrayList<>();
        for(String n : departmentNames){
            Departments departments = new Departments();
            departments.setDepartmentName(n);
            departmentsList.add(departments);
        }
        departmentRepo.saveAll(departmentsList);
        return "ADDED ALL";
    }
}
