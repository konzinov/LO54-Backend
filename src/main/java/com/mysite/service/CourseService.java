/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.service;

import com.mysite.entity.Course;
import com.mysite.repository.CourseDao;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Rémi
 */
 public class CourseService extends GenericServiceImpl<Course, Integer>{
   
     public CourseService(Class c){
         super(c);
     }
}
