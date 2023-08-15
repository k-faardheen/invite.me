/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.classes.event;

/**
 *
 * @author Admin
 */
public class Venue {

    private String venueName;
    private String venueLocation;

    public Venue(String venueName, String venueLocation) {
        this.venueName = venueName;
        this.venueLocation = venueLocation;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getVenueLocation() {
        return venueLocation;
    }

    public void setVenueLocation(String venueLocation) {
        this.venueLocation = venueLocation;
    }

   
    public String display() {
        return "Venue{" + "venueName=" + venueName + ", venueLocation=" + venueLocation + '}';
    }

 

}
