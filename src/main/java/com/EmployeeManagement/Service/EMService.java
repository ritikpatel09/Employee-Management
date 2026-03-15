package com.EmployeeManagement.Service;

import com.EmployeeManagement.Dto.Request.DepartmentRequestDto;
import com.EmployeeManagement.Dto.Request.PeopleRequest;
import com.EmployeeManagement.Entity.Departments;
import com.EmployeeManagement.Repo.DepartmentRepo;
import com.EmployeeManagement.Repo.EmployeeRepo;
import com.EmployeeManagement.Repo.ManagersRepo;
import com.EmployeeManagement.Repo.TeamLeadsRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EMService {

   private static final Logger logger = LoggerFactory.getLogger(EMService.class);

    private RestTemplate restTemplate;
    private DepartmentRepo departmentRepo;

    private EmployeeRepo employeeRepo;
    private TeamLeadsRepo teamLeadsRepo;
    private ManagersRepo managersRepo;

    public String addListOfDepartment(List<String> departmentNames){
       try {
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
           for (String n : departmentNames) {
               Departments departments = new Departments();
               departments.setDepartmentName(n);
               departmentsList.add(departments);
           }
           departmentRepo.saveAll(departmentsList);
           return "ADDED ALL";
       } catch (Exception e) {
           logger.error("okok");
           return "not done";
       }
    }

//    public String createResource(PeopleRequest requestBody) {
//        return restClient.post()
//                .uri("/people")
//                .contentType(org.springframework.http.MediaType.APPLICATION_JSON) // Set content type
//                .body(requestBody)                                             // Set the request body (will be serialized to JSON)
//                .retrieve()
//                .body(String.class);
//    }



    public String createResource(PeopleRequest dto) {
        String url = "http://localhost:8080/people";
        return restTemplate.postForObject(url, dto, String.class);
    }



}
