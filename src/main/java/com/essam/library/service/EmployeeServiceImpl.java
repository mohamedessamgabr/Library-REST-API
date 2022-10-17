package com.essam.library.service;


import com.essam.library.model.Admin;
import com.essam.library.model.Employee;
import com.essam.library.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;
    private final AdminService adminService;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, AdminService adminService) {
        this.employeeRepository = employeeRepository;
        this.adminService = adminService;
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getById(int id) {
        Optional<Employee> result = employeeRepository.findById(id);
        Employee employee = null;
        if (result.isPresent()) {
            employee = result.get();
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void adminAddEmployee(int adminId, int employeeId) {
        Employee employee = getById(employeeId);
        Admin admin = adminService.findById(adminId);
        employee.setAdmin(admin);
        employeeRepository.save(employee);
    }
}
