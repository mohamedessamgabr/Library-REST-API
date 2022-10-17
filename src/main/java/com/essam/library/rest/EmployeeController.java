package com.essam.library.rest;

import com.essam.library.model.Employee;
import com.essam.library.model.request.AdminEmployeeRequest;
import com.essam.library.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        return ResponseEntity.ok().body(employeeService.getEmployees());
    }

    @PostMapping("/add-employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/add-employee").toUriString());
        return ResponseEntity.created(uri).body(employeeService.addEmployee(employee));
    }
    @PutMapping("admin-add-employee")
    public ResponseEntity<?> adminAddEmployee(@RequestBody AdminEmployeeRequest adminEmployeeRequest) {
        employeeService.adminAddEmployee(adminEmployeeRequest.getAdminId(), adminEmployeeRequest.getEmployeeId());
        return ResponseEntity.ok().build();
    }
}
