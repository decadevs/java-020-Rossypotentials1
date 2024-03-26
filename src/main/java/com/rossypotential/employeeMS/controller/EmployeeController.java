package com.rossypotential.employeeMS.controller;

import com.rossypotential.employeeMS.entity.Employee;
import com.rossypotential.employeeMS.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@AllArgsConstructor
@Controller
public class EmployeeController {
    private EmployeeService employeeService;
    @GetMapping("/employees")
    public String listAllEmployees(Model model){
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees";
    }
    @GetMapping("/employees/new")
    public String createEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";
    }

    @PostMapping("/employees")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeService.addEmployee(employee);
        return "redirect:/employees";
    }
    @GetMapping("/employees/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));

        return "edit_employee";
    }
    @PostMapping("/employees/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee, Model model){
        Employee existingEmployee = employeeService.getEmployeeById(id);
        existingEmployee.setFullName(employee.getFullName());
        existingEmployee.setMobileNo(employee.getMobileNo());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setToken(employee.getToken());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setSalary(employee.getSalary());

        employeeService.updateEmployee(existingEmployee);
        return "redirect:/employees";
    }

    @GetMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);

        return "redirect:/employees";
    }

    @GetMapping("/employees/basic")
    public String getAllEmployeesBasic(Model model) {
        List<Employee> employees = employeeService.getAllEmployeesBasicInfo();
        model.addAttribute("employees", employees);
        return "employees_basic";
    }


}

