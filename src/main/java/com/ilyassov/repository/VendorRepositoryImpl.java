package com.ilyassov.repository;

import com.ilyassov.model.Vendor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VendorRepositoryImpl implements VendorRepository{
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Vendor> getVendors() {
        return sessionFactory.getCurrentSession().createQuery("FROM Vendor v").list();
    }

    @Override
    public Vendor addVendor(Vendor vendor) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(vendor);
        session.getTransaction().commit();
        return vendor;
    }

    @Override
    public boolean updateVendor(Vendor vendor) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(vendor);
            session.getTransaction().commit();
        }catch (Exception exception){
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteVendor(int id) {
        try {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Vendor vendor = new Vendor();
            vendor.setId(id);
            session.delete(vendor);
            session.getTransaction().commit();
            session.close();
        }catch (Exception exception){
            System.out.println("KRM: " + exception.getLocalizedMessage());
            return false;
        }
        return true;
    }
}
