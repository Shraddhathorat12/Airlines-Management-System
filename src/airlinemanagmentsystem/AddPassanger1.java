<<<<<<< HEAD


package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class AddPassanger1  extends JFrame implements ActionListener
{
    
    JTextField tfuser, tfage, tfname ,tfadd,tfphone,tfemail,tfnationality,tfpassport;
    JButton Save,back;
    JRadioButton rbfemale,rbmale;
    JDateChooser tfbirth;
    public AddPassanger1 () 
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome To Airline India");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
         JLabel lbluser = new JLabel("UserName");
        lbluser.setBounds(60, 130, 150, 25);
         lbluser.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add( lbluser);
        
        tfuser = new JTextField();
        tfuser.setBounds(220, 130, 160, 25);
        add(tfuser);
      
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(60, 180, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 180, 160, 25);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 230, 150, 25);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(220, 230, 160, 25);
        add(tfage);
        
        JLabel lblbirth = new JLabel("Date of Birth");
        lblbirth.setBounds(60, 280, 150, 25);
        lblbirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblbirth);
        
        tfbirth = new JDateChooser();
        tfbirth.setBounds(220, 280, 160, 25);
        tfbirth.setDateFormatString("dd-MM-yyyy"); 
        add(tfbirth);
        
        JLabel lblAdd = new JLabel("Address");
        lblAdd.setBounds(60, 330, 150, 25);
        lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAdd);
        
        tfadd = new JTextField();
        tfadd.setBounds(220, 330, 160, 25);
        add(tfadd);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 380, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 380, 160, 25);
        add(tfphone);
        
         JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 430, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 430, 160, 25);
        add(tfnationality);
        
         JLabel lblpass = new JLabel("Passport");
        lblpass.setBounds(60, 480, 150, 25);
        lblpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpass);
        
        tfpassport = new JTextField();
        tfpassport.setBounds(220, 480, 160, 25);
        add(tfpassport);
        
        
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Taboma",Font.BOLD,16));
        gender.setBounds(60,530,150,25);
        gender.setForeground(Color.red);
        add(gender);
        ButtonGroup gendergroup=new ButtonGroup();
        
         rbmale=new JRadioButton("Male");
        rbmale.setBounds(220,530,70,25);
        rbmale.setForeground(Color.BLACK);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
         rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(310,530,70,25);
        rbfemale.setForeground(Color.BLACK);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
       
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 580, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 580, 160, 25);
        add(tfemail);
        
       
        
        
       
        Save= new JButton("Save");
        Save.setBounds(10, 630, 170, 25);
        Save.setBackground(Color.PINK);
        Save.setForeground(Color.BLUE);
        Save.addActionListener(this);
        add(Save);
          
        
        
        
        back= new JButton("Back");
        back.setBounds(200, 630, 170, 25);
        back.setBackground(Color.PINK);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        add(back);
          
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/reg4.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(450,150,380,500);
        add(image);
 
        setSize(1000,1400);
        setLocation(300,70);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) 
     {
        if(ae.getSource()==Save){

        String username=tfuser.getText();
        String name=tfname.getText();
        String age=tfage.getText();
        String birthdate=((JTextField)tfbirth.getDateEditor().getUiComponent()).getText();
        String address=tfadd.getText();
         String phone=tfphone.getText();
         String nationality=tfnationality.getText();
         String passportno=tfpassport.getText();
         String gender=null;
         String emailid= tfemail.getText();
       
        
        if(rbmale.isSelected()){
            gender="Male";
        }else{
            gender="Female";
        }
        
        try{
            
            Conn conn=new Conn();
            String query="insert into passanger values('"+username+"','"+name+"', '"+age+"', '"+birthdate+"', '"+address+"', '"+phone+"','"+nationality+"', '"+passportno+"', '"+gender+"','"+emailid+"' )";
             conn.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null,"Passanger Details Added Successfully");
             setVisible(false);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    else if(ae.getSource()==back){
        setVisible(false);
    }
    }

 public static void main(String[] args)
    {
        new AddPassanger1();
    }
} 

  
    


    
    
    

=======


package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class AddPassanger1  extends JFrame implements ActionListener
{
    
    JTextField tfuser, tfage, tfname ,tfadd,tfphone,tfemail,tfnationality,tfpassport;
    JButton Save,back;
    JRadioButton rbfemale,rbmale;
    JDateChooser tfbirth;
    public AddPassanger1 () 
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome To Airline India");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
        
         JLabel lbluser = new JLabel("UserName");
        lbluser.setBounds(60, 130, 150, 25);
         lbluser.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add( lbluser);
        
        tfuser = new JTextField();
        tfuser.setBounds(220, 130, 160, 25);
        add(tfuser);
      
        JLabel lblname = new JLabel("Customer Name");
        lblname.setBounds(60, 180, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 180, 160, 25);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 230, 150, 25);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(220, 230, 160, 25);
        add(tfage);
        
        JLabel lblbirth = new JLabel("Date of Birth");
        lblbirth.setBounds(60, 280, 150, 25);
        lblbirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblbirth);
        
        tfbirth = new JDateChooser();
        tfbirth.setBounds(220, 280, 160, 25);
        tfbirth.setDateFormatString("dd-MM-yyyy"); 
        add(tfbirth);
        
        JLabel lblAdd = new JLabel("Address");
        lblAdd.setBounds(60, 330, 150, 25);
        lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAdd);
        
        tfadd = new JTextField();
        tfadd.setBounds(220, 330, 160, 25);
        add(tfadd);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 380, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 380, 160, 25);
        add(tfphone);
        
         JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 430, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 430, 160, 25);
        add(tfnationality);
        
         JLabel lblpass = new JLabel("Passport");
        lblpass.setBounds(60, 480, 150, 25);
        lblpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpass);
        
        tfpassport = new JTextField();
        tfpassport.setBounds(220, 480, 160, 25);
        add(tfpassport);
        
        
        
        JLabel gender=new JLabel("Gender");
        gender.setFont(new Font("Taboma",Font.BOLD,16));
        gender.setBounds(60,530,150,25);
        gender.setForeground(Color.red);
        add(gender);
        ButtonGroup gendergroup=new ButtonGroup();
        
         rbmale=new JRadioButton("Male");
        rbmale.setBounds(220,530,70,25);
        rbmale.setForeground(Color.BLACK);
        rbmale.setBackground(Color.WHITE);
        add(rbmale);
         rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(310,530,70,25);
        rbfemale.setForeground(Color.BLACK);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);
        
        gendergroup.add(rbmale);
        gendergroup.add(rbfemale);
        
       
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 580, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 580, 160, 25);
        add(tfemail);
        
       
        
        
       
        Save= new JButton("Save");
        Save.setBounds(10, 630, 170, 25);
        Save.setBackground(Color.PINK);
        Save.setForeground(Color.BLUE);
        Save.addActionListener(this);
        add(Save);
          
        
        
        
        back= new JButton("Back");
        back.setBounds(200, 630, 170, 25);
        back.setBackground(Color.PINK);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        add(back);
          
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/reg4.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(450,150,380,500);
        add(image);
 
        setSize(1000,1400);
        setLocation(300,70);
        setVisible(true);
    }
     public void actionPerformed(ActionEvent ae) 
     {
        if(ae.getSource()==Save){

        String username=tfuser.getText();
        String name=tfname.getText();
        String age=tfage.getText();
        String birthdate=((JTextField)tfbirth.getDateEditor().getUiComponent()).getText();
        String address=tfadd.getText();
         String phone=tfphone.getText();
         String nationality=tfnationality.getText();
         String passportno=tfpassport.getText();
         String gender=null;
         String emailid= tfemail.getText();
       
        
        if(rbmale.isSelected()){
            gender="Male";
        }else{
            gender="Female";
        }
        
        try{
            
            Conn conn=new Conn();
            String query="insert into passanger values('"+username+"','"+name+"', '"+age+"', '"+birthdate+"', '"+address+"', '"+phone+"','"+nationality+"', '"+passportno+"', '"+gender+"','"+emailid+"' )";
             conn.s.executeUpdate(query);
             
             JOptionPane.showMessageDialog(null,"Passanger Details Added Successfully");
             setVisible(false);
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    else if(ae.getSource()==back){
        setVisible(false);
    }
    }

 public static void main(String[] args)
    {
        new AddPassanger1();
    }
} 

  
    


    
    
    

>>>>>>> e9ec22e (initial commit - added full java swing project)
