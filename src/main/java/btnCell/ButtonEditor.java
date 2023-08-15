/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btnCell;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public class ButtonEditor extends DefaultCellEditor {

    public JPanel panel;
    public JButton updateBtn;
    public JButton delBtn;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);

        panel = new JPanel();

        updateBtn = new JButton();
        delBtn = new JButton();
//        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        updateBtn = new JButton("Edit");
        delBtn = new JButton("Delete");

//        updateBtn = new JButton();
//        delBtn = new JButton();
//        try {
//            ImageIcon updateIcon = new ImageIcon(ImageIO.read(getClass().getResource("edit.png")));
//            ImageIcon deleteIcon = new ImageIcon(ImageIO.read(getClass().getResource("delete.png")));
//            updateBtn.setIcon(updateIcon);
//            delBtn.setIcon(deleteIcon);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        updateBtn.setOpaque(false);
        delBtn.setOpaque(false);
        updateBtn.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12));
        delBtn.setFont(new java.awt.Font("HelveticaNowMicro Medium", 0, 12));

        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                // Implement your update or delete logic here based on the button clicked
//                int selectedRow = table.getEditingRow();
//                    if (selectedRow != -1) {
//                        // Implement your update logic for the selected row here
//                        System.out.println("Update clicked for row: " + selectedRow);
//                    }
                System.out.println("test");
            }
        });

        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                // Implement your update or delete logic here based on the button clicked
            }
        });
        panel.add(updateBtn);
        panel.add(delBtn);
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {

        return panel;
    }
}
