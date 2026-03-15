package com.EmployeeManagement.Controller;

import com.EmployeeManagement.Dto.Request.PeopleRequest;
import com.EmployeeManagement.Service.EMService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/em")

public class EMController {
    @Autowired
    private EMService emService;

    @PostMapping("/addDepartments")
    public ResponseEntity<String> addDepartments(@RequestBody List<String> names){
        String response = emService.addListOfDepartment(names);
        return ResponseEntity.ok(response);

    }

    @PostMapping("/external")
    public String createPeople(@RequestBody PeopleRequest dto){
        return emService.createResource(dto);
    }

}
