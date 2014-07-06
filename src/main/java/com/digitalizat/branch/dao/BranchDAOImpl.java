/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digitalizat.branch.dao;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author rallibau
 */
public class BranchDAOImpl implements BranchDAO{
    
    private SessionFactory sessionFactory;
    
    @Autowired
    public BranchDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addBranch(Branch branch) {
        sessionFactory.getCurrentSession().persist(branch);
    }

    @Override
    public List<Branch> listBranch() {
        return sessionFactory.getCurrentSession().createQuery("from Branch").list();
    }

    @Override
    public void removeBranch(Integer id) {
        Branch branch = (Branch) sessionFactory.getCurrentSession().load(Branch.class, id);
        if (null != branch) {
            sessionFactory.getCurrentSession().delete(branch);
        }
    }

    @Override
    public Branch getBranch(Integer id) throws Exception {
        return (Branch) sessionFactory.getCurrentSession().load(Branch.class, id);
    }

    @Override
    public List<Branch> listBranch(Integer idOrg) {
      Query query = sessionFactory.getCurrentSession().createQuery("FROM Branch b JOIN FETCH b.organization o where o.id = :idOrg");
        query.setParameter("idOrg", idOrg);
        List<Branch> resultado = query.list();
        
        return resultado;
    }
    
}
