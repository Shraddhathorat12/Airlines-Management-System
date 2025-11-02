<<<<<<< HEAD

package airlinemanagmentsystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    PreparedStatement stmt = null;
    
    public Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///airlinemanagmentsystem","root","123456");
            s=c.createStatement();
        }
         catch(Exception e){
             e.printStackTrace();
             
         }   
            
    }        

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
=======

package airlinemanagmentsystem;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    PreparedStatement stmt = null;
    
    public Conn()
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///airlinemanagmentsystem","root","123456");
            s=c.createStatement();
        }
         catch(Exception e){
             e.printStackTrace();
             
         }   
            
    }        

    PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
>>>>>>> e9ec22e (initial commit - added full java swing project)
