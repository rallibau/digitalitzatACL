/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digitalitzat.user.dao;

import com.digitalitzat.user.pojo.User;
import java.util.List;

/**
 *
 * @author rallibau
 */
public interface UserDAO {

    public void addUser(User contact);

    public List<User> listUser();

    public void removeUser(Integer id);

}