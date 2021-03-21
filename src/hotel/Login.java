package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener
{
    JLabel l1,l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1,b2;
    Login()
    {
        l1=new JLabel("Username:");
        l1.setFont(new Font("System",Font.BOLD,18));
        l1.setBounds(30,30,100,23);
        add(l1);
        
        t1=new JTextField("");
        t1.setFont(new Font("System",Font.BOLD,16));
        t1.setBounds(140,30,150,21);
        add(t1);
        
         p1=new JPasswordField("");
        p1.setFont(new Font("System",Font.BOLD,16));
        p1.setBounds(140,80,150,21);
        add(p1);
        
        l2=new JLabel("Password:");
        l2.setFont(new Font("System",Font.BOLD,18));
        l2.setBounds(30,80,100,23);
        add(l2);
        
         b1=new JButton("LOGIN");
        b1.setFont(new Font("System",Font.BOLD,17));
        b1.setBounds(30,150,115,24);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        add(b1);
        
        b2=new JButton("CANCAL");
        b2.setFont(new Font("System",Font.BOLD,17));
        b2.setBounds(180,150,115,24);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        add(b2);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel/icon/second.jpg"));
        Image i2= i1.getImage().getScaledInstance(200, 200, 2000);
        ImageIcon i3=new ImageIcon(i2);       
        JLabel l3=new JLabel(i3);
        l3.setBounds(280,0,300,200);
        add(l3);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        setLayout(null);
        setBounds(300,300,560,330);
        setLocation(250,250);
        setVisible(true);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            
            String username=t1.getText();
            String password=p1.getText();
            conn c1=new conn();
            String str="select * from login where Username='"+username+"' and Password='"+password+"' ";
            try
            {
                ResultSet rs=c1.s.executeQuery(str);
                if(rs.next())
                {
                    new Dashboard().setVisible(true);
                    setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"please enter correct data ");
                    new Hotel().setVisible(true);
                    this.setVisible(false);
                }
                
            }catch(Exception e)
            {
                e.printStackTrace();
            }
                    
        }
        else if(ae.getSource()==b2)
        {
            System.exit(0);
        }
        
    }
    
    public static void main(String[] args)
    {
        new Login();
    }
}