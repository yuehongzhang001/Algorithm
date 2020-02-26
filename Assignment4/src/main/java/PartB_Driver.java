
/**
 * The Driver to test the program
 * @author Yuehong Zhang 3109345
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class PartB_Driver {
    public static void main(String[] args) throws FileNotFoundException{
        //create ALChainHashMap Object
        ALChainHashMap<String,Order> hashmap = new ALChainHashMap<>();
        Scanner input = new Scanner(new File("PartB.txt"));
        //get the order info line by line, create Order Object, and put it in the hashmap
        while(input.hasNextLine()){
            String line = input.nextLine();
            String[] strs = line.split(" ");
            String orderID = strs[0];
            String customerID = strs[1];
            double amount = Double.parseDouble(strs[2]);
            Order order = new Order(orderID,customerID,amount);
            hashmap.put(orderID, order);
        }
        //display the number of orders
        System.out.println("Number of orders:"+hashmap.size());
        //display the number of collisions
         System.out.println("The number of collisions that occured in the hashmap:"+hashmap.numCollisions());
        //display the list of orders
         System.out.println("List of orders:");
        for(Order order: hashmap.values()){
            System.out.println(order);
        }
    }
    
}
