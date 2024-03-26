package com.rossypotential.employeeMS.controller;

import com.rossypotential.employeeMS.entity.Employee;
import com.rossypotential.employeeMS.exception.EmployeeNotFoundException;
import com.rossypotential.employeeMS.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("login", new Employee());
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@Valid @ModelAttribute("login") Employee login,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        Employee employee = employeeService.findByEmail(login.getEmail());

        if (employee == null || !employee.getToken().equals(login.getToken())) {
            throw new EmployeeNotFoundException("Invalid email or password");
        }

        return "redirect:/employees/basic";
    }
}
