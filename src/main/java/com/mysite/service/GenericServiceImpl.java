/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.service;

import com.mysite.repository.AbstractGenericDao;
import com.mysite.repository.GenericDao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rémi
 * @param <E>
 * @param <K>
 */
public abstract class GenericServiceImpl<E, K extends Serializable> implements GenericService<E, K> {
    
    private GenericDao<E,K> genericDao ;
    
    public GenericServiceImpl(GenericDao<E, K> genericDao){
        this.genericDao = genericDao;
    }

    @Override
    public List<E> getAll(){
        return genericDao.findAll();
    }
    
    @Override
    public E get(K id){
        return genericDao.find(id);
    }
    
    @Override
    public void add(E entity){
        genericDao.save(entity);
    }
    
    @Override
    public void update(E entity){
        genericDao.saveOrUpdate(entity);
    }
    
    @Override
    public void delete(E entity){
        genericDao.delete(entity);
    }

    public List<E> findBy(Map<String, String> map) {
        return genericDao.findBy(map);
    }
}
