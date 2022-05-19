package com.ilyassov.service;

import com.ilyassov.model.Product;
import com.ilyassov.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("dev")
@EnableScheduling
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

//    @Cacheable(value = "products")
    public List<Product> getAllProducts(){ return productRepository.getProducts(); }
    public Product addProduct(Product product){ return productRepository.addProduct(product); }
    public boolean updateProduct(Product product){ return productRepository.updateProduct(product); }
    public boolean deleteProduct(int id){ return productRepository.deleteProduct(id); }
}
