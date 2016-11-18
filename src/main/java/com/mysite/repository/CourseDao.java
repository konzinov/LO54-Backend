/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.repository;

import com.mysite.entity.Course;

import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Rémi
 */
public class CourseDao extends AbstractGenericDao<Course, Integer>{
    
    //return a list of course filtered by title
    public List<Course> filterByTitle(String title){
    
        Query courseQuery = getSession().createQuery("from Course c where title LIKE :title");
        courseQuery.setParameter("title", "%"+title+"%");
        
        return courseQuery.list();
    }
    
    
}
