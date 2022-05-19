package com.ilyassov.repository;

import com.ilyassov.model.Order;
import com.ilyassov.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> products =  sessionFactory.getCurrentSession().createQuery("FROM Product p").list();
        System.out.println(products);
        return products;
    }

    @Override
    public Product addProduct(Product product) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(product);
        session.getTransaction().commit();
        return product;
    }

    @Override
    public boolean updateProduct(Product product) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        }catch (Exception exception){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteProduct(int id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Product product = new Product();
            product.setId(id);
            session.delete(product);
            session.getTransaction().commit();
            session.close();
        }catch (Exception exception){
            System.out.println("KRM: " + exception.getLocalizedMessage());
            return false;
        }
        return true;
    }


}
