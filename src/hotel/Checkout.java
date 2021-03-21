package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Checkout extends JFrame implements ActionListener
{
    JButton b1,b2,b3;
    Choice c1; 
    JTextField t1;
 
    Checkout()
    {
        JLabel l1=new JLabel("Check-out Detail");
        l1.setFont(new Font("System", Font.BOLD,25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(80,20,200,22);
        add(l1);
        
         JLabel l2=new JLabel("Customer Id:");
        l2.setFont(new Font("System", Font.BOLD,21));
        l2.setForeground(Color.RED);
        l2.setBounds(5,90,180,20);
        add(l2);
        
        
        c1=new Choice();
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                c1.add(rs.getString("ID_NO"));
            }
        }catch(Exception e){}
        c1.setBounds(185,90,120,27);
        add(c1);
          JLabel l3=new JLabel("Room Number:");
        l3.setFont(new Font("System", Font.BOLD,21));
        l3.setForeground(Color.RED);
        l3.setBounds(5,160,200,20);
        add(l3);
        
        t1=new JTextField("");
        t1.setFont(new Font("System", Font.BOLD,21));
        t1.setBounds(185,160,140,20);
        add(t1);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/tick.png"));
        Image i2=i1.getImage().getScaledInstance(30, 40, 30);
        ImageIcon i3=new ImageIcon(i2);
        b3=new JButton(i3);
        b3.setBounds(320,90,23,17);
        add(b3);
        
         ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/sixth.jpg"));
        Image i5=i4.getImage().getScaledInstance(350, 400, 350);
        ImageIcon i6=new ImageIcon(i5);
        JLabel l4=new JLabel(i6);
        l4.setBounds(350,0,330,320);
        add(l4);
        
        b1=new JButton("Check-in");
        b1.setFont(new Font("System", Font.BOLD,24));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(15,230,150,22);
        add(b1);
        
        b2=new JButton("Back");
        b2.setFont(new Font("System", Font.BOLD,24));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(180,230,150,22);
        add(b2);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null);
        setBounds(200,150,700,360);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
      if(ae.getSource()==b1)
      {
          String id=c1.getSelectedItem();
          String room=t1.getText();
          String  str="delete from customer where number='"+id+"' ";
          String str1="update room set  available='Available' where room_number='"+room+"'";
          conn c=new conn();
          try
          {
              c.s.executeUpdate(str);
              c.s.executeUpdate(str1);
              JOptionPane.showMessageDialog(null,"Check-out done");
              new Reception().setVisible(true);
              this.setVisible(false);
              
          }catch(Exception e){}
      }
      else if(ae.getSource()==b2)
      {
          new Reception().setVisible(true);
          this.setVisible(false);
      }
      else if(ae.getSource()==b3)
      {
          String id=c1.getSelectedItem();
          conn c=new conn();
          try
          {
              ResultSet rs1=c.s.executeQuery("select * from customer where ID_NO='"+id+"'");
              while(rs1.next())
              {
                 t1.setText(rs1.getString("Status"));
              }
          }catch(Exception e){}
      }
    }
    
    public static  void main(String[] args)
    {
        new Checkout().setVisible(true);
    }
    
}
