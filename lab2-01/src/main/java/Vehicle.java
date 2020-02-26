
/**
 * This is a simple class to simulate a vehicle.
 * @author Yuehong Zhang 3109345
 */
public class Vehicle {
    private String make;//value to store the make of the vehicle.
    
    //Constructor of Vehicle.
    public Vehicle(String make){
        this.make = make;//initialize make.
    }
    
    /**
     * The accessor method to make.
     * @return make of the Vehicle.
     */
    public String getMake(){
        return make; //make of the Vehicle.
    }
}