
package airlinemanagmentsystem;
  
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class Home  extends JFrame implements ActionListener
{
     private List<ImageIcon> images;
    private int currentIndex;
    private JPanel imagePanel;  // Panel for background carousel
    private JPanel bottomImagePanel;  // Panel for bottom scrolling images
    private int xOffset = 0;  // Offset to control the scrolling of bottom images
    
    public Home()
    {
        JFrame F=new JFrame();
        images = new ArrayList<>();
        currentIndex = 0;
        
        // Load images for background carousel (ensure correct paths)
        images.add(new ImageIcon(getClass().getClassLoader().getResource("airlinemanagmentsystem/icon/23.jpg")));
        images.add(new ImageIcon(getClass().getClassLoader().getResource("airlinemanagmentsystem/icon/imageair.jpg")));
        images.add(new ImageIcon(getClass().getClassLoader().getResource("airlinemanagmentsystem/icon/image10.jpg")));
        images.add(new ImageIcon(getClass().getClassLoader().getResource("airlinemanagmentsystem/icon/image4.jpg")));
        //images.add(new ImageIcon(getClass().getClassLoader().getResource("airlinemanagmentsystem/icon/air8.jpg")));
        //images.add(new ImageIcon(getClass().getClassLoader().getResource("airlinemanagmentsystem/icon/reg3.jpg")));
        //images.add(new ImageIcon(getClass().getClassLoader().getResource("airlinemanagmentsystem/icon/23.jpg")));
        //images.add(new ImageIcon(getClass().getClassLoader().getResource("airlinemanagmentsystem/icon/bengaluru-international-airport-in-bangalore-B7WJD6.jpg")));
        
        // Set up the JFrame
        setLayout(null);
        
        // Set up the background image carousel panel
        imagePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (!images.isEmpty()) {
                    g.drawImage(images.get(currentIndex).getImage(), 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        imagePanel.setBounds(0, 0, 1800, 1080); // Full window size
        add(imagePanel); // Add it to the JFrame
        
        setLayout(null);
        /*ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/image8.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1800,1080);
        add(image);*/
        JLabel heading=new JLabel("Welcome To Airline");
        heading.setBounds(400,100,1000,90);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.CENTER_BASELINE,80));
        imagePanel.add(heading);
        
        addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // Center the heading label
                int x = (getWidth() - heading.getPreferredSize().width) / 2;
                int y = 150;  // Fixed y position (can be adjusted as needed)
                heading.setBounds(x, y, heading.getPreferredSize().width, heading.getPreferredSize().height);
            }
        });
        
        
        
        
        
        
        JMenuBar menubar=new JMenuBar();
        setJMenuBar(menubar);
        menubar.setBackground(Color.PINK);
        JMenu details=new JMenu("Passanger Profile");
        menubar.add(details);
        JMenuItem Addpass=new JMenuItem("Add Passanger Profile");
        Addpass.addActionListener(this);
        details.add(Addpass);
        Addpass.setForeground(Color.BLUE);// Set text color for "Add Passanger Profile"
        details.setForeground(Color.BLACK);

        
        JMenuItem view=new JMenuItem("View Passanger Profile");
        view.addActionListener(this);
        details.add(view);
        view.setForeground(Color.BLUE);
        
        JMenu ManagePassanger=new JMenu("Manage Passanger");
        menubar.add(ManagePassanger);
        JMenuItem Update=new JMenuItem("Update Passanger Details");
        Update.addActionListener(this);
        ManagePassanger.add(Update);
        Update.setForeground(Color.BLUE);
        
        
        
        JMenu YourFlight=new JMenu("Your Flight");
        menubar.add(YourFlight);
        JMenuItem flight=new JMenuItem("Add Flight");
        flight.addActionListener(this);
        YourFlight.add(flight);
        flight.setForeground(Color.BLUE);
        
        JMenuItem viewflight=new JMenuItem("View Added Flight");
        viewflight.addActionListener(this);
        YourFlight.add(viewflight);
        viewflight.setForeground(Color.BLUE);
        
        
        JMenu tickit=new JMenu("Tickit");
        menubar.add(tickit);
        JMenuItem tickit1=new JMenuItem("Book Tickit");
        tickit1.addActionListener(this);
        tickit.add(tickit1);
        tickit1.setForeground(Color.BLUE);
        
        JMenuItem viewtickit=new JMenuItem("View  Book Flight");
        viewtickit.addActionListener(this);
        tickit.add(viewtickit);
        viewtickit.setForeground(Color.BLUE);
        
        
        
        
        
        JMenu FlightDetails=new JMenu("Flight Details");
        menubar.add(FlightDetails);
        JMenuItem Journy=new JMenuItem("Journey Details");
        Journy.addActionListener(this);
        FlightDetails.add(Journy);
        Journy.setForeground(Color.BLUE);
        
        JMenuItem zone=new JMenuItem("Flight Zone");
        zone.addActionListener(this);
        FlightDetails.add(zone);
        zone.setForeground(Color.BLUE);
        
        JMenu Cancel=new JMenu("Cancellation");
        menubar.add(Cancel);
        JMenuItem cancelticket=new JMenuItem("Cancel Ticket");
        cancelticket.addActionListener(this);
        Cancel.add(cancelticket);
        cancelticket.setForeground(Color.BLUE);
        JMenuItem viewcanceled=new JMenuItem("View Canceled Ticket");
        viewcanceled.addActionListener(this);
        Cancel.add(viewcanceled);
        viewcanceled.setForeground(Color.BLUE);
        
        JMenu bill=new JMenu("Bill");
        menubar.add(bill);
        JMenuItem check=new JMenuItem("Payment");
        check.addActionListener(this);
        bill.add(check);
        check.setForeground(Color.BLUE);
        JMenuItem check1=new JMenuItem("check Payment");
        check1.addActionListener(this);
        bill.add(check1);
        check1.setForeground(Color.BLUE);
        
        
        JMenu bord=new JMenu("Air India Boarding Pass");
        menubar.add(bord);
        JMenuItem bord1=new JMenuItem("Bording Pass");
        bord1.addActionListener(this);
        bord.add(bord1);
        bord1.setForeground(Color.BLUE);
        
        JMenu Logout=new JMenu("Logout");
        menubar.add(Logout);
        Logout.setForeground(Color.RED);
        JMenuItem logout1=new JMenuItem("Logout");
        logout1.addActionListener(new ActionListener(){
             @Override
            public void actionPerformed(ActionEvent ae) {
              int confirmed=JOptionPane.showConfirmDialog(F,"Are You Want to Logout?","Logout",JOptionPane.YES_NO_OPTION);
                if(confirmed==JOptionPane.YES_NO_OPTION)
                {
                    System.exit(0);
                }  

            }
       });
        Logout.add(logout1);
       
        
   
        
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change to the next image in background carousel
                currentIndex = (currentIndex + 1) % images.size();
                imagePanel.repaint();  // Repaint the panel to show the next image
            }
        });
        timer.start();  
        
       setExtendedState(JFrame.MAXIMIZED_BOTH);
      
        setVisible(true);  
    }
    
    public void actionPerformed(ActionEvent e)
    {
      String text=e.getActionCommand();
      if(text.equals("Add Passanger Profile")){
          new AddPassanger1();
          
      }else if(text.equals("View Passanger Profile")){
          new viewpassanger();
      }
      else if(text.equals("Update Passanger Details")){
           new Updatepass ();
    }
    else if(text.equals("Add Flight")){
        new AddFlight();
    }
      else if(text.equals("View Added Flight")){
        new ViewAddFlight();
      }
      
      else if(text.equals("Book Tickit")){
        new BookFlight();
      }
      
       else if(text.equals("View  Book Flight")){
        new ViewBookFlight();
      }
       else if(text.equals("Journey Details")){
            new JourneyDetails();
       }
      else if(text.equals("Flight Zone")){
            new FlightZone();
       }
      
      else if(text.equals("Cancel Ticket")){
              new canceltickit();
       }
       
      else if(text.equals("View Canceled Ticket")){
              new  viewcancel();
       }
     else if(text.equals("Payment")){
              new payment();
       }
     else if(text.equals("check Payment")){
              new checkpayment();
       }
      
      else if(text.equals("Bording Pass")){
              new boarding();
       }
       
    }    
    
    public static void main(String[] args)
    {
         new Home();
         
    }
}
   



