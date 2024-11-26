package com.example.employeemodel.controller;

import com.example.employeemodel.EmployeeModelApplication;
import com.example.employeemodel.dto.RequestDTO;
import com.example.employeemodel.model.Employee;
import com.example.employeemodel.service.EmployeeServiceImp;
import jakarta.persistence.Lob;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @PostMapping("/add")
    public RequestDTO addEmployee(@Valid @RequestBody RequestDTO employee ){
        return employeeServiceImp.addEmployee(employee);
    }

    @GetMapping("/{id}")
    public RequestDTO getEmployeeById(@PathVariable long id){
        return employeeServiceImp.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<RequestDTO> getAllEmployee(){
        return employeeServiceImp.getAllEmployee();
    }

    @DeleteMapping("/{id}")
    public  void deleteEmplyeeById(@PathVariable long id){
         employeeServiceImp.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    public RequestDTO updateEmployee(@PathVariable long id,@RequestBody RequestDTO employee ){
        return employeeServiceImp.updateEmployeeById(id,employee);
    }
}