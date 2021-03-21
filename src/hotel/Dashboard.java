package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener
{
    JMenuBar mb;
    JMenu m1,m2;
    JMenuItem i1,i2,i3,i4;
    
    Dashboard()
    {
        mb=new JMenuBar();
        add(mb);
        
        m1= new JMenu("Hotel Management");
        m1.setForeground(Color.RED);
        mb.add(m1);
        
        m2=new JMenu("Admin");
        m2.setForeground(Color.RED);
        mb.add(m2);
        
        i1=new JMenuItem("RECEPTION");
        i1.addActionListener(this);
        m1.add(i1);
                
         i2=new JMenuItem("ADD EMPLOYEE");
         i2.addActionListener(this);
        m2.add(i2);
        
         i3=new JMenuItem("ADD ROOM");
         i3.addActionListener(this);
        m2.add(i3);
        
         i4=new JMenuItem("ADD DRIVER");
         i4.addActionListener(this);
        m2.add(i4);
        
        mb.setBounds(0,0,1950,30);
        
        ImageIcon a1=new ImageIcon(ClassLoader.getSystemResource("Hotel/icon/third.jpg"));
        Image a2=a1.getImage().getScaledInstance(1500, 700,920);
        ImageIcon a3=new ImageIcon(a2);
        JLabel l1=new JLabel(a3);
        l1.setBounds(0,0,1500,730);
        add(l1);
       // i2.addActionListener(this);
        
        setLayout(null);
        setBounds(0,0,1850,720);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getActionCommand().equals("RECEPTION"))
        {
           new Reception().setVisible(true); 
        }
        else if(ae.getActionCommand().equals("ADD EMPLOYEE"))
        {
      
            new Addemploye().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD ROOM"))
        {
            new Addroom().setVisible(true);
        }
        else if(ae.getActionCommand().equals("ADD DRIVER"))
        {
            new Adddriver().setVisible(true);
        }
    }
   
    public static void main(String[] orgs)
    {
        new Dashboard().setVisible(true);
    }
}