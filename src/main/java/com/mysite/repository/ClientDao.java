/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.repository;

import com.mysite.entity.Client;


/**
 *
 * @author Rémi
 */
public class ClientDao extends AbstractGenericDao<Client,Integer> {

	@Override
	Class<Client> getEntityClass() {
		return Client.class;
	}
}

