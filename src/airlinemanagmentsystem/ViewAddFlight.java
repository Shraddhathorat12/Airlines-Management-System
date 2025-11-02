
package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewAddFlight extends JFrame{
    
    public ViewAddFlight(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JTable table=new JTable();
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("Select * from AddFlight; ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,0,900,700);
        add(jsp);
        
        setSize(900,700);
        setLocation(300,150);
        setVisible(true);
        
        
        
        
    }
    public static void main(String args[]){
        new ViewAddFlight();
    }
    
}



    

