package com.example.employeemodel.service;

import com.example.employeemodel.dto.RequestDTO;
import com.example.employeemodel.model.Employee;

import java.util.List;

public interface EmployeeService {
    RequestDTO addEmployee(RequestDTO employee);

    RequestDTO getEmployeeById(long id);

    void deleteEmployeeById(long id);

    List<RequestDTO> getAllEmployee();

    RequestDTO updateEmployeeById(long id, RequestDTO employee);
}


