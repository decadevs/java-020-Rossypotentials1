package com.rossypotential.employeeMS.entity;

import com.rossypotential.employeeMS.enums.DepartmentName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee extends BaseClass{
@Enumerated(EnumType.STRING)
private DepartmentName department;
private Long employeeId;
private Double salary;

@Size(min = 6, max = 16, message = "Password must  be at least 6 digit long")
@NotBlank(message = "password must not be blank")
private String token;

//@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//private List<Leave> leaveSheet;

}
