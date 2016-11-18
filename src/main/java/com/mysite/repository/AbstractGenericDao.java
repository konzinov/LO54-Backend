/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

/**
 *
 * @author Rémi
 * @param <E>
 * @param <K>
 */
public abstract class AbstractGenericDao<E,K extends Serializable> implements GenericDao<E,K> {
    
    private SessionFactory sessionFactory;

    protected Class<? extends E> entityClass;
    
    public AbstractGenericDao(){
        this.entityClass = (Class<E>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    
    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    
    
    public E findById(final Serializable id){
        return (E) getSession().get(this.entityClass,id);
    }
    
    @Override
    public Serializable save(E entity){
        return getSession().save(entity);
    }
    
    @Override
    public void saveOrUpdate(E entity){
        getSession().saveOrUpdate(entity);
    }
    
    @Override
    public void delete(E entity){
        getSession().delete(entity);
    }
    
    @Override
    public void deleteAll(){
        List<E> entities = findAll();
        for(E entity : entities){
            getSession().delete(entity);
        }
    }
    
    @Override
    public List<E> findAll(){
        return getSession().createCriteria(this.entityClass).list();
    }
    
    @Override
    public List<E> findAllByExample(E entity){
        Example example = Example.create(entity).ignoreCase().enableLike().excludeZeroes();
        return getSession().createCriteria(this.entityClass).add(example).list();
    }
    
    @Override
    public E find(K key){
        return (E) getSession().get(entityClass,key);
    }
    
    @Override
    public void clear(){
        getSession().clear();
    }
    
    @Override
    public void flush(){
        getSession().flush();
    }
}
