package MVC;
import DataStructure.LinkedList;
import DataStructure.QuickSort;
import Lang.Internationalization;
import java.sql.SQLException;
import java.util.ResourceBundle;

class ViewFlight {
    FlightController controller;
    LinkedList list=new LinkedList();
    static Internationalization global;
    Flight [] flights;
    QuickSort sort;
    public void viewFlights(int lang) throws SQLException{
        controller=new FlightController();
        list=controller.selectFlights();
        flights=list.toArray();
        sort=new QuickSort();
        sort.sort(flights,0,flights.length-1);
        global=Internationalization.getObject();
        ResourceBundle french=global.getFrenchBundle();
        if(lang==2){
           System.out.println(french.getString("Flight_number")+"\t"+french.getString("Flight_name")+"\t"+french.getString("Flight_origin")+"\t"+french.getString("Flight_destination")+"\t"+french.getString("Flight_duration")+"\t"+french.getString("Total_seats")+"\t"+french.getString("Flight_cost")); 
        }
        else
            System.out.println("Flight Number\tFlight Name\tFlight Origin\tFlight Destination\tFlight Duration\tFlight Seats\tFlight Cost");
            
        for(Flight f:flights){
            System.out.print(f.getFlightNumber()+"\t");
            System.out.print(f.getFlightName()+"\t");
            System.out.print(f.getFlightOrigin()+"\t");
            System.out.print(f.getFlightDestination()+"\t");
            System.out.print(f.getFlightDuration()+"\t");
            System.out.print(f.getTotalSeats()+"\t");
            System.out.println(f.getFlightCost());
        }
        
    }

}
