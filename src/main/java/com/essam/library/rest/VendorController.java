package com.essam.library.rest;

import com.essam.library.model.Vendor;
import com.essam.library.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendorController {

    private final VendorService vendorService;

    @Autowired
    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/vendors")
    public List<Vendor> getAllVendors() {
        return vendorService.findAll();
    }

    @PostMapping("/add-vendor")
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vendorService.save(vendor);
    }

    @DeleteMapping("delete-vendor-by-id/{vendorId}")
    public String deleteVendor(@PathVariable int vendorId) {
        vendorService.deleteById(vendorId);
        return "Vendor has been deleted";
    }
}
