package com.rossypotential.employeeMS.service.impl;
import com.rossypotential.employeeMS.entity.Leave;
import com.rossypotential.employeeMS.enums.LeaveStatus;
import com.rossypotential.employeeMS.repository.LeaveRepository;
import com.rossypotential.employeeMS.service.LeaveService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LeaveServiceImpl implements LeaveService {
    @Resource
private LeaveRepository leaveRepository;

    public LeaveServiceImpl(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    @Override
    public List<Leave> getAllLeave() {
        return leaveRepository.findAll();
    }

    @Override
    public Leave processLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

//    @Override
//    public void denyLeave(Long leaveId) {
//        Optional<Leave> leaveOptional = leaveRepository.findById(leaveId);
//        if (leaveOptional.isPresent()) {
//            Leave leave = leaveOptional.get();
//            // Update the leave status to APPROVED
//            leave.setLeaveStatus(LeaveStatus.APPROVED);
//            // Save the updated leave object
//            leaveRepository.save(leave);
//        } else {
//            // Handle case when leave is not found
//            throw new RuntimeException("Leave not found with ID: " + leaveId);
//        }
//    }
//
//    @Override
//    public void approveLeave(Long leaveId) {
//
//    }


}


