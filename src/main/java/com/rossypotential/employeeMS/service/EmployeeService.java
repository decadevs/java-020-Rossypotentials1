package com.rossypotential.employeeMS.service;

import com.rossypotential.employeeMS.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee addEmployee(Employee employee);

    Employee getEmployeeById(Long id);
    Employee getEmployeeByName(String name);
    Employee findByEmail(String email);

    Employee updateEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    public List<Employee> getAllEmployeesBasicInfo();
}
