import java.sql.*;

public class connection {
    Connection c;
    Statement s;
    public connection(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","VeDaNt@234");
            s = c.createStatement();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
