

package airlinemanagmentsystem;
import  javax.swing.*;
import  java.awt.*;
import  java.sql.*;
import  java.awt.event.*;
import java.util.*;
import  net.proteanit.sql.DbUtils;
public class FlightZone extends JFrame implements ActionListener
{
  
   
    JButton show;
    Choice Fcode;
    public FlightZone() 
    {
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
         JLabel heading = new JLabel("Air India Flight Information");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
      
       
       
        JLabel lblfcode = new JLabel("Flightcode");
        lblfcode.setBounds(60, 100, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
         add(lblfcode);
        
        Fcode = new Choice();
        Fcode.setBounds(220, 100, 120, 25);       
        add(Fcode);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(400, 100, 120, 25);
        show.addActionListener(this);
        add(show);
        
       //ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/ar4.png"));
       
       ImageIcon image = new ImageIcon(getClass().getResource("/airlinemanagmentsystem/icon/jou1.jpg"));
        if (image.getImageLoadStatus() == MediaTracker.ERRORED) {
             System.out.println("Image not found!");
              image = new ImageIcon();  // You can set a default or fallback image here
             }
         JLabel lbimage = new JLabel(image);
       lbimage.setBounds(100, 60, 570, 600);
        add(lbimage);

        setSize(800, 600);
        setLocation(400, 150);
        setVisible(true);
        
        
         try {
            Conn c = new Conn();
            String query = "select * from AddFlight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                Fcode.add(rs.getString("Flightcode"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    
    }
    
    public void actionPerformed(ActionEvent ae) 
    {
        if (ae.getSource() == show) 
          {
              String fcode1  = Fcode.getSelectedItem();
            
               JTable table1 = new JTable();
                
        try {
             Conn conn = new Conn();
             ResultSet rs = conn.s.executeQuery("select * from AddFlight where Flightcode = '"+fcode1+"' ");
             table1.setModel(DbUtils.resultSetToTableModel(rs));
            } 
         catch(Exception e)
         {
            e.printStackTrace();
         }
         JScrollPane jsp = new JScrollPane(table1);
         jsp.setBounds(0, 300, 500, 300);
         add(jsp);
        }
    }

    public static void main(String[] args) {
        new FlightZone();
    }
} 


    

