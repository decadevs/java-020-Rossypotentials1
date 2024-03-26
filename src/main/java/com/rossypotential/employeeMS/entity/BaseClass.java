package com.rossypotential.employeeMS.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class  BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String fullName;

    private String email;
    private Long mobileNo;


}
