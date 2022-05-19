package com.ilyassov.repository;

import com.ilyassov.model.Stock;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository {

    public List<Stock> getAllStocks();

}
