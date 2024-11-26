package com.example.employeemodel.dto;

import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDTO {
    private long emp_id;
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Pattern mismatch Min 3 characters eg= Sam")
    private  String fName;
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$", message = "Pattern mismatch Min 3 characters eg= Sam")
    private  String lName;
    @NotNull
    private  double salary;

    private String profilePic;
    private List<String> departments;
    @PastOrPresent(message = "Registration date must be past or present date")
    private LocalDate doj;
    private String notes;
    private String gender;
}
