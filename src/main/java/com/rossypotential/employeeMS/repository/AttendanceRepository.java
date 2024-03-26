package com.rossypotential.employeeMS.repository;

import com.rossypotential.employeeMS.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
