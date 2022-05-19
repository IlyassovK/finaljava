package com.ilyassov.config;

import com.ilyassov.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.SQLException;

@Configuration
@PropertySource("classpath:application.properties")
public class StockConfig {
    private final StockService stockService;

    @Autowired
    public StockConfig(StockService stockService) {
        this.stockService = stockService;
    }

    @Bean(initMethod = "", destroyMethod = "")
    public void getStocks() throws SQLException {
        stockService.getAllStocks().forEach(stock -> System.out.println(stock.toString()));
    }
}
