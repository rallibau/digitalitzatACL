/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.digitalizat.organization.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rallibau
 */
@Entity
@Table(name = "ACL_ORGANIZATION")
public class Organization implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Integer id;
    @Column(name = "NAME")
    private String name;
//    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="organization")
//    private List<Branch> branchs = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombre) {
        this.name = nombre;
    }

//    public List<Branch> getBranchs() {
//        return branchs;
//    }
//
//    public void setBranchs(List<Branch> branchs) {
//        this.branchs = branchs;
//    }
    
    
    
}
