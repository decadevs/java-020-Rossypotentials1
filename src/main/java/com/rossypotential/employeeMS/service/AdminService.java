package com.rossypotential.employeeMS.service;

import com.rossypotential.employeeMS.entity.Attendance;

import java.util.List;

public interface AdminService {
    List<Attendance> getAllAttendance();
    public boolean isValidAdmin(String email, String password);
}
