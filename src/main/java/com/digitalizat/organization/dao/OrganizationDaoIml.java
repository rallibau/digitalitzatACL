/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizat.organization.dao;

import com.digitalizat.branch.dao.Branch;
import com.digitalizat.branch.dao.BranchDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rallibau
 */
@Repository
public class OrganizationDaoIml implements OrganizationDAO {
    
    private SessionFactory sessionFactory;
    
    @Autowired
    private BranchDAO branchDAO;
    
    @Autowired
    public OrganizationDaoIml(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addOrganization(Organization org) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(org);
    }

    @Override
    public List<Organization> listOrganization() {
        return sessionFactory.getCurrentSession().createQuery("from Organization").list();
    }

    @Override
    public void removeOrganization(Integer id) {
        Organization org = (Organization) sessionFactory.getCurrentSession().load(
                Organization.class, id);
        if (null != org) {
            sessionFactory.getCurrentSession().delete(org);
        }
    }

    @Override
    public Branch getMainBranch(Integer id) {
        Branch result = null;
        Organization org = (Organization) sessionFactory.getCurrentSession().load(
                Organization.class, id);
        List<Branch> branchs = branchDAO.listBranch(id);
        for(Branch branch:branchs){
            if(branch.isMain()){
                result = branch;
                break;
            }
        }
        return result;
    }

}
