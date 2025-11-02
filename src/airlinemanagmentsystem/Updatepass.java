<<<<<<< HEAD


package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;
public class Updatepass  extends JFrame implements ActionListener
{
    
    JTextField  tfage, tfbirth, tfname ,tfadd,tfphone,tfemail,tfnationality,tfgender,tfpassport;
    JButton fetchButton,update,show,back;
    Choice tfuser;
    public Updatepass () 
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Passanger Details");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
      
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 80, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);
        
        tfuser = new Choice();
        tfuser.setBounds(220, 80, 150, 25);
        add(tfuser);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 180, 150, 25);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(220, 180, 150, 25);
        add(tfage);
        
        JLabel lblbirth = new JLabel("Date of Birth");
        lblbirth.setBounds(60, 230, 150, 25);
        lblbirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblbirth);
        
        tfbirth = new JTextField();
        tfbirth.setBounds(220, 230, 150, 25);
        add(tfbirth);
        
        JLabel lblAdd = new JLabel("Address");
        lblAdd.setBounds(60, 280, 150, 25);
        lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAdd);
        
        tfadd = new JTextField();
        tfadd.setBounds(220, 280, 150, 25);
        add(tfadd);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
         JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 380, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 380, 150, 25);
        add(tfnationality);
        
         JLabel lblpass = new JLabel("Passport");
        lblpass.setBounds(60, 430, 150, 25);
        lblpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpass);
        
        tfpassport = new JTextField();
        tfpassport.setBounds(220, 430, 150, 25);
        add(tfpassport);
        
        
         JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 480, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220, 480, 150, 25);
        add(tfgender);
        
       
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 530, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 530, 150, 25);
        add(tfemail);
        
       
        
        
       
        update= new JButton("Update passanger");
        update.setBounds(10, 580, 170, 25);
        update.setBackground(Color.PINK);
        update.setForeground(Color.BLUE);
        update.addActionListener(this);
        add(update);
          
        show= new JButton("show passenger");
        show.setBounds(220, 580, 150, 25);
        show.setBackground(Color.PINK);
        show.setForeground(Color.BLUE);
        show.addActionListener(this);
        add(show);
        
        back= new JButton("Back");
        back.setBounds(100, 630, 150, 25);
        back.setBackground(Color.PINK);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        add(back);
          
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/reg3.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(450,100,500,410);
        add(image);
        
        setSize(1000,1400);
        setLocation(300,70);
        setVisible(true);
        
        try {
            Conn c = new Conn();
            String query = "select * from passanger";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                tfuser.add(rs.getString("username"));
                
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void actionPerformed(ActionEvent ae) 
     {
        if (ae.getSource() == fetchButton) {
            String username  = tfuser.getSelectedItem();
            
            try {
                Conn conn = new Conn();

                String query = "select * from Passanger  where username  = '"+username +"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) 
                {
                    tfname.setText(rs.getString("name")); 
                    tfage.setText(rs.getString("age")); 
                    tfbirth.setText(rs.getString("birthdate"));
                    tfadd.setText(rs.getString("address")); 
                    tfphone.setText(rs.getString("phone")); 
                    tfnationality. setText(rs.getString("nationality"));
                    tfpassport.setText(rs.getString("passportno")); 
                    tfgender.setText(rs.getString("gender")); 
                    tfemail.setText(rs.getString("emailid"));
                    
            } 
            else 
            {
               JOptionPane.showMessageDialog(null, "Please enter correct usename");                
            }
         } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }else if (ae.getSource() == update)
        {
            String username = tfuser.getSelectedItem();  
            String name = tfname.getText();
            String age = tfage.getText();
            String birthdate = tfbirth.getText();
            String address = tfadd.getText();
            String phone = tfphone.getText();
            String nationality = tfnationality.getText();
            String passportno = tfpassport.getText();
            String gender = tfgender.getText();
            String emailid = tfemail.getText();
            
           
            
            try 
            {
                Conn conn = new Conn();
                String query = "insert into passanger values('"+username+"','"+name+"', '"+age+"', '"+birthdate+"', '"+address+"', '"+phone+"','"+nationality+"', '"+passportno+"', '"+gender+"','"+emailid+"' )";
                 
                conn.s.executeUpdate(query);
                String query1 = "UPDATE passanger SET name = '"+name+"', age = '"+age+"', birthdate = '"+birthdate+"', address = '"+address+"', phone = '"+phone+"', nationality = '"+nationality+"', passportno = '"+passportno+"', gender = '"+gender+"', emailid = '"+emailid+"' WHERE username = '"+username+"'";
                 conn.s.executeUpdate(query1);

                /*conn.s.executeUpdate("update passanger set name='"+name+"',age='"+age+"',birthdate='"+birthdate+"',address=`'"+address+"',phone='"+phone+"',nationality='"+nationality+"',passportno='"+passportno+"',gender='"+gender+"',emailid='"+emailid+"'     where username = '"+username+"'");*/
                
                JOptionPane.showMessageDialog(null, "updated successfully");
               
                setVisible(false);
            
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
          }
         else if (ae.getSource() == show) 
          {
                String username = tfuser.getSelectedItem();  
                JTable table1 = new JTable();
                try 
                {
                   Conn conn = new Conn();
                   ResultSet rs = conn.s.executeQuery("select * from passanger  where username = '"+username+"'");
                   table1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e) 
                {
                       e.printStackTrace();
                 }
                JScrollPane jsp = new JScrollPane(table1);
                jsp.setBounds(0, 0, 900, 600);
                add(jsp);
            } 
        else if (ae.getSource() == back)
        {
            
            setVisible(false);
          
        }
    }
 public static void main(String[] args)
    {
        new Updatepass ();
    }
} 

  
    

=======


package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;
public class Updatepass  extends JFrame implements ActionListener
{
    
    JTextField  tfage, tfbirth, tfname ,tfadd,tfphone,tfemail,tfnationality,tfgender,tfpassport;
    JButton fetchButton,update,show,back;
    Choice tfuser;
    public Updatepass () 
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Passanger Details");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);
      
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 80, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);
        
        tfuser = new Choice();
        tfuser.setBounds(220, 80, 150, 25);
        add(tfuser);
        
        fetchButton = new JButton("Show Details");
        fetchButton.setBackground(Color.BLACK);
        fetchButton.setForeground(Color.WHITE);
        fetchButton.setBounds(380, 80, 120, 25);
        fetchButton.addActionListener(this);
        add(fetchButton);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 130, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220, 130, 150, 25);
        add(tfname);
        
        JLabel lblage = new JLabel("Age");
        lblage.setBounds(60, 180, 150, 25);
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblage);
        
        tfage = new JTextField();
        tfage.setBounds(220, 180, 150, 25);
        add(tfage);
        
        JLabel lblbirth = new JLabel("Date of Birth");
        lblbirth.setBounds(60, 230, 150, 25);
        lblbirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblbirth);
        
        tfbirth = new JTextField();
        tfbirth.setBounds(220, 230, 150, 25);
        add(tfbirth);
        
        JLabel lblAdd = new JLabel("Address");
        lblAdd.setBounds(60, 280, 150, 25);
        lblAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblAdd);
        
        tfadd = new JTextField();
        tfadd.setBounds(220, 280, 150, 25);
        add(tfadd);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(60, 330, 150, 25);
        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220, 330, 150, 25);
        add(tfphone);
        
         JLabel lblnationality = new JLabel("Nationality");
        lblnationality.setBounds(60, 380, 150, 25);
        lblnationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220, 380, 150, 25);
        add(tfnationality);
        
         JLabel lblpass = new JLabel("Passport");
        lblpass.setBounds(60, 430, 150, 25);
        lblpass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblpass);
        
        tfpassport = new JTextField();
        tfpassport.setBounds(220, 430, 150, 25);
        add(tfpassport);
        
        
         JLabel lblgender = new JLabel("Gender");
        lblgender.setBounds(60, 480, 150, 25);
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblgender);
        
        tfgender = new JTextField();
        tfgender.setBounds(220, 480, 150, 25);
        add(tfgender);
        
       
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(60, 530, 150, 25);
        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(220, 530, 150, 25);
        add(tfemail);
        
       
        
        
       
        update= new JButton("Update passanger");
        update.setBounds(10, 580, 170, 25);
        update.setBackground(Color.PINK);
        update.setForeground(Color.BLUE);
        update.addActionListener(this);
        add(update);
          
        show= new JButton("show passenger");
        show.setBounds(220, 580, 150, 25);
        show.setBackground(Color.PINK);
        show.setForeground(Color.BLUE);
        show.addActionListener(this);
        add(show);
        
        back= new JButton("Back");
        back.setBounds(100, 630, 150, 25);
        back.setBackground(Color.PINK);
        back.setForeground(Color.BLUE);
        back.addActionListener(this);
        add(back);
          
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/reg3.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(450,100,500,410);
        add(image);
        
        setSize(1000,1400);
        setLocation(300,70);
        setVisible(true);
        
        try {
            Conn c = new Conn();
            String query = "select * from passanger";
            ResultSet rs = c.s.executeQuery(query);
            
            while(rs.next()) {
                tfuser.add(rs.getString("username"));
                
            }
            } catch (Exception e) {
            e.printStackTrace();
        }
    }
     public void actionPerformed(ActionEvent ae) 
     {
        if (ae.getSource() == fetchButton) {
            String username  = tfuser.getSelectedItem();
            
            try {
                Conn conn = new Conn();

                String query = "select * from Passanger  where username  = '"+username +"'";

                ResultSet rs = conn.s.executeQuery(query);
                
                if (rs.next()) 
                {
                    tfname.setText(rs.getString("name")); 
                    tfage.setText(rs.getString("age")); 
                    tfbirth.setText(rs.getString("birthdate"));
                    tfadd.setText(rs.getString("address")); 
                    tfphone.setText(rs.getString("phone")); 
                    tfnationality. setText(rs.getString("nationality"));
                    tfpassport.setText(rs.getString("passportno")); 
                    tfgender.setText(rs.getString("gender")); 
                    tfemail.setText(rs.getString("emailid"));
                    
            } 
            else 
            {
               JOptionPane.showMessageDialog(null, "Please enter correct usename");                
            }
         } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
        }else if (ae.getSource() == update)
        {
            String username = tfuser.getSelectedItem();  
            String name = tfname.getText();
            String age = tfage.getText();
            String birthdate = tfbirth.getText();
            String address = tfadd.getText();
            String phone = tfphone.getText();
            String nationality = tfnationality.getText();
            String passportno = tfpassport.getText();
            String gender = tfgender.getText();
            String emailid = tfemail.getText();
            
           
            
            try 
            {
                Conn conn = new Conn();
                String query = "insert into passanger values('"+username+"','"+name+"', '"+age+"', '"+birthdate+"', '"+address+"', '"+phone+"','"+nationality+"', '"+passportno+"', '"+gender+"','"+emailid+"' )";
                 
                conn.s.executeUpdate(query);
                String query1 = "UPDATE passanger SET name = '"+name+"', age = '"+age+"', birthdate = '"+birthdate+"', address = '"+address+"', phone = '"+phone+"', nationality = '"+nationality+"', passportno = '"+passportno+"', gender = '"+gender+"', emailid = '"+emailid+"' WHERE username = '"+username+"'";
                 conn.s.executeUpdate(query1);

                /*conn.s.executeUpdate("update passanger set name='"+name+"',age='"+age+"',birthdate='"+birthdate+"',address=`'"+address+"',phone='"+phone+"',nationality='"+nationality+"',passportno='"+passportno+"',gender='"+gender+"',emailid='"+emailid+"'     where username = '"+username+"'");*/
                
                JOptionPane.showMessageDialog(null, "updated successfully");
               
                setVisible(false);
            
            } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            
          }
         else if (ae.getSource() == show) 
          {
                String username = tfuser.getSelectedItem();  
                JTable table1 = new JTable();
                try 
                {
                   Conn conn = new Conn();
                   ResultSet rs = conn.s.executeQuery("select * from passanger  where username = '"+username+"'");
                   table1.setModel(DbUtils.resultSetToTableModel(rs));
                }
                catch(Exception e) 
                {
                       e.printStackTrace();
                 }
                JScrollPane jsp = new JScrollPane(table1);
                jsp.setBounds(0, 0, 900, 600);
                add(jsp);
            } 
        else if (ae.getSource() == back)
        {
            
            setVisible(false);
          
        }
    }
 public static void main(String[] args)
    {
        new Updatepass ();
    }
} 

  
    

>>>>>>> e9ec22e (initial commit - added full java swing project)
