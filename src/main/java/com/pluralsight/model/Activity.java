/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pluralsight.model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author sambailey
 */

@XmlRootElement
public class Activity {
    
    private String id;
    private String description;
    private int duration;
    private User user;
    
    public User getUser(){
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public void setDuration (int duration) {
        this.duration = duration;
    }
}
