<<<<<<< HEAD

package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


  
public class payment extends JFrame implements ActionListener {
    JTextField tfamount, tfid, tfname;
    JComboBox<String> paymentMethodCombo;
    Choice uname;
    JButton submit,back;

    public payment() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("PAYMENT DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 80, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        uname = new Choice();
        uname.setBounds(220, 80, 150, 25);
        uname.addItemListener(new ClassListener());
        add(uname);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 120, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 120, 150, 25);
        add(tfname);

        JLabel lblamount = new JLabel("Payment Amount:");
        lblamount.setBounds(60, 160, 150, 25);
        lblamount.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblamount);

        tfamount = new JTextField();
        tfamount.setBounds(220, 160, 150, 25);
        add(tfamount);

        // Payment Method ComboBox
        JLabel lblmethod = new JLabel("Payment Method:");
        lblmethod.setBounds(60, 200, 150, 25);
        lblmethod.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblmethod);

        String[] paymentMethods = {"Cash", "Cheque", "Bank Transfer"};
        paymentMethodCombo = new JComboBox<>(paymentMethods);
        paymentMethodCombo.setBounds(220, 200, 150, 25);
        add(paymentMethodCombo);

        JLabel lblid = new JLabel("Transaction Id:");
        lblid.setBounds(60, 240, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(220, 240, 150, 25);
        add(tfid);

         submit = new JButton("Submit");
        submit.setBackground(Color.pink);
        submit.setForeground(Color.black);
        submit.setBounds(80, 290, 150, 30);
        submit.addActionListener(this);
        add(submit);
        back = new JButton("Back");
        back .setBackground(Color.pink);
        back .setForeground(Color.black);
        back .setBounds(250, 290, 150, 30);
        back .addActionListener(this);
        add(back);

        try {
            Conn c = new Conn();
            String query = "select * from Tickit";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                uname.add(rs.getString("Username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/c1.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(430,40,450,470);
        add(image);
        

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }

    private class ClassListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            String user = uname.getSelectedItem();

            try {
                Conn c5 = new Conn();
                String query2 = "select Name From Tickit  Where Username ='" + user + "'";
                ResultSet rs1 = c5.s.executeQuery(query2);
                while (rs1.next()) {
                    tfname.setText(rs1.getString(1));
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String amount = tfamount.getText();
        String method = paymentMethodCombo.getSelectedItem().toString(); // Get payment method from JComboBox
        String Id = tfid.getText();
        String user = uname.getSelectedItem();
        String Name = tfname.getText();

        try {
            Conn conn = new Conn();

            String query = "insert into payment values('" + amount + "', '" + method + "', '" + Id + "', '" + user + "', '" + Name + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Payment Details Added Successfully");
           
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ae.getSource() == back) {
            
            
            setVisible(false); // Close current window
            
            
        }
    }

    public static void main(String[] args) {
        new payment();
    }
}

=======

package airlinemanagmentsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
//import com.toedter.calendar.JDateChooser;
import java.util.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


  
public class payment extends JFrame implements ActionListener {
    JTextField tfamount, tfid, tfname;
    JComboBox<String> paymentMethodCombo;
    Choice uname;
    JButton submit,back;

    public payment() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("PAYMENT DETAILS");
        heading.setBounds(220, 20, 500, 35);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 32));
        heading.setForeground(Color.BLUE);
        add(heading);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60, 80, 150, 25);
        lblusername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblusername);

        uname = new Choice();
        uname.setBounds(220, 80, 150, 25);
        uname.addItemListener(new ClassListener());
        add(uname);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(60, 120, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(220, 120, 150, 25);
        add(tfname);

        JLabel lblamount = new JLabel("Payment Amount:");
        lblamount.setBounds(60, 160, 150, 25);
        lblamount.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblamount);

        tfamount = new JTextField();
        tfamount.setBounds(220, 160, 150, 25);
        add(tfamount);

        // Payment Method ComboBox
        JLabel lblmethod = new JLabel("Payment Method:");
        lblmethod.setBounds(60, 200, 150, 25);
        lblmethod.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblmethod);

        String[] paymentMethods = {"Cash", "Cheque", "Bank Transfer"};
        paymentMethodCombo = new JComboBox<>(paymentMethods);
        paymentMethodCombo.setBounds(220, 200, 150, 25);
        add(paymentMethodCombo);

        JLabel lblid = new JLabel("Transaction Id:");
        lblid.setBounds(60, 240, 150, 25);
        lblid.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(lblid);

        tfid = new JTextField();
        tfid.setBounds(220, 240, 150, 25);
        add(tfid);

         submit = new JButton("Submit");
        submit.setBackground(Color.pink);
        submit.setForeground(Color.black);
        submit.setBounds(80, 290, 150, 30);
        submit.addActionListener(this);
        add(submit);
        back = new JButton("Back");
        back .setBackground(Color.pink);
        back .setForeground(Color.black);
        back .setBounds(250, 290, 150, 30);
        back .addActionListener(this);
        add(back);

        try {
            Conn c = new Conn();
            String query = "select * from Tickit";
            ResultSet rs = c.s.executeQuery(query);

            while (rs.next()) {
                uname.add(rs.getString("Username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("airlinemanagmentsystem/icon/c1.png"));
        JLabel image=new JLabel(i1);
        image.setBounds(430,40,450,470);
        add(image);
        

        setSize(900, 600);
        setLocation(300, 150);
        setVisible(true);
    }

    private class ClassListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            String user = uname.getSelectedItem();

            try {
                Conn c5 = new Conn();
                String query2 = "select Name From Tickit  Where Username ='" + user + "'";
                ResultSet rs1 = c5.s.executeQuery(query2);
                while (rs1.next()) {
                    tfname.setText(rs1.getString(1));
                }
            } catch (Exception ea) {
                ea.printStackTrace();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        String amount = tfamount.getText();
        String method = paymentMethodCombo.getSelectedItem().toString(); // Get payment method from JComboBox
        String Id = tfid.getText();
        String user = uname.getSelectedItem();
        String Name = tfname.getText();

        try {
            Conn conn = new Conn();

            String query = "insert into payment values('" + amount + "', '" + method + "', '" + Id + "', '" + user + "', '" + Name + "')";

            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null, "Payment Details Added Successfully");
           
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if (ae.getSource() == back) {
            
            
            setVisible(false); // Close current window
            
            
        }
    }

    public static void main(String[] args) {
        new payment();
    }
}

>>>>>>> e9ec22e (initial commit - added full java swing project)
