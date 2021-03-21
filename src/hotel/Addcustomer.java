package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Addcustomer extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1;
    Choice c2;
    JRadioButton r1,r2;
    
    Addcustomer()
    {
        l1=new JLabel("NEW CUSTOMER FORM");
        l1.setFont(new Font("System", Font.BOLD,22));
        l1.setForeground(Color.BLUE);
        l1.setBounds(110,20,300,20);
        add(l1);
        
        l2=new JLabel("Id");
        l2.setFont(new Font("System", Font.BOLD,19));
        l2.setForeground(Color.RED);
        l2.setBounds(30,70,80,25);
        add(l2);
        
       c1=new JComboBox(new String[]{"Passport","Voter-Id Card","Diriver License","Adhar Card"});
       c1.setFont(new Font("System", Font.BOLD,17));
       c1.setBounds(200,70,160,24);
       add(c1);
       
        l3=new JLabel("Id NUMber");
        l3.setFont(new Font("System", Font.BOLD,19));
        l3.setForeground(Color.RED);
        l3.setBounds(30,110,80,25);
        add(l3);
        
        t1=new JTextField("");
        t1.setFont(new Font("System", Font.BOLD,20));
        t1.setBounds(200,107,160,25);
        add(t1);
       
        l9=new JLabel("Name");
        l9.setFont(new Font("System", Font.BOLD,19));
        l9.setForeground(Color.RED);
        l9.setBounds(30,150,80,25);
        add(l9);
        
        t2=new JTextField("");
        t2.setFont(new Font("System", Font.BOLD,20));
        t2.setBounds(200,150,160,25);
        add(t2);
        
       
        
        l4=new JLabel("Gander");
        l4.setFont(new Font("System", Font.BOLD,19));
        l4.setForeground(Color.RED);
        l4.setBounds(30,190,80,25);
        add(l4);
        
        r1=new JRadioButton("Male");
        r1.setFont(new Font("System", Font.BOLD,16));
        r1.setBounds(200,190,80,20);
        add(r1);
        
        r2=new JRadioButton("Female");
        r2.setFont(new Font("System", Font.BOLD,16));
        r2.setBounds(280,190,100,20);
        add(r2);
        
        l5=new JLabel("Country");
        l5.setFont(new Font("System", Font.BOLD,19));
        l5.setForeground(Color.RED);
        l5.setBounds(30,230,130,25);
        add(l5);
        
        t3=new JTextField("");
        t3.setFont(new Font("System", Font.BOLD,20));
        t3.setBounds(200,230,160,25);
        add(t3);
        
        l6=new JLabel("Allocated Room N0.");
        l6.setFont(new Font("System", Font.BOLD,18));
        l6.setForeground(Color.RED);
        l6.setBounds(25,270,174,25);
        add(l6);
        
        c2=new Choice();
        try
        {
            conn c=new conn();
            String q1="Select * from room";
            ResultSet rs=c.s.executeQuery(q1);
            
            while(rs.next())
            {
                c2.add(rs.getString("Room_No"));
            }
            
        }
        catch(Exception e){}
        c2.setFont(new Font("System", Font.BOLD,17));
        c2.setBounds(200,270,150,24);
        add(c2);
        
        l7=new JLabel("Checked In");
        l7.setFont(new Font("System", Font.BOLD,19));
        l7.setForeground(Color.RED);
        l7.setBounds(30,310,120,25);
        add(l7);
        
        t4=new JTextField("");
        t4.setFont(new Font("System", Font.BOLD,20));
        t4.setBounds(200,310,160,25);
        add(t4);
        
        l8=new JLabel("Deposite");
        l8.setFont(new Font("System", Font.BOLD,19));
        l8.setForeground(Color.RED);
        l8.setBounds(30,350,100,25);
        add(l8);
        
        t5=new JTextField("");
        t5.setFont(new Font("System", Font.BOLD,20));
        t5.setBounds(200,350,160,25);
        add(t5);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(400, 460, 400);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l10=new JLabel(i3);
        l10.setBounds(370,10,400,400);
        add(l10);
        
        
        b1=new JButton("Add Customer");
        b1.setFont(new Font("System", Font.BOLD,18));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(33,395,160,24);
        add(b1);
        
        b2=new JButton("Back");
        b2.setFont(new Font("System", Font.BOLD,18));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(225,395,130,24);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        setLayout(null);
        setBounds(200,150,800,470);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String id=(String)c1.getSelectedItem();
            String number=t1.getText();
            String name=t2.getText();
            
            String g="null";
            if(r1.isSelected())
            {
                g="Mela";
            }
            else if(r2.isSelected())
            {
                g="Female";
            }
            String country=t3.getText();
            String room=c2.getSelectedItem();
            String check=t4.getText();
            String deposite=t5.getText();
             //conn c=new conn();
              conn c1=new conn();
            String q1="insert into customer values('"+id+"','"+number+"','"+name+"','"+g+"','"+country+"','"+room+"','"+check+"','"+deposite+"')";
            String q2="update room set Room_Static='occupied' where Room_No='"+room+"' ";
            try
            {
             c1.s.executeUpdate(q1);
             c1.s.executeUpdate(q2);
             JOptionPane.showMessageDialog(null,"New Custumer Added");
              new Reception().setVisible(true);
              this.setVisible(false);
            }
            catch(Exception e){System.out.println(e);}
            
        }
        else if(ae.getSource()==b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Addcustomer().setVisible(true);
    }
}