package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener
{
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b13;
    Reception()
    {
        b1=new JButton("new Custumer Form");
        b1.setFont(new Font("System",Font.BOLD,16));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(5,5,200,24);
        add(b1);
        
        b2=new JButton("ROOM");
        b2.setFont(new Font("System",Font.BOLD,16));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(5,40,200,24);
        add(b2);
        
        b3=new JButton("DEPARTMENT");
        b3.setFont(new Font("System",Font.BOLD,16));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(5,80,200,24);
        add(b3);
        
        b4=new JButton("ALL EMPLOYE INFO");
        b4.setFont(new Font("System",Font.BOLD,16));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        b4.setBounds(5,120,200,24);
        add(b4);
        
        b5=new JButton("Customer Info");
        b5.setFont(new Font("System",Font.BOLD,16));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        b5.setBounds(5,160,200,22);
        add(b5);
        
        b6=new JButton("Manger Info");
        b6.setFont(new Font("System",Font.BOLD,16));
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        b6.setBounds(5,200,200,22);
        add(b6);
        
        b7=new JButton("Check Out");
        b7.setFont(new Font("System",Font.BOLD,16));
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        b7.setBounds(5,240,200,22);
        add(b7);
        
        b8=new JButton("Upadate Check Status");
        b8.setFont(new Font("System",Font.BOLD,16));
        b8.setBackground(Color.BLACK);
        b8.setForeground(Color.WHITE);
        b8.setBounds(5,280,200,22);
        add(b8);
        
        b9=new JButton("Update Room Status");
        b9.setFont(new Font("System",Font.BOLD,16));
        b9.setBackground(Color.BLACK);
        b9.setForeground(Color.WHITE);
        b9.setBounds(5,320,200,22);
        add(b9);
        
        b10=new JButton("Pick up Service");
        b10.setFont(new Font("System",Font.BOLD,16));
        b10.setBackground(Color.BLACK);
        b10.setForeground(Color.WHITE);
        b10.setBounds(5,360,200,22);
        add(b10);
        
        b11=new JButton("Service Room");
        b11.setFont(new Font("System",Font.BOLD,16));
        b11.setBackground(Color.BLACK);
        b11.setForeground(Color.WHITE);
        b11.setBounds(5,400,200,22);
        add(b11);
        
       /* b12=new JButton("Add room");
        b12.setFont(new Font("System",Font.BOLD,16));
        b12.setBackground(Color.BLACK);
        b12.setForeground(Color.WHITE);
        b12.setBounds(5,440,200,22);
        add(b12);*/
        
        b13=new JButton("Logout");
        b13.setFont(new Font("System",Font.BOLD,16));
        b13.setBackground(Color.BLACK);
        b13.setForeground(Color.WHITE);
        b13.setBounds(5,440,200,22);
        add(b13);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/fourth.jpg"));
        JLabel l1=new JLabel(i1);
        l1.setBounds(200,0,530,470);
        add(l1);
    
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b10.addActionListener(this);
        b11.addActionListener(this);
         b13.addActionListener(this);
        
        setLayout(null);
        setBounds(200,150,750,540);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new Addcustomer().setVisible(true);
            this.setVisible(false);
        }
        else if(ae.getSource()==b2)
        {
            new Room().setVisible(true);
            this.setVisible(false);
        }
         else if(ae.getSource()==b3)
        {
            new Department().setVisible(true);
            this.setVisible(false);
        }
         else if(ae.getSource()==b4)
        {
            new Employe().setVisible(true);
            this.setVisible(false);
        }
         else if(ae.getSource()==b5)
        {
            new Customerinfo().setVisible(true);
            this.setVisible(false);
        }
         else if(ae.getSource()==b6)
        {
           new Managerinfo().setVisible(true);
           this.setVisible(false);
        }
         else if(ae.getSource()==b7)
        {
            new Checkout().setVisible(true);
            this.setVisible(false);
            
        }
         else if(ae.getSource()==b8)
        {
            new Updatecheck().setVisible(true);
            this.setVisible(false);
        }
         else if(ae.getSource()==b9)
        {
            new Updateroomst().setVisible(true);
            this.setVisible(false);
        }
         else if(ae.getSource()==b10)
        {
            new Pickup().setVisible(true);
            this.setVisible(true);
        }
         else if(ae.getSource()==b11)
        {
            new Searchroom().setVisible(true);
            this.setVisible(false);
        }
       
         else if(ae.getSource()==b13)
         {
             new Login().setVisible(true);
             this.setVisible(false);
         }
    }
    
    public static void main(String[] args)
    {
        new Reception().setVisible(true);
    }
}