
/**
 * This class is to simulate a train.
 * @author Yuehong Zhang 3109345
 */
import java.util.ArrayList;//Load ArrayList definition for our use.

public class Train {
    private String name;// the name attribute of the train.
    private ArrayList<Passenger> passengerList;// the ArrayList to store the Passenger objects.
    
    //Constructor of Train.
    public Train(String name){
        this.name = name;//initialize name.
         passengerList = new ArrayList();//initialize passengerList.
    }
    
    /**
     * the accessor method of name.
     * @return name of the Train.
     */
    public String getName(){
        return name;//name of the Train.
    }
    
    /**
     * the method to add a Passenger Object to the list.
     * @param aPassenger the Passenger to be added.
     */
    public void addPassenger(Passenger aPassenger){
        passengerList.add(aPassenger);//add the passenger in the ArrayList passengerList.
    }
    
    //this method will display the passenger list.
    public void displayPassengers(){
       for(Passenger p: passengerList){
           //using a loop to display each passenger's fare type and name.
           System.out.println(p.getFareType()+" "+p.getName());
       }
    }
    
}
