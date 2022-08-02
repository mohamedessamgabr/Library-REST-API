package com.essam.library.rest;

import com.essam.library.model.Admin;
import com.essam.library.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    private AdminService adminService;

    @Autowired
    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminService.findAll();
    }

    @PostMapping("/admins")
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.save(admin);
    }

    @GetMapping("/admins/{id}")
    public Admin getAdminById(@PathVariable int id) {
        Admin admin = adminService.findById(id);
        if (admin == null){
            throw new NotFoundException("Admin ID: " + id + " Not Found");
        }
        return admin;
    }

    @DeleteMapping("/admins/{id}")
    public String deleteAdmin(@PathVariable int id) {
        Admin admin = adminService.findById(id);
        if (admin == null){
            throw new NotFoundException("Admin ID: " + id + " Not Found");
        }
        adminService.deleteById(id);
        return "Admin with ID: " + id + " has been deleted";
    }
}
