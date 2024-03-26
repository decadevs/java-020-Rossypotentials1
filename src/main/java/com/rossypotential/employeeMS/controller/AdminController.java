package com.rossypotential.employeeMS.controller;

import com.rossypotential.employeeMS.entity.Admin;
import com.rossypotential.employeeMS.service.AdminService;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@AllArgsConstructor
@Controller

public class AdminController {

    @Resource
    private AdminService adminService;

    @GetMapping("/admin")
    public String loginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin";
    }

    @PostMapping("/admin")
    public String processLogin(Admin login, RedirectAttributes redirectAttributes) {
        boolean isValid = adminService.isValidAdmin(login.getEmail(), login.getPassword());
        if (isValid) {
            return "redirect:/employees";
        } else {
            redirectAttributes.addFlashAttribute("error", "Invalid email or password.");
            return "redirect:/admin";
        }
    }
    @GetMapping("/learn_more")
    public String learnMore() {
        return "learn_more";
    }
    @GetMapping("/index")
    public String index() {
        return "index";
    }
}
