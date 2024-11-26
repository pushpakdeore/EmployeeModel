package com.example.employeemodel.model;

import com.example.employeemodel.dto.RequestDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    private long  emp_id;
    private  String fName;
    private  String lName;
    private  double salary;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "department_data",joinColumns = @JoinColumn(name="employee_id"))
    private List<String> departments;
    private LocalDate doj;
    private String notes;
    private String gender;





}
