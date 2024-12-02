package com.example.model;

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
@ToString
public class Employee {
    @Id
    @GeneratedValue
    private long  emp_id;
    private  String fName;
    private  String lName;
    private  int age;
    private  double salary;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "department_data",joinColumns = @JoinColumn(name="employee_id"))
    private List<String> departments;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)//Employee saveemployee =employeeRepository.save(employee);
    private List<Address> address;
    private LocalDate doj;
    private String notes;
    private String gender;





}
