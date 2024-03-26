package com.rossypotential.employeeMS.repository;

import com.rossypotential.employeeMS.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Admin findByEmail(String email);
}
