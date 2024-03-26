package com.rossypotential.employeeMS.service.impl;

import com.rossypotential.employeeMS.entity.Employee;
import com.rossypotential.employeeMS.repository.EmployeeRepository;
import com.rossypotential.employeeMS.service.EmployeeService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee getEmployeeByName(String name) {
        return employeeRepository.save(getEmployeeByName(name));
    }

    @Override
    public Employee findByEmail(String email) {
       return employeeRepository.findByEmail(email);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> getAllEmployeesBasicInfo() {
            // Fetch all employees from the repository
            List<Employee> employees = employeeRepository.findAll();

            // Iterate through the list of employees and remove salary and token fields
            for (Employee employee : employees) {
                employee.setSalary(null); // Exclude salary
                employee.setToken(null);  // Exclude token
            }

            return employees;
    }
}
