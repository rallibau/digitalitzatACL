/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizat.business;

import com.digitalizat.branch.dao.Branch;
import com.digitalizat.branch.dao.BranchDAO;
import com.digitalizat.organization.dao.Organization;
import com.digitalizat.organization.dao.OrganizationDAO;
import com.digitalizat.resource.dao.Resource;
import com.digitalizat.resource.dao.ResourceDao;
import com.digitalizat.user.dao.User;
import com.digitalizat.user.dao.UserDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rallibau
 */
@Service
@Transactional
public class ACLManagerIml implements ACLMananger {

    @Autowired
    private UserDAO userDAO;
    
    @Autowired
    private OrganizationDAO organizationDAO;
    
    @Autowired
    private BranchDAO branchDAO; 
    
    @Autowired
    private ResourceDao resourceDAO;
            

    @Override
    public User getUser(String name) throws Exception {
        return userDAO.getUser(name);
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public void addOrganization(Organization org) {
        //creamos la sucursal principal
        Branch mainBranch = new Branch();
        mainBranch.setName("main");
        mainBranch.setMain(Boolean.TRUE);
        mainBranch.setOrganization(org);
       
        organizationDAO.addOrganization(org);
        branchDAO.addBranch(mainBranch);
        
    }

    @Override
    public Branch getOrgMainBranch(Integer id) {
        return organizationDAO.getMainBranch(id);
    }

    @Override
    public List<Resource> getAllResource(Integer idUser) {
        return resourceDAO.listResource();
    }

    @Override
    public List<User> getAllOrgUsers(Integer idBranch) {
        return userDAO.listUser();
    }

}
