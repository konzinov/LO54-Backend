/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mysite.tools;

import com.mysite.entity.Client;
import com.mysite.entity.Course;
import com.mysite.entity.CourseSession;
import com.mysite.entity.Location;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Rémi
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {

			sessionFactory = new AnnotationConfiguration()
					.addAnnotatedClass(CourseSession.class)
					.addAnnotatedClass(Location.class)
					.addAnnotatedClass(Client.class)
					.addAnnotatedClass(Course.class)
					.setProperty("hibernate.connection.username", "root")
					.setProperty("hibernate.connection.password", "root")
					.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver")
					.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/school_manager_db")
					.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
					.setProperty("hbm2ddl.auto", "update")
					.setProperty("show_sql", "true")
					.setProperty("format_sql", "true")
					.setProperty("use_sql_comments", "true")
					.buildSessionFactory();

		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
