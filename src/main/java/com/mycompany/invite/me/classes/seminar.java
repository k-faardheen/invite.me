/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.classes;

/**
 *
 * @author Admin
 */
public class seminar extends event {

    private String speaker;
    private String topic;

    public seminar(String eventName, String description, String date, String duration, String price, Venue venue) {
        super(eventName, description, date, duration, price, venue);
        this.speaker = speaker;
        this.topic = topic;

    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    @Override
    public void setType() {
        super.type = "seminar";
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
