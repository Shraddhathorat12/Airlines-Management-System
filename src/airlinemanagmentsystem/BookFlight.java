<<<<<<< HEAD

package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;

public class BookFlight extends JFrame implements ActionListener{
    JTextField tfid,tfprice,tfFlightcod,tfjtime,tfname;
   JButton book ,back;
   JDateChooser tfjdate;
   Choice class1,source,destination,tfusername1,flightname;
  private  JLabel Price,Class;
    //int[] Price1={1200,2400,1700};
   
   
    
    public BookFlight(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel(" Tickit Book ");
        heading.setFont(new Font("Taboma",Font.ITALIC,35));
        heading.setBounds(220,20,500,35);
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel Tickitid=new JLabel("Tickit Id");
        Tickitid.setFont(new Font("Taboma",Font.BOLD,16));
        Tickitid.setBounds(80,90,150,25);
        Tickitid.setForeground(Color.BLACK);
        add(Tickitid);
        
        tfid=new JTextField();
        tfid.setBounds(230,90,220,25);
        add(tfid);
        
        JLabel Source=new JLabel("Source");
        Source.setFont(new Font("Taboma",Font.BOLD,16));
        Source.setBounds(80,140,150,25);
        Source.setForeground(Color.BLACK);
        add(Source);
        
        source=new Choice();
        source.setBounds(230,140,220,25);
        add(source);
        
         /*tfsource=new JTextField();
        tfsource.setBounds(170,140,150,25);
        add(tfsource);*/
        
        JLabel Destination=new JLabel("Destination");
        Destination.setFont(new Font("Taboma",Font.BOLD,16));
        Destination.setBounds(80,190,150,25);
        Destination.setForeground(Color.BLACK);
        add(Destination);
        
         destination=new Choice();
        destination.setBounds(230,190,220,25);
        add(destination);
        
        
       /* tfdesti=new JTextField();
        tfdesti.setBounds(170,190,150,25);
        add(tfdesti);*/
        
        
         Class=new JLabel("Class");
        Class.setFont(new Font("Taboma",Font.BOLD,16));
        Class.setBounds(80,240,150,25);
        Class.setForeground(Color.BLACK);
       // Class.addMouseListener(new ClassListener());
        //Class.addItemListener(new ClassListener());

    
        add(Class);
        
         class1=new Choice();
        class1.setBounds(230,240,220,25);
        //Class.addMouseListener(new ClassListener());
        class1.addItemListener(new ClassListener());
        add(class1);
        
         /*tfclass1=new JTextField();
        tfclass1.setBounds(170,240,150,25);
        add(tfclass1);*/
        
        
          
         Price=new JLabel("Price");
        Price.setFont(new Font("Taboma",Font.BOLD,16));
        Price.setBounds(80,290,150,25);
        Price.setForeground(Color.BLACK);
        add(Price);
        
         tfprice=new JTextField();
        tfprice.setBounds(230,290,220,25);
        add(tfprice);
        
        
         
        JLabel Flight_Name=new JLabel("Flight Name");
        Flight_Name.setFont(new Font("Taboma",Font.BOLD,16));
        Flight_Name.setBounds(80,340,150,25);
        Flight_Name.setForeground(Color.BLACK);
        add(Flight_Name);
        
        
        
        flightname=new Choice();
        flightname.setBounds(230,340,220,25);
        //Class.addMouseListener(new ClassListener());
        flightname.addItemListener(new ClassListener());
        add(flightname);
        
       /* tffliname=new JTextField();
        tffliname.setBounds(190,340,150,25);
        add(tffliname);*/
        
        
        
        JLabel Flight_code=new JLabel("Flight Code");
        Flight_code.setFont(new Font("Taboma",Font.BOLD,16));
        Flight_code.setBounds(80,390,150,25);
        Flight_code.setForeground(Color.BLACK);
        add(Flight_code);
        
         tfFlightcod=new JTextField();
        tfFlightcod.setBounds(230,390,220,25);
        add(tfFlightcod);
        
        
         JLabel Journeydate=new JLabel("Journey Date");
        Journeydate.setFont(new Font("Taboma",Font.BOLD,16));
        Journeydate.setBounds(80,440,150,25);
        Journeydate.setForeground(Color.BLACK);
        add(Journeydate);
        
        tfjdate=new JDateChooser();
        tfjdate.setBounds(230,440,220,25);
        tfjdate.setDateFormatString("dd-MM-yyyy");
        add(tfjdate);
        
        
         JLabel Journeytime=new JLabel("Journey Time");
        Journeytime.setFont(new Font("Taboma",Font.BOLD,16));
        Journeytime.setBounds(80,490,150,25);
        Journeytime.setForeground(Color.BLACK);
        add(Journeytime);
        
        tfjtime=new JTextField();
        tfjtime.setBounds(230,490,220,25);
        add(tfjtime);
        
        JLabel Username=new JLabel("Username");
        Username.setFont(new Font("Taboma",Font.BOLD,16));
        Username.setBounds(80,540,150,25);
        Username.setForeground(Color.BLACK);
        
        add(Username);
        
        
        tfusername1=new Choice();
        tfusername1.setBounds(230,540,220,25);
        //Class.addMouseListener(new ClassListener());
        tfusername1.addItemListener(new ClassListener());
        add(tfusername1);
        
        /*tfusername1=new JTextField();
        tfusername1.setBounds(190,540,150,25);
        add(tfusername1);*/
        
        JLabel Name=new JLabel("Name");
       Name.setFont(new Font("Taboma",Font.BOLD,16));
        Name.setBounds(80,590,150,25);
        Name.setForeground(Color.BLACK);
        add(Name);
        
        tfname=new JTextField();
        tfname.setBounds(230,590,220,25);
        add(tfname);
        
        try{
            Conn c=new Conn();
            String query="select * from AddFlight";
            
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("Source"));
                destination.add(rs.getString("Destination"));
                class1.add(rs.getString("Class"));
                flightname.add(rs.getString("Flight_Name"));
            }
        } 
        catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        
        
        
        
        try{
            Conn c2=new Conn(); 
            String query2="select * from  Passanger ";
            ResultSet rs1=c2.s.executeQuery(query2);
            
            while(rs1.next()){
                 tfusername1.add(rs1.getString("Username"));
            }
        }
            catch(Exception ea){
            ea.printStackTrace();
        }
        book=new JButton("Book");
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.setBounds(70,690,200,35);
        book.addActionListener(this);
        add(book);
        
        back=new JButton("Back");
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setBounds(400,690,200,35);
        back.addActionListener(this);
        add(back);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/ticket1.jpg"));
        JLabel lbimage=new JLabel(image);
        lbimage.setBounds(490,30,450,700);
        add(lbimage);
        
        setSize(1000,800);
        setLocation(200,50);
        setVisible(true);
        
}
    private class ClassListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            String enteredclass=class1.getSelectedItem();
            String enterflname=flightname.getSelectedItem();
            String rsclass=tfusername1.getSelectedItem();
            try{
                   Conn conn1=new Conn();
                   String query="select Price From AddFlight Where Class='"+enteredclass+"'";
                   ResultSet rs=conn1.s.executeQuery(query);
                   while(rs.next()){
                       tfprice.setText(rs.getString(1));
                   }
                    
              }
            

            catch(Exception ae){
                ae.printStackTrace();
            }
            try{
                Conn c5=new Conn();
                String query2="select name From Passanger  Where username='"+rsclass+"'";
                   ResultSet rs1=c5.s.executeQuery(query2);
                   while(rs1.next()){
                      tfname.setText(rs1.getString(1));
                  }
                }
                   catch(Exception ea){
                           ea.printStackTrace();
                           }
            
            
            
            try{
                   Conn c7=new Conn();
                   String query9="select FlightCode From AddFlight Where Flight_Name='"+enterflname+"'";
                   ResultSet rs2=c7.s.executeQuery(query9);
                   while(rs2.next()){
                      tfFlightcod.setText(rs2.getString(1));
                   }
                    
              }
            

            catch(Exception ae){
                ae.printStackTrace();
            }
            
            
        }
              
        
        
        
}
    public void actionPerformed(ActionEvent ae) {
        
      
        if(ae.getSource()==book){

        String Tickitid=tfid.getText();
        String Source=source.getSelectedItem();
        String Destination=destination.getSelectedItem();
        String Class=class1.getSelectedItem();
        String Price=tfprice.getText();
        String Flight_code=tfFlightcod.getText();
        String Flight_Name=flightname.getSelectedItem();
        String Journeydate=((JTextField)tfjdate.getDateEditor().getUiComponent()).getText();
        String Journeytime=tfjtime.getText();
        String Username=tfusername1.getSelectedItem();
        String Name=tfname.getText();
        
        try{
            
            Conn conn=new Conn();
            String query="insert into Tickit values('"+Tickitid+"','"+Source+"','"+Destination+"','"+Class+"','"+Price+"','"+Flight_code+"','"+Flight_Name+"','"+Journeydate+"','"+Journeytime+"','"+Username+"','"+Name+"')";
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
        new BookFlight();
    }

    
}
   
    
=======

package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;

public class BookFlight extends JFrame implements ActionListener{
    JTextField tfid,tfprice,tfFlightcod,tfjtime,tfname;
   JButton book ,back;
   JDateChooser tfjdate;
   Choice class1,source,destination,tfusername1,flightname;
  private  JLabel Price,Class;
    //int[] Price1={1200,2400,1700};
   
   
    
    public BookFlight(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading=new JLabel(" Tickit Book ");
        heading.setFont(new Font("Taboma",Font.ITALIC,35));
        heading.setBounds(220,20,500,35);
        heading.setForeground(Color.BLUE);
        add(heading);
        
        JLabel Tickitid=new JLabel("Tickit Id");
        Tickitid.setFont(new Font("Taboma",Font.BOLD,16));
        Tickitid.setBounds(80,90,150,25);
        Tickitid.setForeground(Color.BLACK);
        add(Tickitid);
        
        tfid=new JTextField();
        tfid.setBounds(230,90,220,25);
        add(tfid);
        
        JLabel Source=new JLabel("Source");
        Source.setFont(new Font("Taboma",Font.BOLD,16));
        Source.setBounds(80,140,150,25);
        Source.setForeground(Color.BLACK);
        add(Source);
        
        source=new Choice();
        source.setBounds(230,140,220,25);
        add(source);
        
         /*tfsource=new JTextField();
        tfsource.setBounds(170,140,150,25);
        add(tfsource);*/
        
        JLabel Destination=new JLabel("Destination");
        Destination.setFont(new Font("Taboma",Font.BOLD,16));
        Destination.setBounds(80,190,150,25);
        Destination.setForeground(Color.BLACK);
        add(Destination);
        
         destination=new Choice();
        destination.setBounds(230,190,220,25);
        add(destination);
        
        
       /* tfdesti=new JTextField();
        tfdesti.setBounds(170,190,150,25);
        add(tfdesti);*/
        
        
         Class=new JLabel("Class");
        Class.setFont(new Font("Taboma",Font.BOLD,16));
        Class.setBounds(80,240,150,25);
        Class.setForeground(Color.BLACK);
       // Class.addMouseListener(new ClassListener());
        //Class.addItemListener(new ClassListener());

    
        add(Class);
        
         class1=new Choice();
        class1.setBounds(230,240,220,25);
        //Class.addMouseListener(new ClassListener());
        class1.addItemListener(new ClassListener());
        add(class1);
        
         /*tfclass1=new JTextField();
        tfclass1.setBounds(170,240,150,25);
        add(tfclass1);*/
        
        
          
         Price=new JLabel("Price");
        Price.setFont(new Font("Taboma",Font.BOLD,16));
        Price.setBounds(80,290,150,25);
        Price.setForeground(Color.BLACK);
        add(Price);
        
         tfprice=new JTextField();
        tfprice.setBounds(230,290,220,25);
        add(tfprice);
        
        
         
        JLabel Flight_Name=new JLabel("Flight Name");
        Flight_Name.setFont(new Font("Taboma",Font.BOLD,16));
        Flight_Name.setBounds(80,340,150,25);
        Flight_Name.setForeground(Color.BLACK);
        add(Flight_Name);
        
        
        
        flightname=new Choice();
        flightname.setBounds(230,340,220,25);
        //Class.addMouseListener(new ClassListener());
        flightname.addItemListener(new ClassListener());
        add(flightname);
        
       /* tffliname=new JTextField();
        tffliname.setBounds(190,340,150,25);
        add(tffliname);*/
        
        
        
        JLabel Flight_code=new JLabel("Flight Code");
        Flight_code.setFont(new Font("Taboma",Font.BOLD,16));
        Flight_code.setBounds(80,390,150,25);
        Flight_code.setForeground(Color.BLACK);
        add(Flight_code);
        
         tfFlightcod=new JTextField();
        tfFlightcod.setBounds(230,390,220,25);
        add(tfFlightcod);
        
        
         JLabel Journeydate=new JLabel("Journey Date");
        Journeydate.setFont(new Font("Taboma",Font.BOLD,16));
        Journeydate.setBounds(80,440,150,25);
        Journeydate.setForeground(Color.BLACK);
        add(Journeydate);
        
        tfjdate=new JDateChooser();
        tfjdate.setBounds(230,440,220,25);
        tfjdate.setDateFormatString("dd-MM-yyyy");
        add(tfjdate);
        
        
         JLabel Journeytime=new JLabel("Journey Time");
        Journeytime.setFont(new Font("Taboma",Font.BOLD,16));
        Journeytime.setBounds(80,490,150,25);
        Journeytime.setForeground(Color.BLACK);
        add(Journeytime);
        
        tfjtime=new JTextField();
        tfjtime.setBounds(230,490,220,25);
        add(tfjtime);
        
        JLabel Username=new JLabel("Username");
        Username.setFont(new Font("Taboma",Font.BOLD,16));
        Username.setBounds(80,540,150,25);
        Username.setForeground(Color.BLACK);
        
        add(Username);
        
        
        tfusername1=new Choice();
        tfusername1.setBounds(230,540,220,25);
        //Class.addMouseListener(new ClassListener());
        tfusername1.addItemListener(new ClassListener());
        add(tfusername1);
        
        /*tfusername1=new JTextField();
        tfusername1.setBounds(190,540,150,25);
        add(tfusername1);*/
        
        JLabel Name=new JLabel("Name");
       Name.setFont(new Font("Taboma",Font.BOLD,16));
        Name.setBounds(80,590,150,25);
        Name.setForeground(Color.BLACK);
        add(Name);
        
        tfname=new JTextField();
        tfname.setBounds(230,590,220,25);
        add(tfname);
        
        try{
            Conn c=new Conn();
            String query="select * from AddFlight";
            
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                source.add(rs.getString("Source"));
                destination.add(rs.getString("Destination"));
                class1.add(rs.getString("Class"));
                flightname.add(rs.getString("Flight_Name"));
            }
        } 
        catch(Exception e){
            e.printStackTrace();
            
        }
        
        
        
        
        
        
        try{
            Conn c2=new Conn(); 
            String query2="select * from  Passanger ";
            ResultSet rs1=c2.s.executeQuery(query2);
            
            while(rs1.next()){
                 tfusername1.add(rs1.getString("Username"));
            }
        }
            catch(Exception ea){
            ea.printStackTrace();
        }
        book=new JButton("Book");
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.setBounds(70,690,200,35);
        book.addActionListener(this);
        add(book);
        
        back=new JButton("Back");
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setBounds(400,690,200,35);
        back.addActionListener(this);
        add(back);
        
        ImageIcon image=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/ticket1.jpg"));
        JLabel lbimage=new JLabel(image);
        lbimage.setBounds(490,30,450,700);
        add(lbimage);
        
        setSize(1000,800);
        setLocation(200,50);
        setVisible(true);
        
}
    private class ClassListener implements ItemListener{
        @Override
        public void itemStateChanged(ItemEvent e){
            String enteredclass=class1.getSelectedItem();
            String enterflname=flightname.getSelectedItem();
            String rsclass=tfusername1.getSelectedItem();
            try{
                   Conn conn1=new Conn();
                   String query="select Price From AddFlight Where Class='"+enteredclass+"'";
                   ResultSet rs=conn1.s.executeQuery(query);
                   while(rs.next()){
                       tfprice.setText(rs.getString(1));
                   }
                    
              }
            

            catch(Exception ae){
                ae.printStackTrace();
            }
            try{
                Conn c5=new Conn();
                String query2="select name From Passanger  Where username='"+rsclass+"'";
                   ResultSet rs1=c5.s.executeQuery(query2);
                   while(rs1.next()){
                      tfname.setText(rs1.getString(1));
                  }
                }
                   catch(Exception ea){
                           ea.printStackTrace();
                           }
            
            
            
            try{
                   Conn c7=new Conn();
                   String query9="select FlightCode From AddFlight Where Flight_Name='"+enterflname+"'";
                   ResultSet rs2=c7.s.executeQuery(query9);
                   while(rs2.next()){
                      tfFlightcod.setText(rs2.getString(1));
                   }
                    
              }
            

            catch(Exception ae){
                ae.printStackTrace();
            }
            
            
        }
              
        
        
        
}
    public void actionPerformed(ActionEvent ae) {
        
      
        if(ae.getSource()==book){

        String Tickitid=tfid.getText();
        String Source=source.getSelectedItem();
        String Destination=destination.getSelectedItem();
        String Class=class1.getSelectedItem();
        String Price=tfprice.getText();
        String Flight_code=tfFlightcod.getText();
        String Flight_Name=flightname.getSelectedItem();
        String Journeydate=((JTextField)tfjdate.getDateEditor().getUiComponent()).getText();
        String Journeytime=tfjtime.getText();
        String Username=tfusername1.getSelectedItem();
        String Name=tfname.getText();
        
        try{
            
            Conn conn=new Conn();
            String query="insert into Tickit values('"+Tickitid+"','"+Source+"','"+Destination+"','"+Class+"','"+Price+"','"+Flight_code+"','"+Flight_Name+"','"+Journeydate+"','"+Journeytime+"','"+Username+"','"+Name+"')";
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
        new BookFlight();
    }

    
}
   
    
>>>>>>> e9ec22e (initial commit - added full java swing project)
