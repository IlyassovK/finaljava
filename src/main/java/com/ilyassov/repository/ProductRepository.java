package com.ilyassov.repository;

import com.ilyassov.model.Order;
import com.ilyassov.model.Product;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ProductRepository {

    public List<Product> getProducts();
    public Product addProduct(Product product);
    public boolean updateProduct(Product product);
    public boolean deleteProduct(int id);

}
