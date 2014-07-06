/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digitalizat.resource.dao;

import com.digitalizat.organization.dao.Organization;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rallibau
 */
public class ResourceDaoIml implements ResourceDao{
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public ResourceDaoIml(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOrganization(Organization org) {
        sessionFactory.getCurrentSession().persist(this);
    }

    @Override
    public List<Resource> listResource() {
        return sessionFactory.getCurrentSession().createQuery("from Resource").list();
    }

    @Override
    public void removeResource(Integer id) {
        Resource res = (Resource) sessionFactory.getCurrentSession().load(
                Resource.class, id);
        if (null != res) {
            sessionFactory.getCurrentSession().delete(res);
        }
    }
    
    
}
