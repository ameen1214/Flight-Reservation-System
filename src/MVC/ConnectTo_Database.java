package MVC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectTo_Database {
    private static Connection con;
    Connection connect(){
        try{           
             Class.forName("org.sqlite.JDBC");
             con=DriverManager.getConnection("jdbc:sqlite:databases/Flights.db");
             return con;
        }
        catch(Exception e){ System.out.println(e);}
        return con;
    }
     protected void closeConn() throws SQLException{
        con.close();
    }
    

}
