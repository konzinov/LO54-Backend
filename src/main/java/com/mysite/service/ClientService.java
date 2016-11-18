/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.service;

import com.mysite.entity.Client;
import com.mysite.repository.ClientDao;
import java.util.List;

/**
 *
 * @author Rémi
 */
public class ClientService  extends GenericServiceImpl<Client,Integer>{
    
    /*ClientDao clientDao;
    
    public List<Client> getAllClient(){
        return clientDao.findAll();
    }
    
    public void addNewClient(Client client){
        Client cli = new Client();
        cli.setFirstname(client.getFirstname());
        cli.setLastname(client.getLastname());
        List<Client> cliList = clientDao.findAllByExample(cli);
        if(cliList == null || cliList.isEmpty()){
            Long id = (Long) clientDao.save(client);
            System.out.println("If of new Client "+ id);
            
        } else {
            System.out.println("Client " + cli + " already exists");
        }
    }
    
    public boolean removeClient(Integer id){
        return clientDao.removeClientById(id);
    }
    */
    //public List<CourseSession> getCourseSession(Client client);    
}
