package com.ilyassov.repository;

import com.ilyassov.model.Product;
import com.ilyassov.model.Vendor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository {
    public List<Vendor> getVendors();
    public Vendor addVendor(Vendor vendor);
    public boolean updateVendor(Vendor vendor);
    public boolean deleteVendor(int id);
}
