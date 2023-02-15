
import DataStructure.LinkedList;
import MVC.Flight;
import MVC.FlightController;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTesting {
    FlightController c;
    public JUnitTesting() {
         c=new FlightController();
    }
    
    @Before
    public void addFlightTest() throws SQLException {
        c.drop("flights");
        c.createTableFlights();
        Flight f=new Flight();
        f.setFlightCost(5000);
        f.setFlightDestination("Egypt");
        f.setFlightDuration(400);
        f.setFlightName("flight1");
        f.setFlightOrigin("Iraq");
        f.setFlightNumber(20);
        f.setTotalSeats(100);
        assertEquals(true,c.addFlight(f)); 
    }
    
    @After
    public void RemoveFlightTest() throws SQLException {
        int number=20;
        assertEquals(true,c.RemoveFlight(number)); 
    }
    
    @Test
    public void updateFlightsTest() throws SQLException {
        assertEquals(true,c.updateFlight(20, "flight1", "China", "Egypt", 400, 100, 5000)); 
    }
    @Test(expected = Exception.class)
    public void selectFlightsTest() throws SQLException {
        Flight f=new Flight();
        f.setFlightCost(5000);
        f.setFlightDestination("Egypt");
        f.setFlightDuration(400);
        f.setFlightName("flight1");
        f.setFlightOrigin("Iraq");
        f.setFlightNumber(20);
        f.setTotalSeats(100);
        LinkedList l=new LinkedList();
        l.insert(f);
        
        assertEquals(true,l.compare(c.selectFlights())); 
    }

}
