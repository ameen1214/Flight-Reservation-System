package MVC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import DataStructure.LinkedList;

public class FlightController {
    ConnectTo_Database connect;
    Connection con;
    Statement stmt;
    LinkedList list;

    public FlightController() {
        connect=new ConnectTo_Database();
        con=connect.connect();
        
    }
    
    //select
    public LinkedList selectFlights() throws SQLException{
        list=new LinkedList();
         Statement stmt=con.createStatement();
         ResultSet rs=stmt.executeQuery("select * from flights"); 
         while(rs.next()){ 
             Flight f=new Flight();
             f.setFlightNumber(rs.getInt(1));
             f.setFlightName(rs.getString(2));
             f.setFlightOrigin(rs.getString(3));
             f.setFlightDestination(rs.getString(4));
             f.setFlightDuration(rs.getInt(5));
             f.setTotalSeats(rs.getInt(6));
             f.setFlightCost(rs.getInt(7));
             list.insert(f);  
         }
         return list;   
    }

    //insert
    public boolean addFlight(Flight f) throws SQLException{
        int flightNumber =f.getFlightNumber();
        String flightName=f.getFlightName();
        String flightOrigin=f.getFlightOrigin();
        String flightDestination=f.getFlightDestination();
        int flightDuration=f.getFlightDuration();
        int totalSeats=f.getTotalSeats();
        int flightCost=f.getFlightCost();     
        stmt=con.createStatement();
        String str="insert into flights(flightNumber,flightName,flightOrigin,flightDestination,flightDuration,totalSeats,flightCost)"+"values('"+flightNumber+"','"+flightName+"','"+flightOrigin+"','"+flightDestination+"','"+flightDuration+"','"+totalSeats+"','"+flightCost+"')";
        stmt.executeUpdate(str);
        return true;
    }
    
    //update flight
    public boolean updateFlight(int flightNumber,String flightName,String flightOrigin,String flightDestination,int flightDuration,int totalSeats,int flightCost) throws SQLException{
        stmt=con.createStatement();
        String str="update flights set flightName='"+flightName+"',flightOrigin='"+flightOrigin+"',flightDestination='"+flightDestination+"',flightDuration='"+flightDuration+"',totalSeats='"+totalSeats+"',flightCost='"+flightCost+"' where flightNumber='"+flightNumber+"' ";
        stmt.executeUpdate(str);
        return true;
    }
    
    //remove
    //update flight
    public boolean RemoveFlight(int flightNumber) throws SQLException{
        stmt=con.createStatement();
        String str="delete from flights where flightNumber='"+flightNumber+"' ";
        stmt.executeUpdate(str);
        return true;
    }
    public void createTableFlights()throws SQLException{
        stmt=con.createStatement();
        String str="CREATE TABLE flights (flightNumber INTEGER PRIMARY KEY,flightName VARCHAR NOT NULL,flightOrigin VARCHAR NOT NULL,flightDestination VARCHAR NOT NULL,flightDuration INTEGER,totalSeats INTEGER,flightCost INTEGER)";
        stmt.executeUpdate(str);
    }
    
    public void drop(String name)throws SQLException{
         stmt=con.createStatement();
        String str="DROP TABLE '"+name+"'";
        stmt.executeUpdate(str);
    }

}


