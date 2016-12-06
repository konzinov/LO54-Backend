/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import com.mysite.entity.Client;
import com.mysite.entity.Course;
import com.mysite.entity.CourseSession;
import com.mysite.entity.Location;
import com.mysite.service.ClientService;
import com.mysite.service.CourseService;
import com.mysite.service.CourseSessionService;
import com.mysite.service.LocationService;
import java.util.List;

/**
 *
 * @author Rémi
 */
public class main {
    public static void main(String[] args) {
        
        Location l = new Location("Paris");
        List<Location> locations ;
        List<CourseSession> sessions ;
        LocationService ls  = new LocationService(Location.class);
        CourseSessionService cs = new CourseSessionService(CourseSession.class);
        sessions = cs.showIncomingSessions();
        locations = ls.getAll();
        System.out.println(locations.get(0).getCity());
        System.out.println(sessions.get(1).getLocation().getCity());
        
        
        
        
              
    }
}
