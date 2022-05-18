package com.ilyassov.repository;

import com.ilyassov.model.User;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public List<User> getUsers() {
        List<User> users =  sessionFactory.getCurrentSession().createQuery("FROM User u").list();
        System.out.println(users);
        return users;
    }

    @Transactional
    public List<User> getUserById(int id) {
        List<User> users = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.id = :id").setParameter("id", id).list();
        return users;
    }

}
