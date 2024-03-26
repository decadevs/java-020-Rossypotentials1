package com.rossypotential.employeeMS.controller;

import com.rossypotential.employeeMS.entity.Employee;
import com.rossypotential.employeeMS.entity.Leave;
import com.rossypotential.employeeMS.service.EmployeeService;
import com.rossypotential.employeeMS.service.LeaveService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@AllArgsConstructor
@Controller
public class LeaveController {

    private LeaveService leaveService;
    private EmployeeService employeeService;

    @GetMapping("/leave")
    public String listAllLeave(Model model){
        model.addAttribute("leave", leaveService.getAllLeave());
        return "leave";
    }

    @GetMapping("/leave/form")
    public String showLeaveForm(Model model) {
        model.addAttribute("leave", new Leave());
        return "leave_application";
    }

    @PostMapping("/leave/form")
    public String submitLeaveForm(Leave leave) {
        leaveService.processLeave(leave);
        return "approved";
    }
}

