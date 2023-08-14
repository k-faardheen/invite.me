/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.invite.me.GUI;


import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.DriverManager;
/**
 *
 * @author Admin
 */
public interface CRUD_interface {
    static final String driver = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/invite.me";
    static final String user = "root";
    static final String pwd = "";
   //public void connect(){};
    
    
}
