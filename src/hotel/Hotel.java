
package hotel;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Hotel extends JFrame implements ActionListener
{
    JLabel l2;
    JButton b1;
    Hotel()
    {
    //setBounds(300,300,1250,565);
   
        l2=new JLabel("Hotel Management System");
    l2.setFont(new Font("System", Font.BOLD,40));
    l2.setBounds(20,470,1000,50);
    l2.setForeground(Color.WHITE);
    add(l2);
    
    b1=new JButton("Login");
    b1.setFont(new Font("System",Font.BOLD,25));
    b1.setBackground(Color.CYAN);
    b1.setBounds(600,480,160,30);
    add(b1);
    
    
    ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Hotel/icon/first.jpg"));
    JLabel l1=new JLabel(i1);
    l1.setBounds(0,0,1366,565);
    add(l1);
   
    b1.addActionListener(this);
    
     setLayout(null);
    setSize(1230,565);
    setLocation(20,80);
    setVisible(true);
    
    while(true)
    {
        l2.setVisible(false);
       try
       {
           Thread.sleep(500);
       }catch(Exception e)
       {
           
       }
       l2.setVisible(true);
       try
       {
           Thread.sleep(500);
       }
       catch(Exception e)
       {
        
       }
    }
    
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            new Login().setVisible(true);
            setVisible(false);
        }
    }

    
    public static void main(String[] args)
    {
        new Hotel().setVisible(true);
    }
    
}
