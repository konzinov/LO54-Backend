/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.service;

import com.mysite.entity.CourseSession;
import com.mysite.repository.CourseSessionDao;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Rémi
 */
public class CourseSessionService extends GenericServiceImpl<CourseSession, Integer> {
    
    public List<CourseSession> showSessionFromCriteria(Map<String,String> map){
        
        CourseSessionDao courseSessionDao = new CourseSessionDao(CourseSession.class);
        
        List<CourseSession> courseSessionList = courseSessionDao.findByColumns(map);
        
        return courseSessionList;
    }
}
