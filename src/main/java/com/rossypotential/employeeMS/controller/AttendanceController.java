package com.rossypotential.employeeMS.controller;


import com.rossypotential.employeeMS.entity.Attendance;
import com.rossypotential.employeeMS.service.AttendanceService;
import com.rossypotential.employeeMS.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class AttendanceController {
    private AttendanceService attendanceService;
    private EmployeeService employeeService;
    @GetMapping("/attendance")
    public String listAllAttendance(Model model){
        model.addAttribute("attendance", attendanceService.getAllAttendance());
        return "attendance";
    }

    @GetMapping("/attendance/form")
    public String showAttendanceForm(Model model) {
        Attendance attendance = new Attendance();
        model.addAttribute("attendance", attendance);
        return "attendance_form";
    }


    @PostMapping("/attendance/form")
    public String saveAttendance(@ModelAttribute("attendance") Attendance attendance) {
        attendanceService.addAttendance(attendance);
        return "welcome";
    }

    @GetMapping("/view-attendance")
    public String viewAttendance(Model model) {
        List<Attendance> attendanceList = attendanceService.getAllAttendance();
        model.addAttribute("attendanceList", attendanceList);
        return "redirect:/employees";
    }
}