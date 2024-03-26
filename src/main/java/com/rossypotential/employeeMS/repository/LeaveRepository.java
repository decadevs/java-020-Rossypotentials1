package com.rossypotential.employeeMS.repository;

import com.rossypotential.employeeMS.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<Leave, Long> {
}
