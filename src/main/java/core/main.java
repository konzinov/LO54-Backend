/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import com.mysite.entity.Client;
import com.mysite.entity.CourseSession;
import com.mysite.entity.Location;
import com.mysite.service.ClientService;
import com.mysite.service.LocationService;

/**
 *
 * @author Rémi
 */
public class main {
    public static void main(String[] args) {
        
        Location l = new Location("Paris");
        
        LocationService ls = new LocationService();
        
        ls.add(l);
    }
}
