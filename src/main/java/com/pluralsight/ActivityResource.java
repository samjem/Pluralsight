/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepositoryStub;
import javax.ws.rs.PathParam;

/**
 *
 * @author sambailey
 */ 
@Path("activities")
public class ActivityResource {
    
    private ActivityRepositoryStub activityRepository = new ActivityRepositoryStub();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> getAllActivities() {
        
        return activityRepository.findAllActivities();
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{avitivityId}")
    public Activity getActivity(@PathParam ("activityId") String activityId) {
        return activityRepository.findActivity(activityId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{avitivityId}/user")
    public User getActivityUser(@PathParam ("activityId") String activityId) {
        Activity activity = activityRepository.findActivity(activityId);
        User user = activity.getUser();
        return user;
    }
}
