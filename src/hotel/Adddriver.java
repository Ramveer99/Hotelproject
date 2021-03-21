package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Adddriver extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    
    Adddriver()
    {
        l1=new JLabel("ADD DRIVER");
        l1.setFont(new Font("System",Font.BOLD,25));
        l1.setBounds(75,20,200,30);
        add(l1);
        
         l2=new JLabel("Name:");
        l2.setFont(new Font("System",Font.BOLD,20));
        l2.setBounds(30,70,200,20);
        add(l2);
        
        t1=new JTextField("");
        t1.setFont(new Font("System",Font.BOLD,23));
        t1.setBounds(180,70,170,24);
        add(t1);
        
        t2=new JTextField("");
        t2.setFont(new Font("System",Font.BOLD,23));
        t2.setBounds(180,120,170,24);
        add(t2);
        
        
        l3=new JLabel("Age");
        l3.setFont(new Font("System",Font.BOLD,20));
        l3.setBounds(30,120,200,22);
        add(l3);
        
        l4=new JLabel("Gender:");
        l4.setFont(new Font("System",Font.BOLD,20));
        l4.setBounds(30,170,200,22);
        add(l4);
        
        c1=new JComboBox(new String[] {"Male","Female"});
        c1.setFont(new Font("System",Font.BOLD,20));
        c1.setBackground(Color.WHITE);
        c1.setBounds(180,170,170,22);
        add(c1);
        
        
        l5=new JLabel("Car Company:");
        l5.setFont(new Font("System",Font.BOLD,20));
        l5.setBounds(30,220,200,22);
        add(l5);
        
        t3=new JTextField("");
        t3.setFont(new Font("System",Font.BOLD,23));
        t3.setBounds(180,220,170,24);
        add(t3);
        
        
        l6=new JLabel("Car Model:");
        l6.setFont(new Font("System",Font.BOLD,20));
        l6.setBounds(30,270,200,22);
        add(l6);
        
        t4=new JTextField("");
        t4.setFont(new Font("System",Font.BOLD,23));
        t4.setBounds(180,270,170,24);
        add(t4);
        
        
        l7=new JLabel("Available:");
        l7.setFont(new Font("System",Font.BOLD,20));
        l7.setBounds(30,320,200,22);
        add(l7);
        
        c2=new JComboBox(new String[] {"Available","NO Available"});
        c2.setFont(new Font("System",Font.BOLD,20));
        c2.setBackground(Color.WHITE);
        c2.setBounds(180,320,170,22);
        add(c2);
        
        l8=new JLabel("Location");
        l8.setFont(new Font("System",Font.BOLD,20));
        l8.setBounds(30,370,200,22);
        add(l8);
        
        t5=new JTextField("");
        t5.setFont(new Font("System",Font.BOLD,23));
        t5.setBounds(180,370,170,24);
        add(t5);
        
        b1=new JButton("ADD");
        b1.setFont(new Font("System",Font.BOLD,18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,430,90,22);
        add(b1);
        
        b2=new JButton("CANCEL");
        b2.setFont(new Font("System",Font.BOLD,19));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(200,430,130,22);
        add(b2);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 460, 500);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(300,20,600,470);
        
        getContentPane().setBackground(Color.WHITE);
        add(l9);
        setLayout(null);
        setBounds(150,120,900,550);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==b1)
       {
       String name=t1.getText();
       String age=t2.getText();
       String gender=(String)c1.getSelectedItem();
       String company=t3.getText();
       String model=t4.getText();
       String a=(String)c2.getSelectedItem();
       String location=t5.getText();
       
       conn c=new conn();
       try
       {
           String q1="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+a+"','"+location+"')";
           c.s.executeUpdate(q1);
           
           JOptionPane.showMessageDialog(null,"DRIVER ADDED");
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
        new Adddriver().setVisible(true);
    }
}