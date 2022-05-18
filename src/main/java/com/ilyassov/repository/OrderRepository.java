package com.ilyassov.repository;

import com.ilyassov.model.Order;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository {

    public List<Order> getOrders();
}
