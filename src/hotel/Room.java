package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 import java.sql.*;

import net.proteanit.sql.*;

public class Room extends JFrame implements ActionListener
{
    JTable t1;
    JLabel l1,l2,l3,l4,l5;
    JButton b1,b2;
    
    
    Room()
    {
        t1=new JTable();
        t1.setBounds(10,30,420,370);
        add(t1);
        
         l1=new JLabel("Room.No");
         l1.setFont(new Font("System", Font.PLAIN,15));
         l1.setBounds(5,3,80,20);
         add(l1);
        
         l2=new JLabel("Available");
         l2.setFont(new Font("System", Font.PLAIN,15));
         l2.setBounds(100,3,100,20);
         add(l2);
         
         l3=new JLabel("RoomStatus");
         l3.setFont(new Font("System", Font.PLAIN,15));
         l3.setBounds(177,3,100,20);
         add(l3);
         
         l4=new JLabel("Price");
         l4.setFont(new Font("System", Font.PLAIN,15));
         l4.setBounds(277,3,100,20);
         add(l4);
         
         l5=new JLabel("BedType");
         l5.setFont(new Font("System", Font.PLAIN,15));
         l5.setBounds(347,3,100,20);
         add(l5);
         
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(450, 380, 480);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(430,5,400,410);
        add(l9);    
        
         b1=new JButton("Load");
         b1.setFont(new Font("System", Font.BOLD,18));
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(80,410,140,30);
         add(b1);
         
         b2=new JButton("Back");
         b2.setFont(new Font("System", Font.BOLD,18));
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(280,410,140,30);
         add(b2);
        
         b1.addActionListener(this);
         b2.addActionListener(this);
         getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setBounds(200,150,850,480);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
            conn c=new conn();
            
            String q1="Select * from room";
            ResultSet rs=c.s.executeQuery(q1);
             
            t1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            }
            catch(Exception e)
            {
                
            }
        }
        else if(ae.getSource()==b2)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Room().setVisible(true);
    }
}
        