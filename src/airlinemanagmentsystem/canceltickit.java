

package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;

public class canceltickit extends JFrame implements ActionListener{
    
   JTextField tfsource,tfdest,tfclass,tfprice,tffname,tffcode,tfjdate,tfjtime,tfuname,tfname;
    
    JButton  cancel,Back,show,showcancel;
    Choice tikitid;
    public canceltickit() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("Cancel your Flight Ticket");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
         heading.setForeground(Color.red);
        add(heading);
        
        
        
        JLabel lbltikit = new JLabel("Ticket id");
        lbltikit.setBounds(60, 80, 150, 25);
        lbltikit.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbltikit);
        
         
        tikitid = new Choice();
        tikitid.setBounds(220, 80, 150, 25);       
        add(tikitid);
        
        show= new JButton("Show");
        show.setBackground(Color.red);
        show.setForeground(Color.WHITE);
        show.setBounds(400, 80, 120, 25);
        show.addActionListener(this);
        add(show);
        
      
        
         
        JLabel lblsource = new JLabel("Source");
        lblsource.setBounds(60, 130, 150, 25);
        lblsource.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblsource);
        
         tfsource = new JTextField();
        tfsource.setBounds(220, 130, 150, 25);
        add(tfsource);
        
          JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(60, 180, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbldest);
        
         tfdest = new JTextField();
        tfdest.setBounds(220, 180, 150, 25);
        add(tfdest);
        
          JLabel lblclass = new JLabel("Class");
        lblclass.setBounds(60, 230, 150, 25);
        lblclass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblclass);
        
         tfclass = new JTextField();
        tfclass.setBounds(220, 230, 150, 25);
        add(tfclass);
        
          JLabel lblprice = new JLabel("Price");
        lblprice.setBounds(60, 280, 150, 25);
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblprice);
        
         tfprice = new JTextField();
        tfprice.setBounds(220, 280, 150, 25);
        add(tfprice);
        
        
       
        
          JLabel lblfcode = new JLabel("Flight Code");
        lblfcode.setBounds(60, 330, 150, 25);
        lblfcode.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfcode);
        
         tffcode = new JTextField();
        tffcode.setBounds(220, 330, 150, 25);
        add(tffcode);
        
      
        
         JLabel lblfname = new JLabel("Flight Name");
        lblfname.setBounds(60, 380, 150, 25);
        lblfname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblfname);
        
         tffname = new JTextField();
        tffname.setBounds(220, 380, 150, 25);
        add(tffname);
        
        
          JLabel lbljdate= new JLabel("Journey Date");
        lbljdate.setBounds(60, 430, 150, 25);
        lbljdate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbljdate);
        
         tfjdate = new JTextField();
        tfjdate.setBounds(220, 430, 150, 25);
        add(tfjdate);
        
      
        
         JLabel lbljtime = new JLabel("Journey Time");
        lbljtime.setBounds(60, 480, 150, 25);
        lbljtime.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbljtime);
        
         tfjtime = new JTextField();
        tfjtime.setBounds(220, 480, 150, 25);
        add(tfjtime);
        
        JLabel lbluname= new JLabel("Username");
        lbluname.setBounds(60, 530, 150, 25);
        lbluname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lbluname);
        
         tfuname = new JTextField();
        tfuname.setBounds(220, 530, 150, 25);
        add(tfuname);
        
        JLabel lblname= new JLabel("Name");
        lblname.setBounds(60, 580, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
         tfname = new JTextField();
        tfname.setBounds(220, 580, 150, 25);
        add(tfname);
        
         
  
        
        
        cancel= new JButton("Cancel Flight");
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(60, 680, 120, 25);
        cancel.addActionListener(this);
        add(cancel);
        
        Back= new JButton("Back");
        Back.setBackground(Color.black);
        Back.setForeground(Color.WHITE);
        Back.setBounds(220, 680, 120, 25);
        Back.addActionListener(this);
        add(Back);
        
         /*showcancel= new JButton("show cancel Tickit ");
        showcancel.setBounds(400, 680, 150, 25);
        showcancel.setBackground(Color.PINK);
        showcancel.setForeground(Color.BLUE);
        showcancel.addActionListener(this);
        add(showcancel);*/
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/reg3.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(450,100,500,410);
        add(image);
        
        
        setSize(1000, 1400);
        setLocation(300, 70);
        setVisible(true);
        
         try {
            Conn c = new Conn();
            String query = "select * from Tickit";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                tikitid.add(rs.getString("Tickitid"));
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
         
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == show) {
            String Tickitid =  tikitid.getSelectedItem();
                
            try {
                Conn conn = new Conn();

                String query = "select * from Tickit where Tickitid= '"+Tickitid+"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) {
                    tfsource.setText(rs.getString("Source")); 
                    tfdest.setText(rs.getString("Destination")); 
                    tfclass.setText(rs.getString("Class"));
                    tfprice.setText(rs.getString("Price"));
                    tffcode.setText(rs.getString("Flight_code")); 
                    tffname.setText(rs.getString("Flight_name"));  
                    tfjdate.setText(rs.getString("Journeydate"));
                    tfjtime.setText(rs.getString("Journeytime"));
                    tfuname.setText(rs.getString("Username")); 
                    tfname.setText(rs.getString("Name")); 
                   
                   
                } else {
                    JOptionPane.showMessageDialog(null, "Please select correct Tikitid");                
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            String Tickitid=  tikitid.getSelectedItem();
            String Source=tfsource.getText();
            String Destination=tfdest.getText();
            String Class=tfclass.getText();
            String Price=tfprice.getText();
             String Flight_code=tffcode.getText();
            String Flight_name=tffname.getText();
            String Journeydate=tfjdate.getText();
            String Journeytime=tfjtime.getText();
            String Username=tfuname.getText();
            String Name=tfname.getText();
           
            
            try {
                Conn conn = new Conn();

                String query ="insert into Tickit values('"+Tickitid+"','"+Source+"','"+Destination+"','"+Class+"','"+Price+"','"+Flight_code+"','"+Flight_name+"','"+Journeydate+"','"+Journeytime+"','"+Username+"','"+Name+"')";
                conn.s.executeUpdate(query);
                conn.s.executeUpdate("delete from Tickit where Tickitid = '"+Tickitid+"'");
                
                JOptionPane.showMessageDialog(null, "Ticket Cancelled");
                setVisible(false);
            
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
        /*else if (ae.getSource() == showcancel) 
          {
                JTable table1 = new JTable();
                try 
                {
                   Conn conn = new Conn();
                   ResultSet rs = conn.s.executeQuery("select * from Tickit");
                   table1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e) 
                {
                       e.printStackTrace();
                 }
                JScrollPane jsp = new JScrollPane(table1);
                jsp.setBounds(550, 100, 800, 500);
                add(jsp);
            } */
        else if (ae.getSource() == Back)
        {
            
            setVisible(false);
          
        }
    }
        
   

    public static void main(String[] args) {
        new canceltickit();
    }
} 

    

