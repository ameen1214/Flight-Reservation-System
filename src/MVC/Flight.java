package MVC;
public class Flight {
    private int flightNumber;
    private String flightName;
    private String flightOrigin;
    private String flightDestination;
    private int flightDuration;
    private int totalSeats;
    private int flightCost;
    
    public Flight(){
        
    }
    
    private static Flight object=new Flight();
    
//    public static Flight getFlight(){
//        return object;
//    }
    
    //setsers
    public void setFlightNumber(int flightNumber){
        this.flightNumber=flightNumber;
    }
    public void setFlightName(String flightName){
        this.flightName=flightName;
    }
    public void setFlightOrigin(String flightOrigin){
        this.flightOrigin=flightOrigin;
    }
    public void setFlightDestination(String flightDestination){
        this.flightDestination=flightDestination;
    }
    public void setFlightDuration(int flightDuration){
       this.flightDuration=flightDuration;
    }
    public void setTotalSeats(int totalSeats){
        this.totalSeats=totalSeats;
    }
    public void setFlightCost(int flightCost){
        this.flightCost=flightCost;
    }
    //geters
    public int getFlightNumber(){
        return flightNumber;
    }
    public String getFlightName(){
        return flightName;
    }
    public String getFlightOrigin(){
        return flightOrigin;
    }
    public String getFlightDestination(){
        return flightDestination;
    }
    public int getFlightDuration(){
        return flightDuration;
    }
    public int getTotalSeats(){
        return totalSeats;
    }
    public int getFlightCost(){
        return flightCost;
    }
    

}