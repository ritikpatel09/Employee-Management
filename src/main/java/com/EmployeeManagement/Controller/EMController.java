package com.EmployeeManagement.Controller;

import com.EmployeeManagement.Service.EMService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

}
