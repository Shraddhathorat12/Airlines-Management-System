
package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login  extends JFrame implements ActionListener
{
    JButton submit,reset,close;
    JTextField tfusername;
    JPasswordField tfpassword;
    public Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel lblusername =new JLabel("Username");
        lblusername.setBounds(20,20,100,20);
        lblusername.setFont(new Font("serif",Font.BOLD,20));
        add(lblusername);
        
        tfusername=new JTextField();
        tfusername.setBounds(130,20,200,20);
        add(tfusername);
        
        JLabel lblPassword= new JLabel("Password");
        lblPassword.setBounds(20,60,100,20);
        lblPassword.setFont(new Font("serif",Font.BOLD,20));
        add(lblPassword);
        
        tfpassword=new JPasswordField();
        tfpassword.setBounds(130,60,200,20);
        add(tfpassword);
        
        reset=new JButton("Reset");
        reset.setBounds(40,120,120,20);
        reset.setFont(new Font("serif",Font.BOLD,17));
        reset.addActionListener(this);
        reset.setBackground(Color.PINK);
        add(reset);
        reset.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        submit=new JButton("Submit");
        submit.setBounds(200,120,120,20);
        submit.setFont(new Font("serif",Font.BOLD,17));
        submit.addActionListener(this);
        submit.setBackground(Color.PINK);
        add(submit);
        submit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        close=new JButton("Close");
        close.setBounds(120,160,120,20);
        close.setFont(new Font("serif",Font.BOLD,17));
        close.addActionListener(this);
        close.setBackground(Color.PINK);
        add(close);
        close.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/emg1.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,500,340);
        add(image);
 
        setSize(500,350);
        setLocation(600,250);
         setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent e)
    {
      if(e.getSource()==submit)
      {
         String username=tfusername.getText();
         String password=tfpassword.getText();
         try{
             Conn c=new Conn();
             String query="select * from login where username='"+username+"'and password='"+password+"'";
             ResultSet rs=c.s.executeQuery(query);
             if(rs.next()){
                 new Home();
                 setVisible(false);
                 
             }else{
                 JOptionPane.showMessageDialog(null,"Invalid Username Or Password");
                 setVisible(false);
             }
             
         }
         catch(Exception ea)
         {
             ea.printStackTrace();
         }
         
      }
      else if(e.getSource()==close){
          setVisible(false);
          
      }else if(e.getSource()==reset){
          tfusername.setText("");
          tfpassword.setText(" ");
          
      }
    }
    
    public static void main(String[] args)
    {
         new Login();
         
    }

   
}
