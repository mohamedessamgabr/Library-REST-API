package com.essam.library.service;

import com.essam.library.model.Vendor;
import com.essam.library.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService{

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<Vendor> findAll() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor findById(int vendorId) {
        Optional<Vendor> result = vendorRepository.findById(vendorId);
        Vendor vendor = null;
        if(result.isPresent()) {
            vendor = result.get();
        }
        return vendor;
    }

    @Override
    public Vendor save(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public void deleteById(int vendorId) {
        vendorRepository.deleteById(vendorId);
    }
}
