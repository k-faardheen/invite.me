/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.invite.me.GUI;

import com.mycompany.invite.me.GUI.event.getRowEvent;
import com.mycompany.invite.me.GUI.event.createEvt;
import com.mycompany.invite.me.InviteMe;
import com.mycompany.invite.me.classes.workshop;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Admin
 */
public class mainFrame extends javax.swing.JFrame {

    /**
     * Creates new form mainFrame
     */
    public mainFrame() {

        initComponents();
        initTables();
        fetchEventTable();
        fetchAtdTable();
        fetchRevTable();
        fetchExpTable();
    }
    getRowEvent eventRow = new getRowEvent();
    getRowAtd atdRow = new getRowAtd();
    getRowExp expRow = new getRowExp();

    public Connection connect() {

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InviteMe.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/invite.me", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void initTables() {
        JTable table1 = jTable1;
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table1.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table1.setDefaultRenderer(String.class, centerRenderer);

        JTable table2 = jTable2;
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table2.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table2.setDefaultRenderer(String.class, centerRenderer);

        JTable table3 = jTable3;
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table3.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table3.setDefaultRenderer(String.class, centerRenderer);

        JTable table4 = jTable4;
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        table4.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        table4.setDefaultRenderer(String.class, centerRenderer);
    }

    public void fetchEventTable() {

        try {
            PreparedStatement ps = connect().prepareStatement("select * from event");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int n = rsmd.getColumnCount();
            DefaultTableModel table1 = (DefaultTableModel) jTable1.getModel();

            table1.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= n; i++) {
                    v.add(rs.getString("eventId"));
                    v.add(rs.getString("eventName"));
                    v.add(rs.getString("description"));
                    v.add(rs.getString("date"));
                    v.add(rs.getString("duration"));
                    v.add(rs.getString("price"));
                    v.add(rs.getString("venue"));
                    v.add(rs.getString("type"));
                    v.add(rs.getString("speaker"));

                }

                table1.addRow(v);

            }

        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fetchRevTable() {
        try {
            PreparedStatement ps = connect().prepareStatement("SELECT event.eventName, COUNT(attendee.fullName) AS attendees,event.date, event.price AS total_price FROM event JOIN attendee ON event.eventName = attendee.eventName GROUP BY event.eventName;");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int n = rsmd.getColumnCount();
            DefaultTableModel table1 = (DefaultTableModel) jTable3.getModel();

            table1.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= n; i++) {
                    v.add(rs.getString("eventName"));
                    v.add(rs.getString("total_price"));
                    v.add(rs.getString("date"));
                    v.add(rs.getString("attendees"));

                }

                table1.addRow(v);

            }

        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void fetchAtdTable() {
        //System.out.println("test");
        try {
            PreparedStatement ps = connect().prepareStatement("select * from attendee");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int n = rsmd.getColumnCount();
            DefaultTableModel table1 = (DefaultTableModel) jTable2.getModel();
            
            table1.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= n; i++) {
                    v.add(rs.getString("attendeeId"));
                    v.add(rs.getString("fullName"));
                    v.add(rs.getString("contactDetails"));
                    v.add(rs.getString("dob"));
                    v.add(rs.getString("eventName"));
                    v.add(rs.getString("status"));

                }
              
                table1.addRow(v);

            }

        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void fetchExpTable() {
        try {
            PreparedStatement ps = connect().prepareStatement("select * from expenses");
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int n = rsmd.getColumnCount();
            DefaultTableModel table1 = (DefaultTableModel) jTable4.getModel();

            table1.setRowCount(0);

            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 1; i <= n; i++) {
                    v.add(rs.getString("expenseId"));
                    v.add(rs.getString("eventName"));
                    v.add(rs.getString("title"));
                    v.add(rs.getString("description"));
                    v.add(rs.getString("amount"));
                    v.add(rs.getString("date"));
                    v.add(rs.getString("status"));

                }

                table1.addRow(v);

            }

        } catch (SQLException ex) {
            Logger.getLogger(workshop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        eventBtn = new javax.swing.JButton();
        atdBtn = new javax.swing.JButton();
        revBtn = new javax.swing.JButton();
        expBtn = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        eventPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        crtEvtBtn = new javax.swing.JButton();
        refreshEvtTable = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        attendeePanel = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        crtAtd = new javax.swing.JButton();
        refreshAtdTable = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        RevenuePanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        refreshAtdTable1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        ExpensePanel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        crtExp = new javax.swing.JButton();
        refreshExpTable = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        ReportPanel = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        genReport = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("invite.me");

        sidePanel.setBackground(new java.awt.Color(217, 217, 217));
        sidePanel.setPreferredSize(new java.awt.Dimension(300, 800));

        jPanel1.setBackground(new java.awt.Color(217, 217, 217));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("invite.me");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(217, 217, 217));

        eventBtn.setBackground(new java.awt.Color(51, 51, 51));
        eventBtn.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        eventBtn.setForeground(new java.awt.Color(255, 255, 255));
        eventBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/planner(1).png"))); // NOI18N
        eventBtn.setText("Event");
        eventBtn.setBorderPainted(false);
        eventBtn.setFocusable(false);
        eventBtn.setIconTextGap(15);
        eventBtn.setPreferredSize(new java.awt.Dimension(200, 35));
        eventBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eventBtnActionPerformed(evt);
            }
        });

        atdBtn.setBackground(new java.awt.Color(51, 51, 51));
        atdBtn.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        atdBtn.setForeground(new java.awt.Color(255, 255, 255));
        atdBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/staff(1).png"))); // NOI18N
        atdBtn.setText("Attendees");
        atdBtn.setBorderPainted(false);
        atdBtn.setFocusable(false);
        atdBtn.setIconTextGap(15);
        atdBtn.setPreferredSize(new java.awt.Dimension(200, 35));
        atdBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atdBtnActionPerformed(evt);
            }
        });

        revBtn.setBackground(new java.awt.Color(51, 51, 51));
        revBtn.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        revBtn.setForeground(new java.awt.Color(255, 255, 255));
        revBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/revenue(1).png"))); // NOI18N
        revBtn.setText("Revenue");
        revBtn.setBorderPainted(false);
        revBtn.setFocusable(false);
        revBtn.setIconTextGap(15);
        revBtn.setPreferredSize(new java.awt.Dimension(200, 35));
        revBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                revBtnActionPerformed(evt);
            }
        });

        expBtn.setBackground(new java.awt.Color(51, 51, 51));
        expBtn.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        expBtn.setForeground(new java.awt.Color(255, 255, 255));
        expBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/expenses(1).png"))); // NOI18N
        expBtn.setText("Expenses");
        expBtn.setBorderPainted(false);
        expBtn.setFocusable(false);
        expBtn.setIconTextGap(15);
        expBtn.setPreferredSize(new java.awt.Dimension(200, 35));
        expBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eventBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(atdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(revBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(expBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(eventBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(atdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(revBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(expBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(982, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidePanelLayout = new javax.swing.GroupLayout(sidePanel);
        sidePanel.setLayout(sidePanelLayout);
        sidePanelLayout.setHorizontalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addGroup(sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sidePanelLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(607, 607, 607))
        );
        sidePanelLayout.setVerticalGroup(
            sidePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane2.setEnabled(false);
        jTabbedPane2.setFocusable(false);
        jTabbedPane2.setRequestFocusEnabled(false);
        jTabbedPane2.setVerifyInputWhenFocusTarget(false);

        eventPanel.setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel3.setPreferredSize(new java.awt.Dimension(1500, 102));

        crtEvtBtn.setBackground(new java.awt.Color(51, 51, 51));
        crtEvtBtn.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        crtEvtBtn.setForeground(new java.awt.Color(255, 255, 255));
        crtEvtBtn.setText("Create Event");
        crtEvtBtn.setBorderPainted(false);
        crtEvtBtn.setFocusable(false);
        crtEvtBtn.setPreferredSize(new java.awt.Dimension(200, 35));
        crtEvtBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crtEvtBtnActionPerformed(evt);
            }
        });

        refreshEvtTable.setBackground(new java.awt.Color(51, 51, 51));
        refreshEvtTable.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        refreshEvtTable.setForeground(new java.awt.Color(255, 255, 255));
        refreshEvtTable.setText("Refresh");
        refreshEvtTable.setBorder(null);
        refreshEvtTable.setBorderPainted(false);
        refreshEvtTable.setFocusPainted(false);
        refreshEvtTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshEvtTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(refreshEvtTable, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(crtEvtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crtEvtBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshEvtTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 14)); // NOI18N

        jTable1.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Event Id", "Event Name", "Description", "Date", "Duration(days)", "Price", "Venue", "Type", "speaker"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setPreferredSize(new java.awt.Dimension(375, 200));
        jTable1.setRowHeight(40);
        jTable1.setShowGrid(false);
        jTable1.setShowHorizontalLines(true);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(309, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(108, 108, 108))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(431, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout eventPanelLayout = new javax.swing.GroupLayout(eventPanel);
        eventPanel.setLayout(eventPanelLayout);
        eventPanelLayout.setHorizontalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 1524, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        eventPanelLayout.setVerticalGroup(
            eventPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventPanelLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab1", eventPanel);

        attendeePanel.setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel5.setPreferredSize(new java.awt.Dimension(1500, 102));

        crtAtd.setBackground(new java.awt.Color(51, 51, 51));
        crtAtd.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        crtAtd.setForeground(new java.awt.Color(255, 255, 255));
        crtAtd.setText("Add Attendee");
        crtAtd.setBorderPainted(false);
        crtAtd.setFocusable(false);
        crtAtd.setPreferredSize(new java.awt.Dimension(200, 35));
        crtAtd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crtAtdActionPerformed(evt);
            }
        });

        refreshAtdTable.setBackground(new java.awt.Color(51, 51, 51));
        refreshAtdTable.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        refreshAtdTable.setForeground(new java.awt.Color(255, 255, 255));
        refreshAtdTable.setText("Refresh");
        refreshAtdTable.setBorder(null);
        refreshAtdTable.setFocusable(false);
        refreshAtdTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAtdTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(refreshAtdTable, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(crtAtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crtAtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshAtdTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane2.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 14)); // NOI18N

        jTable2.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Attendee Id", "Full Name", "Contact details", "DOB", "Event Name", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setPreferredSize(new java.awt.Dimension(375, 200));
        jTable2.setRowHeight(40);
        jTable2.setShowGrid(false);
        jTable2.setShowHorizontalLines(true);
        jTable2.getTableHeader().setResizingAllowed(false);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 425, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout attendeePanelLayout = new javax.swing.GroupLayout(attendeePanel);
        attendeePanel.setLayout(attendeePanelLayout);
        attendeePanelLayout.setHorizontalGroup(
            attendeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1524, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        attendeePanelLayout.setVerticalGroup(
            attendeePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendeePanelLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab2", attendeePanel);

        RevenuePanel.setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel7.setPreferredSize(new java.awt.Dimension(1500, 102));

        refreshAtdTable1.setBackground(new java.awt.Color(51, 51, 51));
        refreshAtdTable1.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        refreshAtdTable1.setForeground(new java.awt.Color(255, 255, 255));
        refreshAtdTable1.setText("Refresh");
        refreshAtdTable1.setBorder(null);
        refreshAtdTable1.setFocusable(false);
        refreshAtdTable1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAtdTable1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(refreshAtdTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(refreshAtdTable1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane3.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 14)); // NOI18N

        jTable3.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Event Name", "Price", "From Date", "Number of Attendees"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable3.setPreferredSize(new java.awt.Dimension(375, 200));
        jTable3.setRowHeight(40);
        jTable3.setShowGrid(false);
        jTable3.setShowHorizontalLines(true);
        jTable3.getTableHeader().setResizingAllowed(false);
        jTable3.getTableHeader().setReorderingAllowed(false);
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 425, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout RevenuePanelLayout = new javax.swing.GroupLayout(RevenuePanel);
        RevenuePanel.setLayout(RevenuePanelLayout);
        RevenuePanelLayout.setHorizontalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1524, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        RevenuePanelLayout.setVerticalGroup(
            RevenuePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RevenuePanelLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab2", RevenuePanel);

        ExpensePanel.setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel9.setPreferredSize(new java.awt.Dimension(1500, 102));

        crtExp.setBackground(new java.awt.Color(51, 51, 51));
        crtExp.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        crtExp.setForeground(new java.awt.Color(255, 255, 255));
        crtExp.setText("Add Expense");
        crtExp.setBorderPainted(false);
        crtExp.setFocusable(false);
        crtExp.setPreferredSize(new java.awt.Dimension(200, 35));
        crtExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crtExpActionPerformed(evt);
            }
        });

        refreshExpTable.setBackground(new java.awt.Color(51, 51, 51));
        refreshExpTable.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        refreshExpTable.setForeground(new java.awt.Color(255, 255, 255));
        refreshExpTable.setText("Refresh");
        refreshExpTable.setBorder(null);
        refreshExpTable.setFocusable(false);
        refreshExpTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshExpTableActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(301, 301, 301)
                .addComponent(refreshExpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(crtExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(crtExp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshExpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane4.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 14)); // NOI18N

        jTable4.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Expense Id", "Event Name", "Title", "Description", "Amount", "Date", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable4.setPreferredSize(new java.awt.Dimension(375, 200));
        jTable4.setRowHeight(40);
        jTable4.setShowGrid(false);
        jTable4.setShowHorizontalLines(true);
        jTable4.getTableHeader().setResizingAllowed(false);
        jTable4.getTableHeader().setReorderingAllowed(false);
        jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable4MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable4);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 425, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ExpensePanelLayout = new javax.swing.GroupLayout(ExpensePanel);
        ExpensePanel.setLayout(ExpensePanelLayout);
        ExpensePanelLayout.setHorizontalGroup(
            ExpensePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 1524, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ExpensePanelLayout.setVerticalGroup(
            ExpensePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ExpensePanelLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab2", ExpensePanel);

        ReportPanel.setPreferredSize(new java.awt.Dimension(1500, 800));

        jPanel11.setPreferredSize(new java.awt.Dimension(1500, 102));

        genReport.setBackground(new java.awt.Color(51, 51, 51));
        genReport.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        genReport.setForeground(new java.awt.Color(255, 255, 255));
        genReport.setText("Generate Report");
        genReport.setBorderPainted(false);
        genReport.setFocusable(false);
        genReport.setPreferredSize(new java.awt.Dimension(200, 35));
        genReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(genReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(genReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jScrollPane5.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 14)); // NOI18N

        jTable5.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12)); // NOI18N
        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Report Id", "Event Name", "Revenue", "Expenses", "Profit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable5.setRowHeight(40);
        jTable5.setShowGrid(false);
        jTable5.setShowHorizontalLines(true);
        jTable5.getTableHeader().setResizingAllowed(false);
        jTable5.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(384, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 425, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ReportPanelLayout = new javax.swing.GroupLayout(ReportPanel);
        ReportPanel.setLayout(ReportPanelLayout);
        ReportPanelLayout.setHorizontalGroup(
            ReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 1524, Short.MAX_VALUE)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ReportPanelLayout.setVerticalGroup(
            ReportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReportPanelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab2", ReportPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1266, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(sidePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1287, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 167, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void atdBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atdBtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(1);
    }//GEN-LAST:event_atdBtnActionPerformed

    private void revBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_revBtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(2);
    }//GEN-LAST:event_revBtnActionPerformed

    private void expBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expBtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(3);
    }//GEN-LAST:event_expBtnActionPerformed

    private void crtEvtBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crtEvtBtnActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createEvt().setVisible(true);
            }
        });
    }//GEN-LAST:event_crtEvtBtnActionPerformed

    private void crtAtdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crtAtdActionPerformed
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createAtd().setVisible(true);
            }
        });
    }//GEN-LAST:event_crtAtdActionPerformed

    private void crtExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crtExpActionPerformed

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createExp().setVisible(true);
            }
        });        // TODO add your handling code here:
    }//GEN-LAST:event_crtExpActionPerformed

    private void genReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genReportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genReportActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:

        int index = jTable1.getSelectedRow();
        TableModel model = jTable1.getModel();
        String id = model.getValueAt(index, 0).toString();
        String eventName = model.getValueAt(index, 1).toString();
        String desc = model.getValueAt(index, 2).toString();
        String date = model.getValueAt(index, 3).toString();
        String duration = model.getValueAt(index, 4).toString();
        String price = model.getValueAt(index, 5).toString();
        String vName = model.getValueAt(index, 6).toString();
        String type = model.getValueAt(index, 7).toString();
        String eventSpeaker = model.getValueAt(index, 8).toString();
//        String vLocation = model.getValueAt(index, 6).toString();

        eventRow.setVisible(true);
        eventRow.pack();
        eventRow.setLocationRelativeTo(null);

        eventRow.eventId = id;
        eventRow.V_eventName.setText(eventName);
        eventRow.V_descriptionEvent.setText(desc);
        eventRow.V_eventDate.setText(date);
        eventRow.V_eventDays.setText(duration);
        eventRow.V_eventVenue.setText(vName);
        //eventRow.V_eventLocation.setText(vLocation);
        eventRow.V_eventPrice.setText(price);

        //System.out.println(type);
        if (type.equals("workshop")) {

            eventRow.workshop.setSelected(true);

            eventRow.seminarPanel.setVisible(false);
            eventRow.workshopPanel.setVisible(true);
            eventRow.conferencePanel.setVisible(false);
            eventRow.inst.setText(eventSpeaker);

        } else if (type.equals("seminar")) {
            eventRow.seminar.setSelected(true);

            eventRow.seminarPanel.setVisible(true);
            eventRow.workshopPanel.setVisible(false);
            eventRow.conferencePanel.setVisible(false);
            eventRow.speaker.setText(eventSpeaker);
        } else if (type.equals("Conference")) {
            eventRow.conference.setSelected(true);

            eventRow.seminarPanel.setVisible(false);
            eventRow.workshopPanel.setVisible(false);
            eventRow.conferencePanel.setVisible(true);
            eventRow.speakerConf.setText(eventSpeaker);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void refreshAtdTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshAtdTableActionPerformed
        // TODO add your handling code here:
        fetchAtdTable();
    }//GEN-LAST:event_refreshAtdTableActionPerformed

    private void refreshEvtTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshEvtTableActionPerformed
        // TODO add your handling code here:
        fetchEventTable();
    }//GEN-LAST:event_refreshEvtTableActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:

        int index = jTable2.getSelectedRow();
        TableModel model = jTable2.getModel();
        String id = model.getValueAt(index, 0).toString();
        String Name = model.getValueAt(index, 1).toString();
        String details = model.getValueAt(index, 2).toString();
        String date = model.getValueAt(index, 3).toString();
        String event = model.getValueAt(index, 4).toString();
        String status = model.getValueAt(index, 5).toString();

        atdRow.setVisible(true);
        atdRow.pack();
        atdRow.setLocationRelativeTo(null);

        atdRow.atdId = id;
        atdRow.fName.setText(Name);
        atdRow.cntDtl.setText(details);
        atdRow.dob.setText(date);
        atdRow.sts.setText(status);
        atdRow.eName.setSelectedItem(event);

        //System.out.println(type);

    }//GEN-LAST:event_jTable2MouseClicked

    private void refreshAtdTable1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshAtdTable1ActionPerformed
        // TODO add your handling code here:
        fetchRevTable();
    }//GEN-LAST:event_refreshAtdTable1ActionPerformed

    private void refreshExpTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshExpTableActionPerformed
        // TODO add your handling code here:
        fetchExpTable();
    }//GEN-LAST:event_refreshExpTableActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable4MouseClicked
        // TODO add your handling code here:

        int index = jTable4.getSelectedRow();
        TableModel model = jTable4.getModel();
        String id = model.getValueAt(index, 0).toString();
        String exp_eventName = model.getValueAt(index, 1).toString();
        String expTitle = model.getValueAt(index, 2).toString();
        String desc = model.getValueAt(index, 3).toString();
        String exp_amount = model.getValueAt(index, 4).toString();
        String exp_date = model.getValueAt(index, 5).toString();
        String sts = model.getValueAt(index, 6).toString();

        expRow.setVisible(true);
        expRow.pack();
        expRow.setLocationRelativeTo(null);

        expRow.id = id;
        expRow.title.setText(expTitle);
        expRow.eventName.setSelectedItem(exp_eventName);
         
        expRow.date.setText(exp_date);
        expRow.description.setText(desc);
        expRow.amount.setText(exp_amount);
        
        if (sts.equals("Paid")) {

            expRow.paidRadioBtn.setSelected(true);

        } else if (sts.equals("Pending")) {
            expRow.pendingRadioBtn.setSelected(true);

        } else if (sts.equals("Failed")) {
            expRow.failedRadioBtn.setSelected(true);

        }
    }//GEN-LAST:event_jTable4MouseClicked

    private void eventBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eventBtnActionPerformed
        // TODO add your handling code here:
        jTabbedPane2.setSelectedIndex(0);
    }//GEN-LAST:event_eventBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ExpensePanel;
    private javax.swing.JPanel ReportPanel;
    private javax.swing.JPanel RevenuePanel;
    private javax.swing.JButton atdBtn;
    private javax.swing.JPanel attendeePanel;
    private javax.swing.JButton crtAtd;
    private javax.swing.JButton crtEvtBtn;
    private javax.swing.JButton crtExp;
    private javax.swing.JButton eventBtn;
    private javax.swing.JPanel eventPanel;
    private javax.swing.JButton expBtn;
    private javax.swing.JButton genReport;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane2;
    public javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JButton refreshAtdTable;
    private javax.swing.JButton refreshAtdTable1;
    private javax.swing.JButton refreshEvtTable;
    private javax.swing.JButton refreshExpTable;
    private javax.swing.JButton revBtn;
    private javax.swing.JPanel sidePanel;
    // End of variables declaration//GEN-END:variables

}
