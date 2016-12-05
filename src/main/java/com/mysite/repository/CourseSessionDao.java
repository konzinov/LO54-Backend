/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.repository;

import com.mysite.entity.CourseSession;
import com.mysite.entity.Location;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Rémi
 */
public class CourseSessionDao extends AbstractGenericDao<CourseSession, Integer>{
    
    //return a list of session filtered by date
    /*public List<CourseSession> filterByDate(Date date){
        //a finir
        Query courseSessionQuery = getSession().createQuery("FROM course_session cs WHERE :date BETWEEN cs.start_date AND cs.end_date");
        courseSessionQuery.setParameter("date", date);
        
        return courseSessionQuery.list();
    }
    
    //return a list of session filtered by location
    public List<CourseSession> filterByLocation(Location location){

        Query courseSessionQuery = getSession().createQuery("FROM course_session cs,location l WHERE cs.id = l.id AND l.city LIKE :city");
        //faux mais c'es l'idée
        courseSessionQuery.setParameter("city", "%"+location+"%");
        
        return courseSessionQuery.list();

    }*/

    public CourseSessionDao(Class c) {
        super(c);
    }
    
    //return a list of session filtered by date
    /*public List<CourseSession> filterByDate(Date date){
        //a finir
        Query courseSessionQuery = getSession().createQuery("FROM course_session cs WHERE :date BETWEEN cs.start_date AND cs.end_date");
        courseSessionQuery.setParameter("date", date);
        
        return courseSessionQuery.list();
    }
    
    //return a list of session filtered by location
    public List<CourseSession> filterByLocation(Location location){

        Query courseSessionQuery = getSession().createQuery("FROM course_session cs,location l WHERE cs.id = l.id AND l.city LIKE :city");
        //faux mais c'es l'idée
        courseSessionQuery.setParameter("city", "%"+location+"%");
        
        return courseSessionQuery.list();

    }*/
    
    
}
