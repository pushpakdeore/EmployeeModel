package com.example.employeemodel.service;

import com.example.employeemodel.dto.RequestDTO;
import com.example.employeemodel.exception.CustomException;
import com.example.employeemodel.model.Address;
import com.example.employeemodel.model.Employee;
import com.example.employeemodel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class EmployeeServiceImp implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository){
        this.employeeRepository =employeeRepository;
    }
    @Autowired
    private EmailService emailService;

    @Override
    public RequestDTO addEmployee(RequestDTO requestDTO) {
        emailService.sendEmail(requestDTO.getEmail(), " Welcome to BrigeLabz!"," We are excited to have you as part of our team and look forward to the contributions you will make to our continued success.");
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
        RequestDTO existingEmployee = getEmployeeById(id);
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
        employee.setAge(requestDTO.getAge());
        employee.setSalary(requestDTO.getSalary());
        employee.setProfilePic(requestDTO.getProfilePic());
        employee.setDepartments(requestDTO.getDepartments());
        employee.setGender(requestDTO.getGender());
        employee.setNotes(requestDTO.getNotes());
        employee.setAddress(requestDTO.getAddresses()   );
        return mapToDTO(employeeRepository.save(employee));

    }

    public RequestDTO mapToDTO(Employee employee){
        RequestDTO requestDTO = new RequestDTO();
        requestDTO.setEmp_id(employee.getEmp_id());
        requestDTO.setFName(employee.getFName());
        requestDTO.setLName(employee.getLName());
        requestDTO.setAge(employee.getAge());
        requestDTO.setSalary(employee.getSalary());
        requestDTO.setProfilePic(employee.getProfilePic());

        requestDTO.setDepartments(employee.getDepartments());
        requestDTO.setAddresses(employee.getAddress());
        requestDTO.setDoj(employee.getDoj());
        requestDTO.setNotes(employee.getNotes());
        requestDTO.setGender((employee.getGender()));
        if (employee.getAddress() != null && !employee.getAddress().isEmpty()) {
            requestDTO.setAddresses(employee.getAddress());
        }
        return requestDTO;
    }
    public Employee mapTOEnity(RequestDTO requestDTO){
        Employee employee = new Employee();
        employee.setEmp_id(requestDTO.getEmp_id());
        employee.setFName(requestDTO.getFName());
        employee.setLName(requestDTO.getLName());
        employee.setAge(requestDTO.getAge()
        );
        employee.setSalary(requestDTO.getSalary());
        employee.setProfilePic(requestDTO.getProfilePic());
        employee.setDepartments(requestDTO.getDepartments());
        employee.setDoj(LocalDate.now());
        employee.setNotes(requestDTO.getNotes());
        employee.setGender(requestDTO.getGender());

        if (requestDTO.getAddresses() != null) {
            List<Address> addresses = requestDTO.getAddresses().stream().map(address -> {
                address.setEmployee(employee);
                return address;
            }).collect(Collectors.toList());
            employee.setAddress(addresses);
        }
        return employee;

    }



}
