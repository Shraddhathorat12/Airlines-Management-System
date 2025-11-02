


/**
 *
 * @author lenovo
 */

package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class zone extends JFrame implements ActionListener {

    JButton show;
    Choice Fcode;

    public zone() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Heading Label
        JLabel heading = new JLabel("Air India Flight Information");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        // Flightcode Label
        JLabel lblfcode = new JLabel("Flightcode");
        lblfcode.setBounds(60, 100, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);

        // Flightcode Dropdown
        Fcode = new Choice();
        Fcode.setBounds(220, 100, 120, 25);
        add(Fcode);

        // Show Button
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(400, 100, 120, 25);
        show.addActionListener(this);
        add(show);

        // Load the image safely with fallback
        ImageIcon image = loadImage("/airlinemanagmentsystem/icon/ar4.png");
        JLabel lbimage = new JLabel(image);
        lbimage.setBounds(450, 100, 500, 410);
        add(lbimage);

        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);

        // Load flight codes from the database into the choice dropdown
        try {
            Conn c = new Conn();
            String query = "SELECT * FROM AddFlight";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                Fcode.add(rs.getString("Flightcode"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == show) {
            String fcode1 = Fcode.getSelectedItem();

            JTable table1 = new JTable();

            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery("SELECT * FROM AddFlight WHERE Flightcode = '" + fcode1 + "'");
                table1.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Add table to JScrollPane and then add to JFrame
            JScrollPane jsp = new JScrollPane(table1);
            jsp.setBounds(0, 300, 500, 300);
            add(jsp);
        }
    }

    // Method to load an image and return an ImageIcon
    private ImageIcon loadImage(String path) {
        // Try to load the image from the given path
        ImageIcon image = new ImageIcon(getClass().getResource(path));
        
        // Check if the image was loaded successfully
        if (image.getImage() == null) {
            System.out.println("Image not found at path: " + path);
            // Set a fallback image or default image
            image = new ImageIcon(getClass().getResource("/airlinemanagmentsystem/icon/default-image.png"));
        }
        return image;
    }

    public static void main(String[] args) {
        new zone();
    }
}




