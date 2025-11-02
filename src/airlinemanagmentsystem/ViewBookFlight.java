<<<<<<< HEAD

package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewBookFlight extends JFrame{
    
    public ViewBookFlight(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table=new JTable();
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select*from Tickit");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,0,1000,900);
        add(jsp);
        
        setSize(1000,900);
        setLocation(300,150);
        setVisible(true);
        
        
        
        
    }
    public static void main(String args[]){
        new ViewBookFlight();
    }
    
}


=======

package airlinemanagmentsystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewBookFlight extends JFrame{
    
    public ViewBookFlight(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table=new JTable();
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select*from Tickit");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,0,1000,900);
        add(jsp);
        
        setSize(1000,900);
        setLocation(300,150);
        setVisible(true);
        
        
        
        
    }
    public static void main(String args[]){
        new ViewBookFlight();
    }
    
}


>>>>>>> e9ec22e (initial commit - added full java swing project)
