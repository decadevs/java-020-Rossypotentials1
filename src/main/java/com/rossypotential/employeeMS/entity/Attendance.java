package com.rossypotential.employeeMS.entity;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Attendance")
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    Employee employeeId;
    private String employeeName;
    @Column(name = "date")
    private LocalDate date;

}