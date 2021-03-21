package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Pickup extends JFrame implements ActionListener
{
   Choice c1;
   JButton b1,b2;
   JTable t1;
   
   Pickup()
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
       
      c1=new Choice();
      try
      {
          conn c=new conn();
          ResultSet rs=c.s.executeQuery("select * from driver");
          while(rs.next())
          {
              c1.add(rs.getString("Car_Model"));
              
          }
      }catch(Exception e){}
      c1.setBounds(160,70,130,25);
      add(c1);
       
      
         t1=new JTable();
       t1.setBounds(10,130,780,230);
       add(t1);
       
        JLabel l4=new JLabel("Name");
       l4.setBounds(10,100,130,40);
       add(l4);
       
         JLabel l5=new JLabel("Age");
       l5.setBounds(125,100,130,40);
       add(l5);
       
         JLabel l6=new JLabel("Gender");
       l6.setBounds(235,100,130,40);
       add(l6);
         
          JLabel l10=new JLabel("Model");
       l10.setBounds(340,100,130,40);
       add(l10);
       
       JLabel l7=new JLabel("Car");
       l7.setBounds(458,100,130,40);
       add(l7);
       
         JLabel l8=new JLabel("Available");
       l8.setBounds(573,100,130,40);
       add(l8);
       
          JLabel l9=new JLabel("Location");
       l9.setBounds(680,100,130,40);
       add(l9);
       
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
           String type= c1.getSelectedItem();
           try
           {
               conn c=new conn();
             String str="select * from driver where Car_Model='"+type+"'";
             
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
       new Pickup().setVisible(true);
   }
   
}
