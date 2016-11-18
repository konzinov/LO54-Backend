/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.repository;

import com.mysite.entity.Client;
import com.mysite.repository.GenericDao;
import org.hibernate.Query;

/**
 *
 * @author Rémi
 */
public class ClientDao extends AbstractGenericDao<Client,Integer> {
    
    public boolean removeClientById(Integer id){
        Query clientTaskQuery = getSession().createQuery("from Client u where :id");
        clientTaskQuery.setParameter("id", id);
        
        return clientTaskQuery.executeUpdate() > 0;
    }
    
    //Register the client to a specific course_session
    public boolean registerNewClient(){
        
        
        
    }
    
    
    
    
    
    
}

