/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digitalizat.organization.dao;

import com.digitalizat.branch.dao.Branch;
import java.util.List;

/**
 *
 * @author rallibau
 */
public interface OrganizationDAO {
     public void addOrganization(Organization org);

    public List<Organization> listOrganization();

    public void removeOrganization(Integer id);
    
    public Branch getMainBranch(Integer id);
    
}
