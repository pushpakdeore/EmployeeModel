package com.example.employeemodel.controller;

import com.example.employeemodel.dto.RequestDTO;
import com.example.employeemodel.service.EmployeeServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testcontroller")
public class TestController {
    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    public TestController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @PostMapping("/add")
    public RequestDTO addEmployee(@Valid @RequestBody RequestDTO employee ){
        return employeeServiceImp.addEmployee(employee);
    }
}
