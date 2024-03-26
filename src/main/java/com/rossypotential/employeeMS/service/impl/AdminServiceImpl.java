package com.rossypotential.employeeMS.service.impl;

import com.rossypotential.employeeMS.entity.Admin;
import com.rossypotential.employeeMS.entity.Attendance;
import com.rossypotential.employeeMS.repository.AdminRepository;
import com.rossypotential.employeeMS.service.AdminService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminRepository adminRepository;

    @Override
    public List<Attendance> getAllAttendance() {
        return null;
    }

    @Override
    public boolean isValidAdmin(String email, String password) {
        Admin admin = adminRepository.findByEmail(email);
        return admin != null && admin.getPassword().equals(password);
    }
}
