package com.ilyassov.contoller;

import com.ilyassov.model.Order;
import com.ilyassov.model.Role;
import com.ilyassov.service.OrderService;
import com.ilyassov.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
            this.orderService = orderService;
        }

        @GetMapping(value = "/getAllOrders")
        @ResponseStatus(HttpStatus.OK)
        public List<Order> getAll() throws SQLException {
            return orderService.getAllOrders();
    }
}
