/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.repository;

import com.mysite.entity.Location;

/**
 * @author Rémi
 */
public class LocationDao extends AbstractGenericDao<Location, Integer> {

	@Override
	Class<Location> getEntityClass() {
		return Location.class;
	}
}
