/**
 * This class is used to test the code. 
 * Add several passengers to the buslist.
 * Add a method called displayPassengers that lists the names of those passe.
 * Display the bus name and passenger list.
 * @author Yuehong Zhang 3109345
 */
public class Travel {
    
    public static void main(String[] args){
        Train train = new Train("North PoleExpress");//create a train object.
        train.addPassenger(new Person("Krissy","Kringle",11));//add a passenger to passenger list
        train.addPassenger(new Person("Frosty","Snowman",15));//add a passenger to passenger list
        train.addPassenger(new Person("Jack","Frost",68));//add a passenger to passenger list
        train.addPassenger(new Person("E.","Bunny",30));//add a passenger to passenger list
        System.out.println("Train name: "+ train.getName());//display train name.
        System.out.println("Passengers:");//display "Passengers:".
        displayPassengers(train);//call the displayPassengers method to show the list.
    }
    
    /**
     * This method will show a train's passenger list.
     * @param train The Train object to show it's passenger list.
     */
    public static void displayPassengers(Train train){
        train.displayPassengers();//call train's method to show the passenger list.
    }
}
