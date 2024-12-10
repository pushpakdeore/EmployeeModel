package com.example.employeemodel.model;

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
    private  int age;
    private  double salary;
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "department_data",joinColumns = @JoinColumn(name="employee_id"))
    private List<String> departments;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)//Employee save employee =employeeRepository.save(employee);
                                                              //employee save address save automatically.
    private List<Address> address;
    private LocalDate doj;
    private String notes;
    private String gender;





}
