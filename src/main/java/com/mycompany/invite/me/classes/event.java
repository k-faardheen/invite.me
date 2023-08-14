/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.classes;

/**
 *
 * @author Admin
 */
public abstract class event {

    String eventName;
    String description;
    String date;
    String duration;
    String price;
    Venue venue;
    String type;

    public event(String eventName, String description, String date, String duration, String price, Venue venue) {
        this.eventName = eventName;
        this.description = description;
        this.date = date;
        this.duration = duration;
        this.venue = venue;
        this.price = price;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public abstract void setType();

    public abstract String getEventName();

    
    public void display() {
        System.out.println("event{" + "eventName=" + eventName + ", description=" + description + ", date=" + date + ", duration=" + duration + ", price=" + price + ", venue=" +venue.display()+ ", type=" + type + '}');
    };

    public abstract String getDescription();

    public abstract String getDuration();

    public abstract Venue getVenue();

    public abstract String getDate();

    public abstract String getPrice();
}
