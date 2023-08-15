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
import com.mycompany.invite.me.classes.event.workshop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class attendee implements CRUD_interface{
    private String name;
    private String contDetails;
    private String dob;
    private String eventName;
    private String status;

    public attendee(String name, String contDetails, String dob, String eventName, String status) {
        this.name = name;
        this.contDetails = contDetails;
        this.dob = dob;
        this.eventName = eventName;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContDetails() {
        return contDetails;
    }

    public void setContDetails(String contDetails) {
        this.contDetails = contDetails;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public Connection connect() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
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
    }

    @Override
    public void update(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
