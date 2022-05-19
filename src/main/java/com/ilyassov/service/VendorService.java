package com.ilyassov.service;

import com.ilyassov.model.Vendor;
import com.ilyassov.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dev")
public class VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }
    public List<Vendor> getAllVendors(){ return vendorRepository.getVendors(); }
    public Vendor addVendor(Vendor vendor){ return vendorRepository.addVendor(vendor); }
    public boolean updateVendor(Vendor vendor){ return vendorRepository.updateVendor(vendor); }
    public boolean deleteVendor(int id){ return vendorRepository.deleteVendor(id); }

}
