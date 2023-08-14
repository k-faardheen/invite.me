/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.classes;

/**
 *
 * @author Admin
 */
public class conference extends event {

    private String[] speakers;
    private String[] sessions;
    private String[] sponsors;

    public conference(String[] speakers, String[] sessions, String[] sponsors, String eventName, String description, String date, String duration,String price, Venue venue) {
        super(eventName, description, date, duration,price, venue);
        this.speakers = speakers;
        this.sessions = sessions;
        this.sponsors = sponsors;
    }

    public String[] getSpeakers() {
        return speakers;
    }

    public void setSpeakers(String[] speakers) {
        this.speakers = speakers;
    }

    public String[] getSessions() {
        return sessions;
    }

    public void setSessions(String[] sessions) {
        this.sessions = sessions;
    }

    public String[] getSponsors() {
        return sponsors;
    }

    public void setSponsors(String[] sponsors) {
        this.sponsors = sponsors;
    }

    @Override
    public void setType() {
        super.type = "Conference";
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

}
