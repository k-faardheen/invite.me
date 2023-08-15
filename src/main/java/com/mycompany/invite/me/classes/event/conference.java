/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.classes.event;

import com.mycompany.invite.me.InviteMe;
import com.mycompany.invite.me.classes.CRUD_interface;
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
public class conference extends event implements CRUD_interface {

    private String speaker;
    private String sponsors;

    public conference(String speakers, String sponsors, String eventName, String description, String date, String duration, String price, Venue venue) {
        super(eventName, description, date, duration, price, venue);
        this.speaker = speakers;
        this.sponsors = sponsors;
        setType();
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getSponsors() {
        return sponsors;
    }

    public void setSponsors(String sponsors) {
        this.sponsors = sponsors;
    }

    @Override
    public void setType() {
        super.type = "Conference";
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
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

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
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

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
