package DataStructure;
import MVC.Flight;
public class LinkedList {
    protected Node head;
    protected Node first;
    

    boolean check(int id){
        if(head==null)
            return false;
        Node node=new Node();
        node=head;
        while(node!=null){
            if(node.ID==id)
                return true;
            node=node.next;
        }
        return false;
    }
    
    public int getLength(){
        int length=0;
        Node current=head;
        if(current==null){
            return 0;
        }
        else{
            while(current!=null){
                length++;
                current=current.next;
            }        
        }
        return length;
    }
    
    public Flight [] toArray(){
        LinkedList list=this;
        int index=0;
        Flight [] flights=new Flight[list.getLength()];
        Node current=head;
        while(current!=null){
            Flight f=new Flight();
            f.setFlightNumber(current.ID);
            f.setFlightName(current.flightName);
            f.setFlightDuration(current.flightDuration);
            f.setFlightOrigin(current.flightOrigin);
            f.setFlightDestination(current.flightDestination);
            f.setTotalSeats(current.totalSeats);
            f.setFlightCost(current.flightCost);
            flights[index]=f;
            index++;
            current=current.next;
            } 
        return flights;
    }
    //insert
    public void insert(Flight f){
        if(check(f.getFlightNumber())){
            System.out.println("Flight is already exist");
            return;
        }
        Node node=new Node();
        node.ID=f.getFlightNumber();
        node.flightName=f.getFlightName();
        node.flightOrigin=f.getFlightOrigin();
        node.flightDestination=f.getFlightDestination();
        node.flightDuration=f.getFlightDuration();
        node.totalSeats=f.getTotalSeats();
        node.flightCost=f.getFlightCost();
        node.next=null;
        
        //insert at first
        if(head==null||head.ID>=node.ID){
            node.next=head;
            head=node;
        }
        
        //insert at middle or end of linked list
        else{
            Node current=head;
            while(current.next!=null&&current.next.ID<node.ID){
                current=current.next;
            }
            node.next=current.next;
            current.next=node;
        }
        
    }
    
    //search by ID
    public Node search(int ID){
        Node current=head;
        if(head==null){
            System.out.println("Flight not found");
            return null;
        }
        else{
            try{   
                while(current.next!=null){
                    if(current.ID==ID){
                        return current;                 
                    }
                    current=current.next;
                }
            } catch(NullPointerException e){
                System.out.println("Flight not found");
            }     
        }
        return current;
    }
    
    //delete
    public int delete(int ID){
        Node node=head;
        Node current=null;
        
        //delete at first
        if(node!=null&&node.ID==ID){
            head=node.next;
            return 0;
        }
        
        //Otherwise
        while(node!=null && node.ID!=ID){
            current=node;
            node=node.next;
        }
        if(node==null){
            System.out.println("Flight not exist");
            return -1;
        }
        else{
            current.next=node.next;
            return 0;
        }
    }
    public boolean compare(LinkedList list){
        Node h1=list.head;
        Node h2=this.head;
        if(h1.next==h2.next&&h1.next.next==null&&h2.next.next==null){
            return true;
        }
        return false;
    }

}
