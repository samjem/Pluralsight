/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.client;

import com.pluralsight.model.Activity;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author sambailey
 */
public class ActivityClient {
    
    private Client client;
    
    public ActivityClient(){
        client = ClientBuilder.newClient();
    }
    
    public Activity get(String id) {
        WebTarget target = client.target("http://localhost:9090/exercise-services/webapi/");
        
        Response response = target.path("activities/" + id).request().get(Response.class); //request to get a class from model.Activity
        
        if(response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ":there was an error");
        }
        
        return response.readEntity(Activity.class);
    }
    
    public List<Activity> get() {
        WebTarget target = client.target("http://localhost:9090/exercise-services/webapi/");
        
        List<Activity> response = target.path("activities").request().get(new GenericType<List<Activity>>() {});
        
        return response;
    }
    
    public Activity create(Activity activity) {
        WebTarget target = client.target("http://localhost:9090/exercise-services/webapi/");
        
        Response response = target.path("activities/activity")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(activity, MediaType.APPLICATION_JSON));
        
        if (response.getStatus() != 200) {
            throw new RuntimeException(response.getStatus() + ": there was an error on the server");
        }
         return null;
    }
    
    
    
}
