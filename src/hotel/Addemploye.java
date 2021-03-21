package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Addemploye extends JFrame implements ActionListener
{
 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l11;
 JTextField t1,t2,t3,t4,t5,t6;
 JRadioButton r1,r2;
 JComboBox c1;
 JButton b1;
    
   Addemploye()
     {
       l1=new JLabel("Name;");
       l1.setFont(new Font("System",Font.PLAIN,21));
       l1.setBounds(35,33,85,15);
       
       t1=new JTextField("");
       t1.setFont(new Font("System", Font.PLAIN,19));
       t1.setBounds(125,32,140,20);
       add(t1);
       
        l2=new JLabel("Age;");
       l2.setFont(new Font("System",Font.PLAIN,21));
       l2.setBounds(35,83,85,21);
       add(l2);
       
       t2=new JTextField("");
       t2.setFont(new Font("System", Font.PLAIN,19));
       t2.setBounds(125,82,140,20);
       add(t2);
       
        l3=new JLabel("Gender;");
       l3.setFont(new Font("System",Font.PLAIN,21));
       l3.setBounds(35,133,85,21);
       add(l3);
       
        l4=new JLabel("Job;");
       l4.setFont(new Font("System",Font.PLAIN,21));
       l4.setBounds(35,173,85,21);
       add(l4);
       
        l5=new JLabel("Salary;");
       l5.setFont(new Font("System",Font.PLAIN,20));
       l5.setBounds(35,223,85,21);
       add(l5);
       
       t3=new JTextField("");
       t3.setFont(new Font("System", Font.PLAIN,19));
       t3.setBounds(125,223,140,20);
       add(t3);
       
        l6=new JLabel("Phone;");
       l6.setFont(new Font("System",Font.PLAIN,21));
       l6.setBounds(35,273,85,21);
       add(l6);
       
       t4=new JTextField("");
       t4.setFont(new Font("System", Font.PLAIN,19));
       t4.setBounds(125,272,140,20);
       add(t4);
       
        l7=new JLabel("ADHAR;");
       l7.setFont(new Font("System",Font.PLAIN,21));
       l7.setBounds(35,322,85,15);
       add(l7);
       
       t5=new JTextField("");
       t5.setFont(new Font("System", Font.PLAIN,19));
       t5.setBounds(125,322,140,20);
       add(t5);
       
        l8=new JLabel("EMAIL;");
       l8.setFont(new Font("System",Font.PLAIN,21));
       l8.setBounds(35,373,85,15);
       add(l8);
       
       t6=new JTextField("");
       t6.setFont(new Font("System", Font.PLAIN,19));
       t6.setBounds(125,373,140,20);
       add(t6);
       
       r1=new JRadioButton("Male");
       r1.setFont(new Font("System",Font.BOLD,14));
       r1.setBounds(125,134,60,16);
       add(r1);
       
        r2=new JRadioButton("Female");
       r2.setFont(new Font("System",Font.BOLD,14));
       r2.setBounds(190,134,80,16);
       add(r2);
       
       String str[]={"Front Desk Clerks","Porters","Houseckeepig","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant"};
       c1=new JComboBox(str);
       c1.setBounds(120,173,150,20);
       add(c1);
       
       b1=new JButton("Submit");
       b1.setFont(new Font("System", Font.BOLD,16));
       b1.setBounds(230,420,100,25);
       add(b1);
       
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/icon/tenth.jpg"));
       Image i2=i1.getImage().getScaledInstance(350, 550, 545);
       ImageIcon i3=new ImageIcon(i2);
       JLabel l9=new JLabel(i3);
       l9.setBounds(235,0,500,580);
       add(l9);
       
       l11=new JLabel("ADD EMPLOYE DETAILS");
       l11.setFont(new Font("System",Font.PLAIN,26));
       l11.setBounds(110,12,400,122);
       l11.setForeground(Color.RED);
       l9.add(l11);
       
       
       getContentPane().setBackground(Color.WHITE);
       
       b1.addActionListener(this);
       
       add(l1);
       setBounds(0,0,690,500);
       setLocation(160,160);
       setLayout(null);
       setVisible(true);
     }
    
   public void actionPerformed(ActionEvent ae)
   {
       String name=t1.getText();
       String age=t2.getText();
       String selery=t3.getText();
       String phone=t4.getText();
       String adhar=t5.getText();
       String Email=t6.getText();
       
       String r="null";
       if(r1.isSelected())
       {
         r="Male";  
       }
       else if(r2.isSelected())
       {
           r="Female";
       }
       String job=(String)c1.getSelectedItem();
       conn c=new conn();
       String q1="insert into employe values('"+name+"','"+age+"','"+r+"','"+job+"','"+selery+"','"+phone+"','"+adhar+"','"+Email+"')";
       try
       {
           c.s.executeUpdate(q1);
           JOptionPane.showMessageDialog(null,"New Employe Added");
           this.setVisible(false);
       }catch(Exception e)
       {
           System .out.println(e);
       }
       
   }
    
    public static void main(String[] args)
    {
        new Addemploye().setVisible(true);
    }
}