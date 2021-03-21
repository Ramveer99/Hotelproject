package hotel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Updateroomst extends JFrame  implements ActionListener
{
    
    Choice c1;
    JTextField t1,t2,t3;
    JButton b1,b2,b3;
    
    Updateroomst()
    {
        
        JLabel l1=new JLabel("Update Room Status");
        l1.setFont(new Font("System",Font.BOLD,25));
        l1.setForeground(Color.BLUE);
        l1.setBounds(60,10,300,40);
        add(l1);
        
        JLabel l2=new JLabel("Guest Id:");
        l2.setFont(new Font("System",Font.BOLD,19));
        l2.setForeground(Color.RED);
        l2.setBounds(10,70,100,40);
        add(l2);
        
        c1=new Choice();
        try
        {
         conn c=new conn();
         ResultSet rs=c.s.executeQuery("select * from customer ");
         
         while(rs.next())

         {
             c1.add(rs.getString("ID_NO"));
         }
            
        }catch(Exception e){}
        
        c1.setBounds(200,70,150,40);
        add(c1);
        
        JLabel l3=new JLabel("Room Number:");
        l3.setFont(new Font("System",Font.BOLD,19));
        l3.setForeground(Color.RED);
        l3.setBounds(10,105,150,40);
        add(l3);
        
        t1=new JTextField("");
        t1.setFont(new Font("System",Font.BOLD,19));
        t1.setBounds(200,110,150,22);
        add(t1);
        
        JLabel l4=new JLabel("Available:");
        l4.setFont(new Font("System",Font.BOLD,19));
        l4.setForeground(Color.RED);
        l4.setBounds(10,165,100,40);
        add(l4);
        
        t2=new JTextField("");
        t2.setFont(new Font("System",Font.BOLD,19));
        t2.setBounds(200,170,150,22);
        add(t2);
        
        
         JLabel l5=new JLabel("Clean Status:");
        l5.setFont(new Font("System",Font.BOLD,19));
        l5.setForeground(Color.RED);
        l5.setBounds(10,205,150,40);
        add(l5);
        
        t3=new JTextField("");
        t3.setFont(new Font("System",Font.BOLD,19));
        t3.setBounds(200,210,150,22);
        add(t3);
        
        
        b1=new JButton("Check");
        b1.setFont(new Font("System",Font.BOLD,19));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(130,275,150,22);
        add(b1);
        
        b2=new JButton("Update");
        b2.setFont(new Font("System",Font.BOLD,19));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(10,335,150,22);
        add(b2);
        
        b3=new JButton("Back");
        b3.setFont(new Font("System",Font.BOLD,19));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(235,335,150,22);
        add(b3);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/seventh.jpg"));
        Image i2=i1.getImage().getScaledInstance(500, 400, 500);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l9=new JLabel(i3);
        l9.setBounds(370,0,500,400);
        add(l9);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
         b2.addActionListener(this);
          b3.addActionListener(this);
        
        
        setLayout(null);
        setBounds(230,200,900,450);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
           String room=null;
           String id=c1.getSelectedItem();
           try
           {
               conn c=new conn();
               ResultSet rs=c.s.executeQuery("select * from customer where ID_NO='"+id+"'");
               while(rs.next())
               {
                   t1.setText(rs.getString("Room_NO"));
                  room =rs.getString("ROOM_NO");
           
               }
               ResultSet rs2=c.s.executeQuery("select * from room where Room_='"+room+"'");
               while(rs2.next())
               {
                   t2.setText(rs2.getString("Status"));
                   t3.setText(rs2.getString("Cleaning_status"));
               }
               
           }catch(Exception e){
           System.out.println(e);}
        }
        else if(ae.getSource()==b2)
        {
            try
            {
               conn c=new conn();
               String roomm=t1.getText();
               String available=t2.getText();
               String status=t3.getText();
               
               String q1 ="update room set available = '"+available+"',Cleaning_status = '"+status+"' where room_number = '"+roomm+"' ";
               c.s.executeUpdate(q1);

               JOptionPane.showMessageDialog(null,"Update successfully");
               new Reception().setVisible(true);
               this.setVisible(false);
            }catch(Exception e)
            {System.out.println(e);}
        }
        else if(ae.getSource()==b3)
        {
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args)
    {
        new Updateroomst().setVisible(true);
    }
}
