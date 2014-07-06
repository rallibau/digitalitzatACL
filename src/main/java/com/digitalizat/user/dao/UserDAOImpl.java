/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizat.user.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rallibau
 */
@Repository
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
    }

    @Override
    public List<User> listUser() {
        return sessionFactory.getCurrentSession().createQuery("from User")
                .list();
    }

    @Override
    public void removeUser(Integer id) {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public User getUser(Integer id) throws Exception {
        User user = (User) sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null == user) {
            throw new Exception("El usuario no existe");
        }
        return user;
    }

    @Override
    public User getUser(String name) throws Exception {
        Query query = sessionFactory.getCurrentSession().createQuery("FROM User u WHERE u.email = :name");
        query.setParameter("name", name);
        User resultado = (User) query.uniqueResult();
        if (resultado == null) {
            throw new Exception("El resultado no existe");
        }
        return resultado;

    }

}
