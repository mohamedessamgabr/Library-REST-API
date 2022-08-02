package com.essam.library.service;

import com.essam.library.model.Admin;
import com.essam.library.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService{

    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin findById(int id) {
        Optional<Admin> result = adminRepository.findById(id);
        Admin admin = null;
        if(result.isPresent()) {
            admin = result.get();
        } else {
            throw new RuntimeException("Admin with ID: " + id + " not found");
        }
        return admin;
    }

    @Override
    public void deleteById(int id) {
        adminRepository.deleteById(id);
    }


}
