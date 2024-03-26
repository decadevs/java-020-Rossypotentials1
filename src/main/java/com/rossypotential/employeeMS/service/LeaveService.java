package com.rossypotential.employeeMS.service;

import com.rossypotential.employeeMS.entity.Leave;
import com.rossypotential.employeeMS.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LeaveService {
    List<Leave> getAllLeave();

    Leave processLeave(Leave leave);
//    void denyLeave(Long leaveId);
//    void approveLeave(Long leaveId);


}

