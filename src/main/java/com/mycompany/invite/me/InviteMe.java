/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.invite.me;

import com.mycompany.invite.me.GUI.mainFrame;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class InviteMe {

    public static void main(String[] args) throws SQLException {

       // try {
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new mainFrame().setVisible(true);
                }
            });

//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(InviteMe.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/invite.me", "root", "");
//        System.out.println(con);

    }
}
