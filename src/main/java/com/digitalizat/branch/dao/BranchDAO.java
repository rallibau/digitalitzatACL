/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digitalizat.branch.dao;

import java.util.List;

/**
 *
 * @author rallibau
 */
public interface BranchDAO {
    public void addBranch(Branch branch);

    public List<Branch> listBranch();
    
    public List<Branch> listBranch(Integer idOrg);    

    public void removeBranch(Integer id);
    
    public Branch getBranch(Integer id) throws Exception;
    
}
