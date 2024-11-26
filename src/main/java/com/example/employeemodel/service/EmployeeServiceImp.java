package com.example.employeemodel.service;

import com.example.employeemodel.dto.RequestDTO;
import com.example.employeemodel.exception.CustomException;
import com.example.employeemodel.model.Employee;
import lombok.RequiredArgsConstructor;
import com.example.employeemodel.repository.EmployeeRepository;
import org.apache.logging.log4j.util.Base64Util;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository;
    }

    @Override
    public RequestDTO addEmployee(RequestDTO requestDTO) {
        Employee employee  =mapTOEnity(requestDTO);
        Employee saveemployee =employeeRepository.save(employee);
        return mapToDTO(saveemployee);




    }

    @Override
    public RequestDTO getEmployeeById(long id) {
        Employee employee =employeeRepository.findById(id).orElseThrow(()->new CustomException("ID not found"));
        return mapToDTO(employee);
    }

    @Override
    public void deleteEmployeeById( long id) {
        if (!employeeRepository.existsById( id)) {
            throw new RuntimeException("Employee with ID " + id + " does not exist.");
        }
        employeeRepository.deleteById((id));
    }


    @Override
    public List<RequestDTO> getAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RequestDTO updateEmployeeById(long id, RequestDTO requestDTO) {
        RequestDTO existingEmploye = getEmployeeById(id);
        Employee employee = mapTOEnity(existingEmploye);
        employee.setFName(requestDTO.getFName());
        employee.setLName(requestDTO.getLName());
        employee.setSalary(requestDTO.getSalary());
        employee.setProfilePic(requestDTO.getProfilePic());
        employee.setDepartments(requestDTO.getDepartments());
        employee.setGender(requestDTO.getGender());
        employee.setNotes(requestDTO.getNotes());
        return mapToDTO(employeeRepository.save(employee));

    }

    public RequestDTO mapToDTO(Employee employee){
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setEmp_id(employee.getEmp_id());
        requestDTO.setFName(employee.getFName());
        requestDTO.setLName(employee.getLName());
        requestDTO.setSalary(employee.getSalary());
        requestDTO.setProfilePic(employee.getProfilePic());

        requestDTO.setDepartments(employee.getDepartments());
        requestDTO.setDoj(employee.getDoj());
        requestDTO.setNotes(employee.getNotes());
        requestDTO.setGender((employee.getGender()));
        return requestDTO;
    }
    public Employee mapTOEnity(RequestDTO requestDTO){
        Employee employee = new Employee();
        employee.setEmp_id(requestDTO.getEmp_id());
        employee.setFName(requestDTO.getFName());
        employee.setLName(requestDTO.getLName());
        employee.setSalary(requestDTO.getSalary());
        employee.setProfilePic(requestDTO.getProfilePic());

        employee.setDepartments(requestDTO.getDepartments());
        employee.setDoj(LocalDate.now());
        employee.setNotes(requestDTO.getNotes());
        employee.setGender(requestDTO.getGender());
        return employee;
    }



}
