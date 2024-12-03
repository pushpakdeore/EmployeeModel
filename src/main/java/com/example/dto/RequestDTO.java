package com.example.dto;

import com.example.model.Address;
import jakarta.validation.constraints.*;
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
    @Min(value = 18,message = "Age must be 18+")
    @Max(value = 50, message = "Age limit less then 50")
    private int age;
    private String email;
    private String profilePic;
    private List<String> departments;
    private List<Address> addresses;
    @PastOrPresent(message = "Registration date must be past or present date")
    private LocalDate doj;
    private String notes;
    private String gender;
    @Override
    public String toString() {
        return "RequestDTO{" +
                "emp_id=" + emp_id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", profilePic='" + profilePic + '\'' +
                ", departments=" + departments +
                ", addresses=" + addresses +
                ", doj=" + doj +
                ", notes='" + notes + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

}
