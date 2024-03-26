package com.rossypotential.employeeMS.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Admin")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Admin extends BaseClass{
    @Size(min = 6, max = 16, message = "Password must  be at least 6 digit long")
    @NotBlank(message = "password must not be blank")
    private String password;
}
