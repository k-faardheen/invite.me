/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.classes;

/**
 *
 * @author Admin
 */
public class workshop extends event {
    private String instructor;
    private String material;

    public workshop(String eventName, String description, String date, String duration,String price, Venue venue,String instructor, String material) {
        super(eventName, description, date, duration, price, venue);
        this.instructor = instructor;
        this.material = material;
        setType();
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void setType() {
         super.type = "workshop";
    }
     public String getEventName() {
        return super.eventName;
    }

    public String getDescription() {
        return super.description;
    }

   
    public String getDuration() {
        return super.duration;
    }

    public Venue getVenue() {
        return super.venue;
    }
    public String getDate() {
        return super.date;
    }

    public String getPrice() {
        return super.price;
    }


    public void display() {
        super.display();
        System.out.println("workshop{" + "instructor=" + instructor + ", material=" + material + '}');
    }
    
}
