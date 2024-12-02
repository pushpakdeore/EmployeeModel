package com.example.service;

import com.example.dto.RequestDTO;

import java.util.List;

public interface EmployeeService {
    RequestDTO addEmployee(RequestDTO employee);

    RequestDTO getEmployeeById(long id);

    void deleteEmployeeById(long id);

    List<RequestDTO> getAllEmployee();

    RequestDTO updateEmployeeById(long id, RequestDTO employee);
}


