/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.classes;

import com.mycompany.invite.me.InviteMe;
import static com.mycompany.invite.me.classes.CRUD_interface.DB_URL;
import static com.mycompany.invite.me.classes.CRUD_interface.driver;
import static com.mycompany.invite.me.classes.CRUD_interface.pwd;
import static com.mycompany.invite.me.classes.CRUD_interface.user;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class seminar extends event implements CRUD_interface {

    private String speaker;
    private String topic;

    public seminar(String eventName, String description, String date, String duration, String price, Venue venue, String speaker, String topic) {
        super(eventName, description, date, duration, price, venue);
        this.speaker = speaker;
        this.topic = topic;
        setType();
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

    public String getType() {
        return super.type;
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

    @Override
    public Connection connect() {

        try {

            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InviteMe.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection(DB_URL, user, pwd);
        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    @Override
    public void create() {

        try {
            PreparedStatement ps = connect().prepareStatement("insert into event(eventName, description, date, duration, price, venue, type, speaker)values(?,?,?,?,?,?,?,?)");
            ps.setString(1, getEventName());
            ps.setString(2, getDescription());
            ps.setString(3, getDate());
            ps.setString(4, getDuration());
            ps.setString(5, getPrice());
            ps.setString(6, getVenue().getVenueName());
            ps.setString(7, getType());
            ps.setString(8, getSpeaker());
            ps.executeUpdate();
            //System.out.println("Inserted sucessfully");
            JOptionPane.showMessageDialog(null, "Inserted sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id) {

        try {
            PreparedStatement ps = connect().prepareStatement("UPDATE event set eventName=?, description=?, date=?, duration=?, price=?, venue=?, type=?, speaker=? where eventId=?");
            ps.setString(1, getEventName());
            ps.setString(2, getDescription());
            ps.setString(3, getDate());
            ps.setString(4, getDuration());
            ps.setString(5, getPrice());
            ps.setString(6, getVenue().getVenueName());
            ps.setString(7, getType());
            ps.setString(8, getSpeaker());
            ps.setString(9, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
