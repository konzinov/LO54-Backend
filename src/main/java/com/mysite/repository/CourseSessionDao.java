/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.repository;

import com.mysite.entity.CourseSession;
import com.mysite.entity.Location;
import com.mysite.tools.HibernateUtil;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

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
    
    public List<CourseSession> findByColumns(Map<String,String> map){
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        Date date_start = null;
        Date date_end = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
                
        Criteria criteria = session.createCriteria(CourseSession.class,"coursesession")
                    .setFetchMode("coursesession.location", FetchMode.JOIN)
                    .createAlias("coursesession.location", "location")
                    .setFetchMode("coursesession.course", FetchMode.JOIN)
                    .createAlias("coursesession.course", "course");
        
        if(map.get("date") != null){
            try{
                date_start =  formatter.parse(map.get("date"));
            }catch(ParseException e){
                e.printStackTrace();
            }
            criteria.add(Restrictions.gt("dateStart", date_start));
        }
        
        if(map.get("date") != null){
            try{
                date_end = formatter.parse(map.get("date"));
            }catch(ParseException e){
                e.printStackTrace();
            }
            criteria.add(Restrictions.lt("dateEnd", date_end));
        }
        
        if(map.get("location_id") != null){
            criteria.add(Restrictions.eq("location.id", Integer.parseInt(map.get("location_id"))));
        }
        
        if(map.get("course_id") != null){
            criteria.add(Restrictions.eq("course.code", Integer.parseInt(map.get("course_id"))));
        }
        
        List<CourseSession> result = criteria.list();
        
        session.close();
        return result;
    }
    
            
    public List<CourseSession> findByDate(Date startDate){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(CourseSession.class, "coursesession")
                                   .setFetchMode("coursesession.location", FetchMode.JOIN)
                                   .createAlias("coursesession.location", "location")
                                   .setFetchMode("coursesession.course", FetchMode.JOIN)
                                   .createAlias("coursesession.course", "course")
                                   .add(Restrictions.gt("startDate", startDate))
                                   .addOrder(Order.asc("startDate"))
                                   .setMaxResults(3);
        List<CourseSession> result = criteria.list();
        session.close();
        
        return result;
    }
            
    
}
