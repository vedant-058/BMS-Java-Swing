import java.sql.*;
public class connection {
    public connection(){
        connection c;
        try{
            Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
