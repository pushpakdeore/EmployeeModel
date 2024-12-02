package com.example.controller;

import com.example.dto.RequestDTO;
import com.example.service.EmployeeServiceImp;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/mycontroller")
public class MyController {

    private EmployeeServiceImp employeeServiceImp;

    @Autowired
    public MyController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

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