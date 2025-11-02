

package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;
public class JourneyDetails  extends JFrame implements ActionListener
{
    Choice source, destination;
    JButton search, back;
    
    public JourneyDetails(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Journey Details");
        heading.setBounds(180, 20, 250, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 100, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
         add(lblsource);
        
        source = new Choice();
        source.setBounds(220, 100, 150, 25);       
        add(source);
        
        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 150, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220, 150, 150, 25);       
        add(destination);
        
        search= new JButton("Search");
        search.setBounds(60, 250, 100, 25);
        search.setBackground(Color.PINK);
        search.setForeground(Color.BLUE);
        search.addActionListener(this);
        add(search);
          
        back= new JButton("Back");
        back.setBounds(220, 250, 100, 25);
        back.setBackground(Color.PINK);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/journey.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(390,40,570,470);
        add(image);
        
        setSize(1000, 1000);
        setLocation(350, 150);
        setVisible(true);
        
         try {
            Conn c = new Conn();
            String query = "select * from AddFlight";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                source.add(rs.getString("source"));
                destination.add(rs.getString("destination"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
     public void actionPerformed(ActionEvent ae) 
     {
        if (ae.getSource() == search) 
          {
              String Source  = source.getSelectedItem();
            String Destination = destination.getSelectedItem();
                JTable table1 = new JTable();
                try 
                {
                   Conn conn = new Conn();
                    
                 
                   ResultSet rs = conn.s.executeQuery("select * from Tickit where Source = '"+Source+"' and Destination = '"+Destination+"'");
                   table1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e) 
                {
                       e.printStackTrace();
                 }
                JScrollPane jsp = new JScrollPane(table1);
                jsp.setBounds(0, 300, 1000, 300);
                add(jsp);
             
        } 
     
       else if (ae.getSource() == back)
        {
            
            setVisible(false);
          
        }
        
    }
            
    public static void main(String args[])
    {
        new JourneyDetails();
        
    }

   
}
    


    

