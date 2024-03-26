package com.rossypotential.employeeMS.service;

import com.rossypotential.employeeMS.entity.Attendance;

import java.util.List;

public interface AttendanceService {
    List<Attendance> getAllAttendance();
    Attendance addAttendance(Attendance attendance);

    // List<Attendance> attendance;

}
