package com.mysite.entity;
// Generated 18 nov. 2016 19:03:38 by Hibernate Tools 4.3.1


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CourseSession generated by hbm2java
 */
public class CourseSession implements java.io.Serializable {


	private Integer id;
	private Course course;
	private Location location;
	private Date startDate;
	private Date endDate;
	private Set clients = new HashSet(0);

	public CourseSession() {
	}


	public CourseSession(Course course, Location location, Date startDate, Date endDate) {
		this.course = course;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public CourseSession(Course course, Location location, Date startDate, Date endDate, Set clients) {
		this.course = course;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.clients = clients;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set getClients() {
		return this.clients;
	}

	public void setClients(Set clients) {
		this.clients = clients;
	}


	public String formatDate(Date d) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
		return dateFormat.format(d);
	}

}


