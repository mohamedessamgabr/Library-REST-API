package com.essam.library.service;

import com.essam.library.model.Admin;
import com.essam.library.model.Library;
import com.essam.library.model.request.LibraryAdminRequest;
import com.essam.library.repository.AdminRepository;
import com.essam.library.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryServiceImpl implements LibraryService{

    private final LibraryRepository libraryRepository;
    private final AdminService adminService;

    @Autowired
    public LibraryServiceImpl(LibraryRepository libraryRepository, AdminService adminService) {
        this.libraryRepository = libraryRepository;
        this.adminService = adminService;
    }

    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Library save(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public Library findByName(String name) {
        Optional<Library> result = libraryRepository.findById(name);
        Library library = null;
        if (result.isPresent()) {
            library = result.get();
        }
        return library;
    }

    @Override
    public void deleteByName(String name) {
        libraryRepository.deleteById(name);
    }

    @Override
    public String assignAdminToLibrary(LibraryAdminRequest libraryAdminRequest) {
        Library library = this.findByName(libraryAdminRequest.getLibraryName());
        Admin admin = adminService.findById(libraryAdminRequest.getAdminId());
        library.setAdmin(admin);
        libraryRepository.save(library);
        return "Saved";
    }
}
