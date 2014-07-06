/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digitalizat.business;

import com.digitalizat.branch.dao.Branch;
import com.digitalizat.organization.dao.Organization;
import com.digitalizat.resource.dao.Resource;
import com.digitalizat.user.dao.User;
import java.util.List;

/**
 *
 * @author rallibau
 */
public interface ACLMananger {
    public User getUser(String name) throws Exception;
    public void addUser(User user);
    public void addOrganization(Organization org);
    public Branch getOrgMainBranch(Integer id);
    public List<Resource> getAllResource(Integer idUser);
    public List<User> getAllOrgUsers(Integer idBranch);
    
}
