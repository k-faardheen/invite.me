/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.invite.me;

import com.mycompany.invite.me.GUI.loginIn;
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

//            java.awt.EventQueue.invokeLater(new Runnable() {
//                public void run() {
//                    new mainFrame().setVisible(true);
//                }
//            });
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new loginIn().setVisible(true);
            }
        });

    }
}
