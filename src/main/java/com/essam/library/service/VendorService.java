package com.essam.library.service;

import com.essam.library.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> findAll();

    Vendor findById(int vendorId);

    Vendor save(Vendor vendor);

    void deleteById(int vendorId);
}
