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
 * @author faardheen
 */
public class expenses implements CRUD_interface {

    private String eventName;
    private String title;
    private String description;
    private String amount;
    private String date;
    private String status;

    public expenses(String eventName, String title, String description, String amount, String date, String status) {
        this.eventName = eventName;
        this.title = title;
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
            Logger.getLogger(InviteMe.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    @Override
    public void create() {

        try {
            PreparedStatement ps = connect().prepareStatement("INSERT INTO expenses (eventName, title, description, amount, date, status)values(?,?,?,?,?,?)");
            ps.setString(1, getEventName());
            ps.setString(2, getTitle());
            ps.setString(3, getDescription());
            ps.setString(4, getAmount());
            ps.setString(5, getDate());
            ps.setString(6, getStatus());
            ps.executeUpdate();
            //System.out.println("Inserted sucessfully");
            JOptionPane.showMessageDialog(null, "Inserted sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(InviteMe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String id) {
        try {
            PreparedStatement ps = connect().prepareStatement("UPDATE  expenses  SET eventName=?, title=?, description=?, amount=?, date=?, status=? where expenseId=?");
            ps.setString(1, getEventName());
            ps.setString(2, getTitle());
            ps.setString(3, getDescription());
            ps.setString(4, getAmount());
            ps.setString(5, getDate());
            ps.setString(6, getStatus());
            ps.setString(7, id);
            ps.executeUpdate();
            //System.out.println("Inserted sucessfully");
            JOptionPane.showMessageDialog(null, "Updated sucessfully");
        } catch (SQLException ex) {
            Logger.getLogger(InviteMe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
