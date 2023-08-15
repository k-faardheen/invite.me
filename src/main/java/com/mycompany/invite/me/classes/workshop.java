/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.classes;

import com.mycompany.invite.me.InviteMe;
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
public class workshop extends event implements CRUD_interface {

    private String instructor;
    private String material;

    public workshop(String eventName, String description, String date, String duration, String price, Venue venue, String instructor, String material) {
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

    public void display() {
        //super.display();
        //System.out.println("workshop{" + "instructor=" + instructor + ", material=" + material + '}');

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
            ps.setString(8, getInstructor());
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
            ps.setString(8, getInstructor());
            ps.setString(9, id);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Updated sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
