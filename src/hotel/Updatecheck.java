
package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import net.proteanit.sql.*;

public class Updatecheck extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5;
    Choice c1;
    JButton b1,b2,b3;
    Updatecheck()
    {
        l1=new JLabel("Check-in Detail:");
        l1.setFont(new Font("System", Font.BOLD,20));
        l1.setForeground(Color.BLUE);
        l1.setBounds(80,30,200,30);
        add(l1);
        
        l2=new JLabel("Custumer ID:");
        l2.setFont(new Font("System", Font.BOLD,20));
        l2.setForeground(Color.RED);
        l2.setBounds(30,80,200,30);
        add(l2);
        
        
        c1=new Choice();
        try
        {
            conn c=new conn();
            ResultSet rs=c.s.executeQuery("select * from customer");
            while(rs.next())
            {
                c1.add(rs.getString("ID_No"));
            }
        }catch(Exception e){System.out.println(e);}
        c1.setBounds(240,80,150,30);
        add(c1);
        
        
        l3=new JLabel("Room Number:");
        l3.setFont(new Font("System", Font.BOLD,20));
        l3.setForeground(Color.RED);
        l3.setBounds(30,120,200,30);
        add(l3);
        
        t1=new JTextField("");
        t1.setBounds(240,120,180,25);
        add(t1);
        
        
        l4=new JLabel("Name");
        l4.setFont(new Font("System", Font.BOLD,20));
        l4.setForeground(Color.RED);
        l4.setBounds(30,160,200,30);
        add(l4);
        
        t2=new JTextField("");
        t2.setBounds(240,160,180,25);
        add(t2);
        
         l5=new JLabel("Check-in:");
        l5.setFont(new Font("System", Font.BOLD,20));
        l5.setForeground(Color.RED);
        l5.setBounds(30,200,200,30);
        add(l5);
        
        t3=new JTextField("");
        t3.setBounds(240,200,180,25);
        add(t3);
        
        l6=new JLabel("Amount Paid:");
        l6.setFont(new Font("System", Font.BOLD,20));
        l6.setForeground(Color.RED);
        l6.setBounds(30,240,200,30);
        add(l6);
        
        t4=new JTextField("");
        t4.setBounds(240,240,180,25);
        add(t4);
        
        l7=new JLabel("Panding amount:");
        l7.setFont(new Font("System", Font.BOLD,20));
        l7.setForeground(Color.RED);
        l7.setBounds(30,280,200,30);
        add(l7);
        
        t5=new JTextField("");
        t5.setBounds(240,280,180,25);
        add(t5);
        
        b1=new JButton("Check");
        b1.setFont(new Font("System", Font.BOLD,20));
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setBounds(130,330,120,25);
        add(b1);
        
        b2=new JButton("Update");
        b2.setFont(new Font("System", Font.BOLD,20));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(30,380,120,25);
        add(b2);
        
        b3=new JButton("Back");
        b3.setFont(new Font("System", Font.BOLD,20));
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setBounds(250,380,120,25);
        add(b3);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/nine.jpg"));
        JLabel l9=new JLabel(i1);
        l9.setBounds(370,0,600,450);
        add(l9);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        setLayout(null);
        setBounds(200,150,1000,500);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            String id=c1.getSelectedItem();
            String room=null;
            String deposit=null;
            String price=null;
            int amountpaid;
            try
            {
               conn c=new conn();
              ResultSet rs=c.s.executeQuery("select * from customer where ID_NO='"+id+"' ");
              while(rs.next())
              {
                  t1.setText(rs.getString("Room_No"));
                  t2.setText(rs.getString("Name"));
                  t3.setText(rs.getString("Status"));
                  t4.setText(rs.getString("Deposite"));
                  room=rs.getString("Status");
                  deposit=rs.getString("Deposite");
              }
              ResultSet rs2=c.s.executeQuery("select * from room where Room_No='"+room+"' "); 
              while(rs2.next())
              {
                  price=rs2.getString("price");
                  amountpaid=Integer.parseInt(price)-Integer.parseInt(deposit);
                  t5.setText(Integer.toString(amountpaid));
              }
              
            }
            catch(Exception e){}
            
        }
        else if(ae.getSource()==b2)
        {
            
        }
        else if(ae.getSource()==b3)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Updatecheck().setVisible(true);
    }
    
}
