package com.essam.library.service;

import com.essam.library.model.Admin;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AdminService {

    List<Admin> findAll();

    Admin save(Admin admin);

    Admin findById(int id);

    void deleteById(int id);

}
