/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digitalizat.resource.dao;

import com.digitalizat.organization.dao.Organization;
import java.util.List;

/**
 *
 * @author rallibau
 */
public interface ResourceDao {
    public void addOrganization(Organization org);

    public List<Resource> listResource();

    public void removeResource(Integer id);
}
