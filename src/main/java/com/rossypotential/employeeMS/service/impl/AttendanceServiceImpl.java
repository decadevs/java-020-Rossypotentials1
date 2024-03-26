package com.rossypotential.employeeMS.service.impl;

import com.rossypotential.employeeMS.entity.Attendance;
import com.rossypotential.employeeMS.repository.AttendanceRepository;
import com.rossypotential.employeeMS.service.AttendanceService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class AttendanceServiceImpl implements AttendanceService {
    @Resource
    private AttendanceRepository attendanceRepository;
    public AttendanceServiceImpl(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    @Override
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    @Override
    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

}