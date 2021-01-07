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
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.status;
import static org.eclipse.persistence.sessions.remote.corba.sun.TransporterHelper.id;

/**
 *
 * @author sambailey
 */ 
@Path("activities")
public class ActivityResource {
    
    private ActivityRepositoryStub activityRepository = new ActivityRepositoryStub();
    
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivity(Activity activity) {
        activityRepository.create(activity);
        return activity;
    }
    
    
    
    @POST
    @Path("activity")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Activity createActivityParams(MultivaluedMap<String, String> formParams) {
       System.out.println(formParams.getFirst("description"));
       System.out.println(formParams.getFirst("duration"));
       return null;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Activity> getAllActivities() {
        
        return activityRepository.findAllActivities();
        
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{activityId}")
    public Response getActivity(@PathParam ("activityId") String activityId) {
        if(activityId == null || activityId.length() < 4) { 
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        Activity activity = activityRepository.findActivity(activityId);
        
        if(activity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok().entity(activity).build(); // .entity just adds on the activity data to be returned
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{activityId}/user")
    public User getActivityUser(@PathParam ("activityId") String activityId) {
        Activity activity = activityRepository.findActivity(activityId);
        User user = activity.getUser();
        return user;
    }
}
