/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.invite.me;

import com.mycompany.invite.me.GUI.mainFrame;

/**
 *
 * @author Admin
 */
public class InviteMe {

    public static void main(String[] args) {
//           java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new eventGUI().setVisible(true);
//            }
//        });     
//        
 java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainFrame().setVisible(true);
            }
        });
    }
}
