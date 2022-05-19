package com.ilyassov.repository;

import com.ilyassov.model.Stock;
import com.ilyassov.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class StockRepositoryImpl implements StockRepository {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Stock> getAllStocks() {
        List<Stock> stocks =  sessionFactory.getCurrentSession().createQuery("FROM Stock S").list();
        return stocks;
    }
}
