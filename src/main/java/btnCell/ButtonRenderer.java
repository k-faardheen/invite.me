/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btnCell;

import java.awt.Component;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Admin
 */
public class ButtonRenderer extends JPanel implements TableCellRenderer {

    public JButton updateButton;
    public JButton deleteButton;

    public ButtonRenderer() {
        setOpaque(true);
//            setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2)); // Adjust spacing as needed
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        updateButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
//        updateButton = new JButton();
//        deleteButton = new JButton();
//        try {
//            ImageIcon updateIcon = new ImageIcon(ImageIO.read(getClass().getResource("edit.png")));
//            ImageIcon deleteIcon = new ImageIcon(ImageIO.read(getClass().getResource("delete.png")));
//      updateButton.setIcon(updateIcon);
//        deleteButton.setIcon(deleteIcon);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        add(updateButton);
        add(deleteButton);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return this;
    }
}
