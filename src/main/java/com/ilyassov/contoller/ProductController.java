package com.ilyassov.contoller;

import com.ilyassov.model.Order;
import com.ilyassov.model.Product;
import com.ilyassov.service.OrderService;
import com.ilyassov.service.ProductService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @Scheduled(fixedDelay = 120000, initialDelay = 5000)
    public List<Product> getAll() throws SQLException {
        return productService.getAllProducts();
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts(@RequestHeader HttpHeaders headers) throws SQLException {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public Product addProduct(@RequestBody Product product) throws SQLException {
        return productService.addProduct(product);
    }

    @PutMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateProduct(@RequestBody Product product) throws SQLException {
        if(!productService.updateProduct(product)){
            return ResponseEntity.ok("Product not updated");
        }
        return ResponseEntity.ok("Product update");
    }

    @DeleteMapping(value = "/deleteProduct")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteProduct(@NotNull @RequestParam("id") int id) throws SQLException {
        if(!productService.deleteProduct(id)){
            return ResponseEntity.ok("Product not deleted");
        };
        return ResponseEntity.ok("Product deleted");
    }
}
