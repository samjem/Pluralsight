/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.repository;

import java.util.List;
import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import java.util.ArrayList;

/**
 *
 * @author sambailey
 */
public class ActivityRepositoryStub implements ActivityRepository {
    
    public List<Activity> findAllActivities() {
        
        List<Activity> activities = new ArrayList<Activity>();
        
        Activity activity1 = new Activity();
        
        activity1.setDescription ("swimming");
        activity1.setDuration(55);
        
        activities.add(activity1);
        
        Activity activity2 = new Activity();
        
        activity2.setDescription ("cycling");
        activity2.setDuration(120);
        
        activities.add(activity2);
        
        return activities;
    }
    
    public Activity findActivity(String activityId) {
        
         if(activityId.equals("7777")) {
             return null; //null test
         }
        
        Activity activity1 = new Activity();
        
        activity1.setId("1234");
        activity1.setDescription ("swimming");
        activity1.setDuration(55);
        
        User user = new User();
        user.setId("5678");
        user.setName("bryan");
        
        activity1.setUser(user);
        
        return activity1;
    }
    
    public void create(Activity activity){
        //insert into db
    }
    
}
