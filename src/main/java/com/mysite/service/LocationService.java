/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.service;

import com.mysite.entity.Location;
import com.mysite.repository.LocationDao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Rémi
 */
public class LocationService extends GenericServiceImpl<Location, Integer> implements Serializable{
    
    public LocationService(){
        super(new LocationDao());
    }

    @Override
    public List<Location> getAll() {
        LocationDao locationDao  = new LocationDao();
        return locationDao.findAll();
    }
}
