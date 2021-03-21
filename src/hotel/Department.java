package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Department extends JFrame implements ActionListener
{

   JButton b1,b2;
   JTable t1;
   
   Department()
   {
       JLabel l1=new JLabel("Pickup for Room");
       l1.setFont(new Font("System",Font.BOLD,23));
       l1.setForeground(Color.BLUE);
       l1.setBounds(60,14,200,30);
       add(l1);
       
        JLabel l2=new JLabel("Model of car");
       l2.setFont(new Font("System",Font.BOLD,20));
       l2.setForeground(Color.RED);
       l2.setBounds(30,70,130,25);
       add(l2);
       
     
       
         t1=new JTable();
       t1.setBounds(10,130,780,230);
       add(t1);
       
        JLabel l4=new JLabel("Department");
       l4.setBounds(10,100,130,40);
       add(l4);
       
         JLabel l5=new JLabel("Budget");
       l5.setBounds(425,100,130,40);
       add(l5);
       
     
       
       b1=new JButton("Submite");
       b1.setFont(new Font("System",Font.BOLD,20));
       b1.setBackground(Color.black);
       b1.setForeground(Color.white);
       b1.setBounds(140,390,120,22);
       add(b1);
       
       b2=new JButton("Back");
       b2.setFont(new Font("System",Font.BOLD,20));
       b2.setBackground(Color.black);
       b2.setForeground(Color.white);
       b2.setBounds(460,390,120,22);
       add(b2);
       
       b1.addActionListener(this);
       b2.addActionListener(this);
       
       
       setLayout(null);
       setBounds(200,160,830,480);
       setVisible(true);
   }
    
   @Override
   public void actionPerformed(ActionEvent ae)
   {
       if(ae.getSource()==b1)
       {
         try
           {
             String str="select * from department";
             conn c=new conn();
             ResultSet rs=c.s.executeQuery(str);
                 t1.setModel(DbUtils.resultSetToTableModel(rs));
           
           }catch(Exception e){System.out.println(e);}
        }
       else if(ae.getSource()==b2)
       {
           new Reception().setVisible(true);
           this.setVisible(false);
       }
   }
   
   
   public static void main(String[] args)
   {
       new Department().setVisible(true);
   }
   
}

