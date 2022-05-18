package com.ilyassov.repository;

import com.ilyassov.model.Order;
import com.ilyassov.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class OrderRepositoryImpl implements OrderRepository {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<Order> getOrders() {
        List<Order> orders =  sessionFactory.getCurrentSession().createQuery("FROM Order o").list();
        System.out.println(orders);
        return orders;
    }

}
