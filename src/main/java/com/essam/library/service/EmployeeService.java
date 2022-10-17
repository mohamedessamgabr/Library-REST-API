package com.essam.library.service;

import com.essam.library.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addEmployee(Employee employee);

    Employee getById(int id);

    List<Employee> getEmployees();

    void adminAddEmployee(int adminId, int employeeId);
}
