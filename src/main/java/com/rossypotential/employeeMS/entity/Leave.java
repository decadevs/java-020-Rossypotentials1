package com.rossypotential.employeeMS.entity;

import com.rossypotential.employeeMS.enums.LeaveStatus;
import com.rossypotential.employeeMS.enums.LeaveType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "Leave-Table")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startLeave;
    private LocalDateTime endLeave;
    @Enumerated(EnumType.STRING)
    private LeaveType leaveType;
    @ManyToOne
    Employee employeeID;
    //LeaveStatus leaveStatus;


}
