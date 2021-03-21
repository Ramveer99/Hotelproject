package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;


public class Searchroom extends JFrame implements ActionListener
{
   JComboBox c1;
   JCheckBox c2;
   JButton b1,b2;
   JTable t1;
   
   Searchroom()
   {
       JLabel l1=new JLabel("Search for Room");
       l1.setFont(new Font("System",Font.BOLD,23));
       l1.setForeground(Color.BLUE);
       l1.setBounds(60,14,200,30);
       add(l1);
       
        JLabel l2=new JLabel("Bed type");
       l2.setFont(new Font("System",Font.BOLD,20));
       l2.setForeground(Color.RED);
       l2.setBounds(30,70,130,25);
       add(l2);
       
       c1=new JComboBox(new String[]{"Single","Double"});
       c1.setBounds(160,70,130,25);
       add(c1);
       
       c2=new JCheckBox("Only Available");
       c2.setFont(new Font("System",Font.BOLD,18));
        c2.setBounds(460,70,190,25);
       add(c2);
       
       t1=new JTable();
       t1.setBounds(10,130,780,230);
       add(t1);
       
        JLabel l4=new JLabel("Room");
       l4.setBounds(10,100,130,40);
       add(l4);
       
         JLabel l5=new JLabel("Available");
       l5.setBounds(166,100,130,40);
       add(l5);
       
         JLabel l6=new JLabel("Status");
       l6.setBounds(326,100,130,40);
       add(l6);
         
       JLabel l7=new JLabel("Price");
       l7.setBounds(475,100,130,40);
       add(l7);
       
         JLabel l8=new JLabel("Type");
       l8.setBounds(635,100,130,40);
       add(l8);
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
           String type=(String) c1.getSelectedItem();
           try
           {
             String str="select * from room where Bed_type='"+type+"'";
             String str2="select * from room  where available='Available' AND Bed_type='"+type+"' ";
           
             conn c=new conn();
             ResultSet rs;
             if(c2.isSelected())
             {
                rs=c.s.executeQuery(str);
                 t1.setModel(DbUtils.resultSetToTableModel(rs));
                 
             
             ResultSet rs1;
             
                 rs1=c.s.executeQuery(str2);
                 t1.setModel(DbUtils.resultSetToTableModel(rs1));
             }
           
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
       new Searchroom().setVisible(true);
   }
   
}
