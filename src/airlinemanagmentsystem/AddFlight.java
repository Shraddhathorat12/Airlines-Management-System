<<<<<<< HEAD

package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddFlight extends JFrame implements ActionListener{
    JTextField  tfcode,tfsource,tfdesti,tfclass1,tfprice,tffliname,tfcapasity;
   JButton AddFlight ,back;
   
   
    
    public AddFlight(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel(" Add Flight");
        heading.setFont(new Font("Taboma",Font.ITALIC,32));
        heading.setBounds(220,20,500,35);
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel flightcod=new JLabel("Flight Code");
         flightcod.setFont(new Font("Taboma",Font.BOLD,16));
         flightcod.setBounds(80,90,150,25);
         flightcod.setForeground(Color.BLACK);
        add( flightcod);
        
        tfcode=new JTextField();
        tfcode.setBounds(190,90,150,25);
        add(tfcode);
        
        
        JLabel Flight_Name=new JLabel("Flight Name");
        Flight_Name.setFont(new Font("Taboma",Font.BOLD,16));
        Flight_Name.setBounds(80,140,150,25);
        Flight_Name.setForeground(Color.BLACK);
        add(Flight_Name);
        
        tffliname=new JTextField();
        tffliname.setBounds(190,140,150,25);
        add(tffliname);
        
        JLabel Source=new JLabel("Source");
        Source.setFont(new Font("Taboma",Font.BOLD,16));
        Source.setBounds(80,190,150,25);
        Source.setForeground(Color.BLACK);
        add(Source);
        
        tfsource=new JTextField();
        tfsource.setBounds(190,190,150,25);
        add(tfsource);
        
        JLabel Destination=new JLabel("Destination");
        Destination.setFont(new Font("Taboma",Font.BOLD,16));
        Destination.setBounds(80,240,150,25);
        Destination.setForeground(Color.BLACK);
        add(Destination);
        
         tfdesti=new JTextField();
        tfdesti.setBounds(190,240,150,25);
        add(tfdesti);
        
        
        
         JLabel capasity=new JLabel("Capacity");
        capasity.setFont(new Font("Taboma",Font.BOLD,16));
        capasity.setBounds(80,290,150,25);
        capasity.setForeground(Color.BLACK);
        add(capasity);
        
        tfcapasity=new JTextField();
        tfcapasity.setBounds(190,290,150,25);
        add(tfcapasity);
        
        
        JLabel Class=new JLabel("Class");
        Class.setFont(new Font("Taboma",Font.BOLD,16));
        Class.setBounds(80,340,150,25);
        Class.setForeground(Color.BLACK);
         add(Class);
        
         
        tfclass1=new JTextField();
        tfclass1.setBounds(190,340,150,25);
        add(tfclass1);
        
        
          
         JLabel Price=new JLabel("Price");
        Price.setFont(new Font("Taboma",Font.BOLD,16));
        Price.setBounds(80,390,150,25);
        Price.setForeground(Color.BLACK);
        add(Price);
        
         tfprice=new JTextField();
        tfprice.setBounds(190,390,150,25);
        add(tfprice);
        
        AddFlight=new JButton("AddFlight");
        AddFlight.setBackground(Color.BLACK);
        AddFlight.setForeground(Color.WHITE);
        AddFlight.setBounds(70,460,150,25);
        AddFlight.addActionListener(this);
        add(AddFlight);
        
        back=new JButton("Back");
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setBounds(330,460,150,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/air8.jpg"));
        JLabel lbimage=new JLabel(image);
        lbimage.setBounds(400,80,550,400);
        add(lbimage);
        
        setSize(1000,700);
        setLocation(200,50);
        setVisible(true);
        
}
  
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==AddFlight){

        String FlightCode=tfcode.getText();
        String Flight_Name=tffliname.getText();
        String Source=tfsource.getText();
        String Destination=tfdesti.getText();
        String Capacity=tfcapasity.getText();
        String Class=tfclass1.getText();
        String Price=tfprice.getText();
       
        
        try{
            
            Conn conn=new Conn();
            String query="insert into AddFlight values('"+FlightCode+"','"+Flight_Name+"','"+Source+"','"+Destination+"','"+Capacity+"','"+Class+"','"+Price+"')";
            conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Tickit Book  Successfully");
             setVisible(false);
            
            
           }catch(Exception e){
            e.printStackTrace();
           }
    }
    
    else if(ae.getSource()==back){
        setVisible(false);
    }
    
    }

    public static void main(String[] args){
        new AddFlight();
    }

    
}
    

=======

package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class AddFlight extends JFrame implements ActionListener{
    JTextField  tfcode,tfsource,tfdesti,tfclass1,tfprice,tffliname,tfcapasity;
   JButton AddFlight ,back;
   
   
    
    public AddFlight(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel(" Add Flight");
        heading.setFont(new Font("Taboma",Font.ITALIC,32));
        heading.setBounds(220,20,500,35);
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel flightcod=new JLabel("Flight Code");
         flightcod.setFont(new Font("Taboma",Font.BOLD,16));
         flightcod.setBounds(80,90,150,25);
         flightcod.setForeground(Color.BLACK);
        add( flightcod);
        
        tfcode=new JTextField();
        tfcode.setBounds(190,90,150,25);
        add(tfcode);
        
        
        JLabel Flight_Name=new JLabel("Flight Name");
        Flight_Name.setFont(new Font("Taboma",Font.BOLD,16));
        Flight_Name.setBounds(80,140,150,25);
        Flight_Name.setForeground(Color.BLACK);
        add(Flight_Name);
        
        tffliname=new JTextField();
        tffliname.setBounds(190,140,150,25);
        add(tffliname);
        
        JLabel Source=new JLabel("Source");
        Source.setFont(new Font("Taboma",Font.BOLD,16));
        Source.setBounds(80,190,150,25);
        Source.setForeground(Color.BLACK);
        add(Source);
        
        tfsource=new JTextField();
        tfsource.setBounds(190,190,150,25);
        add(tfsource);
        
        JLabel Destination=new JLabel("Destination");
        Destination.setFont(new Font("Taboma",Font.BOLD,16));
        Destination.setBounds(80,240,150,25);
        Destination.setForeground(Color.BLACK);
        add(Destination);
        
         tfdesti=new JTextField();
        tfdesti.setBounds(190,240,150,25);
        add(tfdesti);
        
        
        
         JLabel capasity=new JLabel("Capacity");
        capasity.setFont(new Font("Taboma",Font.BOLD,16));
        capasity.setBounds(80,290,150,25);
        capasity.setForeground(Color.BLACK);
        add(capasity);
        
        tfcapasity=new JTextField();
        tfcapasity.setBounds(190,290,150,25);
        add(tfcapasity);
        
        
        JLabel Class=new JLabel("Class");
        Class.setFont(new Font("Taboma",Font.BOLD,16));
        Class.setBounds(80,340,150,25);
        Class.setForeground(Color.BLACK);
         add(Class);
        
         
        tfclass1=new JTextField();
        tfclass1.setBounds(190,340,150,25);
        add(tfclass1);
        
        
          
         JLabel Price=new JLabel("Price");
        Price.setFont(new Font("Taboma",Font.BOLD,16));
        Price.setBounds(80,390,150,25);
        Price.setForeground(Color.BLACK);
        add(Price);
        
         tfprice=new JTextField();
        tfprice.setBounds(190,390,150,25);
        add(tfprice);
        
        AddFlight=new JButton("AddFlight");
        AddFlight.setBackground(Color.BLACK);
        AddFlight.setForeground(Color.WHITE);
        AddFlight.setBounds(70,460,150,25);
        AddFlight.addActionListener(this);
        add(AddFlight);
        
        back=new JButton("Back");
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setBounds(330,460,150,25);
        back.addActionListener(this);
        add(back);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/air8.jpg"));
        JLabel lbimage=new JLabel(image);
        lbimage.setBounds(400,80,550,400);
        add(lbimage);
        
        setSize(1000,700);
        setLocation(200,50);
        setVisible(true);
        
}
  
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==AddFlight){

        String FlightCode=tfcode.getText();
        String Flight_Name=tffliname.getText();
        String Source=tfsource.getText();
        String Destination=tfdesti.getText();
        String Capacity=tfcapasity.getText();
        String Class=tfclass1.getText();
        String Price=tfprice.getText();
       
        
        try{
            
            Conn conn=new Conn();
            String query="insert into AddFlight values('"+FlightCode+"','"+Flight_Name+"','"+Source+"','"+Destination+"','"+Capacity+"','"+Class+"','"+Price+"')";
            conn.s.executeUpdate(query);
           JOptionPane.showMessageDialog(null,"Tickit Book  Successfully");
             setVisible(false);
            
            
           }catch(Exception e){
            e.printStackTrace();
           }
    }
    
    else if(ae.getSource()==back){
        setVisible(false);
    }
    
    }

    public static void main(String[] args){
        new AddFlight();
    }

    
}
    

>>>>>>> e9ec22e (initial commit - added full java swing project)
