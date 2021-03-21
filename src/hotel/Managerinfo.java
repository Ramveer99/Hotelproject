package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Managerinfo extends JFrame implements ActionListener
{
     JTable t1;
     JButton b1,b2;
     JLabel l1,l2,l3,l4,l5,l6,l7,l8;
     
     Managerinfo()
     {
         t1=new JTable();
         t1.setBounds(0,25,800,440);
         add(t1);
         
         l1=new JLabel("Name");
         l1.setFont(new Font("System", Font.PLAIN,15));
         l1.setBounds(5,3,100,20);
         add(l1);
         
         l2=new JLabel("Age");
         l2.setFont(new Font("System", Font.PLAIN,15));
         l2.setBounds(110,3,100,20);
         add(l2);
         
         l3=new JLabel("Gender");
         l3.setFont(new Font("System", Font.PLAIN,14));
         l3.setBounds(210,3,100,20);
         add(l3);
         
         l4=new JLabel("Job");
         l4.setFont(new Font("System", Font.PLAIN,14));
         l4.setBounds(310,3,100,20);
         add(l4);
         
         l5=new JLabel("Salary");
         l5.setFont(new Font("System", Font.PLAIN,14));
         l5.setBounds(410,3,100,20);
         add(l5);
         
         l6=new JLabel("Phone");
         l6.setFont(new Font("System", Font.PLAIN,14));
         l6.setBounds(510,3,100,20);
         add(l6);
         
         l7=new JLabel("Adhar");
         l7.setFont(new Font("System", Font.PLAIN,14));
         l7.setBounds(610,3,100,20);
         add(l7);
         
         l8=new JLabel("Email");
         l8.setFont(new Font("System", Font.PLAIN,14));
         l8.setBounds(710,3,100,20);
         add(l8);
         
         b1=new JButton("Load");
         b1.setFont(new Font("System", Font.BOLD,18));
         b1.setBackground(Color.BLACK);
         b1.setForeground(Color.WHITE);
         b1.setBounds(200,475,140,30);
         add(b1);
         
         b2=new JButton("Back");
         b2.setFont(new Font("System", Font.BOLD,18));
         b2.setBackground(Color.BLACK);
         b2.setForeground(Color.WHITE);
         b2.setBounds(480,475,140,30);
         add(b2);
         
         b1.addActionListener(this);
         b2.addActionListener(this);
         
         setLayout(null);
         setBounds(200,150,830,550);
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
             String str="select * from employe where Job='Manager' ";
             ResultSet rs=c.s.executeQuery(str);
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
        new Managerinfo().setVisible(true);
    }
}