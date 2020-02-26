
/**
 * This class is used to create and display pair objects. 
 * @author Yuehong Zhang 3109345
 */
import javafx.util.Pair;//Load Pair definition for our use.
import java.util.ArrayList;//Load ArrayList definition for our use.

public class Driver {
    
    public static void main(String[] args){
        //Store a pair of objects that consists of a Vehicle object and an integer that represents motor size.
        Pair<Vehicle, Integer> pair1 = new Pair(new Vehicle("BMW"),3); 
        System.out.println("The type of the vehicle is " + pair1.getKey().getMake());//Display the type of vehicle.
        System.out.println("The motor size of the vehicle is "+pair1.getValue());//Display motor size.
        
        //Create an ArrayList that holds Pairs of string and integer objects.
        ArrayList<Pair<String, Integer>> list = new ArrayList();
        list.add(new Pair<String, Integer>("Str1",1));//add a new pair of string and integer objects.
        list.add(new Pair<String, Integer>("Str2",2));//add a new pair of string and integer objects.
        list.add(new Pair<String, Integer>("Str3",3));//add a new pair of string and integer objects.
        //Display the contents of list.
        System.out.println("Contents of list: ");
        for(Pair<String, Integer> element: list){
            //use a for loop to display each pair.
            System.out.println(element.getKey()+" "+element.getValue());
        }
    }
    
    
}
