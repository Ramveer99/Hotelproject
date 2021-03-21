package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Addroom extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField t1,t2;
    JComboBox c1,c2,c3;
    JButton b1,b2;
    
    Addroom()
    {
      l1=new JLabel("ADD ROOM");
      l1.setFont(new Font("System", Font.BOLD,24));
      l1.setBounds(100,30,150,30);
      add(l1);
      
      l2=new JLabel("Room Number:");
      l2.setFont(new Font("System", Font.PLAIN,17));
      l2.setBounds(30,80,120,19);
      add(l2);
      
      
      t1=new JTextField("");
      t1.setFont(new Font("System", Font.PLAIN,18));
      t1.setBounds(163,80,120,20);
      add(t1);
      
      l3=new JLabel("Available:");
      l3.setFont(new Font("System", Font.PLAIN,17));
      l3.setBounds(30,130,120,19);
      add(l3);
      
      
   
      
      l4=new JLabel("Cleaning Status:");
      l4.setFont(new Font("System", Font.PLAIN,17));
      l4.setBounds(30,180,120,19);
      add(l4);
      
       l5=new JLabel("Price:");
      l5.setFont(new Font("System", Font.PLAIN,17));
      l5.setBounds(30,230,120,19);
      add(l5);
      
       t2=new JTextField("");
      t2.setFont(new Font("System", Font.PLAIN,18));
      t2.setBounds(163,230,120,20);
      add(t2);
      
     
      l6=new JLabel("Bed Type:");
      l6.setFont(new Font("System", Font.PLAIN,17));
      l6.setBounds(30,280,120,19);
      add(l6);
      
      c1=new JComboBox(new String[] {"Available","Occupied"});
      c1.setFont(new Font("System",Font.PLAIN,17));
      c1.setBounds(160,130,120,21);
      add(c1);
      
      c2=new JComboBox(new String[] {"Clean","NO Clean"});
      c2.setFont(new Font("System",Font.PLAIN,17));
      c2.setBounds(160,180,120,21);
      add(c2);
      
      c3=new JComboBox(new String[] {"Single","Double"});
      c3.setFont(new Font("System",Font.PLAIN,17));
      c3.setBounds(160,280,120,21);
      add(c3);
      
      
      b1=new JButton("ADD ROOM");
      b1.setFont(new Font("System", Font.BOLD,17));
      b1.setBackground(Color.BLACK);
      b1.setForeground(Color.white);
      b1.setBounds(30,340,100,30);
      add(b1);
      
      b2=new JButton("CANCEL");
      b2.setFont(new Font("System", Font.BOLD,17));
      b2.setBackground(Color.BLACK);
      b2.setForeground(Color.white);
      b2.setBounds(150,340,120,30);
      add(b2);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/twelve.jpg"));
      Image i2=i1.getImage().getScaledInstance(400, 350, 400);
      ImageIcon i3=new ImageIcon(i2);
      JLabel l10=new JLabel(i3);
      l10.setBounds(200,35,600,400);
      add(l10);
      
      b1.addActionListener(this);
      b2.addActionListener(this);
      
      getContentPane().setBackground(Color.WHITE);
      
      setLayout(null);
      setVisible(true);
      setBounds(150,150,750,470);
      
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
          String roomno=t1.getText();
          String price=t2.getText();
          String a=(String)c1.getSelectedItem();
          String clean=(String)c2.getSelectedItem();
          String bed=(String)c3.getSelectedItem();
          conn c=new conn();
          try
          {
          String q1="insert into room values('"+roomno+"','"+a+"','"+clean+"','"+price+"','"+bed+"')";
          c.s.executeUpdate(q1);
          
          JOptionPane.showMessageDialog(null,"ROOM ADDED");
          this.setVisible(false);
              
          }
          catch(Exception e)
          {
          System.out.println(e);
          }
        }
        else if(ae.getSource()==b2)
        {
            System.exit(0);
        }
    }
    
    public static void main(String[] args)
    {
        new Addroom().setVisible(true);
    }
}