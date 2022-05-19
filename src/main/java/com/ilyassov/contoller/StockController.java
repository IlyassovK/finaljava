package com.ilyassov.contoller;

import com.ilyassov.model.Product;
import com.ilyassov.model.Stock;
import com.ilyassov.service.ProductService;
import com.ilyassov.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/stock")
public class StockController {
    private final StockService stockService;

    @Autowired
    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping(value = "/")
    @ResponseStatus(HttpStatus.OK)
    @Scheduled(cron = "0 1 10 30 * ?")
    public List<Stock> getAll() throws SQLException {
        return stockService.getAllStocks();
    }

//    @PostMapping(value = "/")
//    @ResponseStatus(HttpStatus.OK)
//    public Product addStock(@RequestBody Product product) throws SQLException {
//        return productService.addProduct(product);
//    }
}
