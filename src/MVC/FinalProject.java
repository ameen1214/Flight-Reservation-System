package MVC;
import java.sql.SQLException;
import java.util.Scanner;
import Lang.Internationalization;
import java.util.ResourceBundle;

public class FinalProject {
    static FlightController controller;
    static Internationalization global;
    static String enter,fNum,fN,fO,fDes,fDu,fT,fC;
    
    static void add(Scanner input) {
        System.out.print(enter+" "+fNum+": ");
        int number=input.nextInt();
        System.out.print(enter+" "+fN+": ");
        String name=input.next();
        System.out.print(enter+" "+fO+": ");
        String origin=input.next();
        System.out.print(enter+" "+fDes+": ");
        String destination=input.next();
        System.out.print(enter+" "+fDu+": ");
        int duratuin=input.nextInt();
        System.out.print(enter+" "+fT+": ");
        int total=input.nextInt();
        System.out.print(enter+" "+fC+": ");
        int cost=input.nextInt();
        Flight f=new Flight();
         f.setFlightNumber(number);
         f.setFlightName(name);
         f.setFlightOrigin(origin);
         f.setFlightDestination(destination);
         f.setFlightDuration(duratuin);
         f.setTotalSeats(total);
         f.setFlightCost(cost);
         try{
            controller.addFlight(f);  
         } catch (SQLException ex) {
            
        }
        
    }
    static void Remove(Scanner input){
        System.out.print("Enter flight ID: ");
        int id=input.nextInt();
        try {
            controller.RemoveFlight(id);
        } catch (SQLException ex) {
            
        }
    }
    static void changeInfo(Scanner input){
        System.out.print(enter+" "+fNum+": ");
        int number=input.nextInt();
        System.out.print(enter+" "+fN+": ");
        String name=input.next();
        System.out.print(enter+" "+fO+": ");
        String origin=input.next();
        System.out.print(enter+" "+fDes+": ");
        String destination=input.next();
        System.out.print(enter+" "+fDu+": ");
        int duratuin=input.nextInt();
        System.out.print(enter+" "+fT+": ");
        int total=input.nextInt();
        System.out.print(enter+" "+fC+": ");
        int cost=input.nextInt();
        Flight f=new Flight();
         f.setFlightNumber(number);
         f.setFlightName(name);
         f.setFlightOrigin(origin);
         f.setFlightDestination(destination);
         f.setFlightDuration(duratuin);
         f.setTotalSeats(total);
         f.setFlightCost(cost);
        try {
            controller.updateFlight(number, name, origin, destination, duratuin, total, cost);
        } catch (SQLException ex) {
            
        }
    }
    
    public static void main(String[] args) throws SQLException {
        global=Internationalization.getObject();
        ViewFlight v=new ViewFlight();
        controller=new FlightController();
        ResourceBundle english=global.getEnglishBundle();
        ResourceBundle french=global.getFrenchBundle();
        System.out.println("select 1 for English language and 2 for French language");
        Scanner input=new Scanner(System.in);
        int lang=input.nextInt();
        if(lang==1){
            System.out.println("commands: \n 1- Add a flight\n 2- Remove a flight\n 3- Change a flight\n 4- Sort and View the board\n 5- exit");
           enter=english.getString("enter");
            fNum=english.getString("Flight_number");
            fN=english.getString("Flight_name");
            fO=english.getString("Flight_origin");
            fDes=english.getString("Flight_destination");
            fDu=english.getString("Flight_duration");
            fT=english.getString("Total_seats");
            fC=english.getString("Flight_cost");
        }
        else{
            System.out.println(french.getString("commands")+": \n" +" 1- "+french.getString("add")+"\n 2- "+french.getString("remove")+"\n 3- "+french.getString("change")+"\n 4- "+french.getString("sort")+"\n 5- "+french.getString("exit"));
            enter=french.getString("enter");
            fNum=french.getString("Flight_number");
            fN=french.getString("Flight_name");
            fO=french.getString("Flight_origin");
            fDes=french.getString("Flight_destination");
            fDu=french.getString("Flight_duration");
            fT=french.getString("Total_seats");
            fC=french.getString("Flight_cost");
        } 
                int selected=input.nextInt();
        while(selected!=5){
            switch(selected){
                case 1:add(input) ;break;
                case 2:Remove(input);break;
                case 3:changeInfo(input);break;
                case 4:v.viewFlights(lang);break;
            }
            selected=input.nextInt();
        }
        
    }
}