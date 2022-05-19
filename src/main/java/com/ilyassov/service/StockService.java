package com.ilyassov.service;

import com.ilyassov.aop.AopToken;
import com.ilyassov.model.Product;
import com.ilyassov.model.Stock;
import com.ilyassov.repository.ProductRepository;
import com.ilyassov.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Service
@Profile("dev")
@EnableScheduling
public class StockService {
    private final StockRepository stockRepository;

    @Autowired
    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @AopToken
    @Cacheable(value = "stocks")
    @Transactional(rollbackFor = {SQLException.class},
            isolation = Isolation.DEFAULT
    )
    public List<Stock> getAllStocks(){ return stockRepository.getAllStocks(); }
}
