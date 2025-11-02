
package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class viewpassanger extends JFrame{
    
    public viewpassanger(){
        
        getContentPane().setBackground(Color.BLACK);
        setLayout(null);
        
        JTable table=new JTable();
        
        try{
            Conn conn=new Conn();
            ResultSet rs=conn.s.executeQuery("select*from Passanger ");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
            }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp=new JScrollPane(table);
        jsp.setBounds(0,0,900,700);
        add(jsp);
        
        /*ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/bc1.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,900,700);
        add(image);*/
        
        
        
        setSize(900,700);
        setLocation(300,150);
        setVisible(true);
         
        
        
        
    }
    public static void main(String args[]){
        new viewpassanger();
    }
    
}
