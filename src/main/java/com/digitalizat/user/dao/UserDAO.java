/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalizat.user.dao;

import java.util.List;

/**
 *
 * @author rallibau
 */
public interface UserDAO {

    public void addUser(User contact);

    public List<User> listUser();

    public void removeUser(Integer id);
    
    public User getUser(Integer id) throws Exception;
    
    public User getUser(String name) throws Exception;

}
