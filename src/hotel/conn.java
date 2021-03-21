package hotel;
 
import java.sql.*;

public class conn
{
    Connection c;
    Statement s;
    
    conn()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///hotel","root","");
            s=c.createStatement();
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}