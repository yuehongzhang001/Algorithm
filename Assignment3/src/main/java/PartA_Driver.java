
/**
 * The diver class to test the program.
 * @author Yuehong Zhang 3109345 
 */
import java.util.Iterator;
import java.util.Scanner;

public class PartA_Driver {
    public static void main(String[] args){
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>(); //create a LinkedBinaryTree object
        System.out.println("This is a advicing program for the membership price of youtube ");
        Position<String> question1 = tree.addRoot("Are you a student? (yes/no)"); //add a root to the tree.
        //add quesiotns to the BinaryTree.
        tree.addLeft(question1, "The price is $6.99 per month for student.");
        Position<String> question2 = tree.addRight(question1, "Do you want to share the membership with your family? (yes/no)");
        tree.addRight(question2,"The price is 11.99 per month");
        Position<String> question3 = tree.addLeft(question2, "Is there at most 5 family members you want to share with? (yes/no)");
        tree.addLeft(question3, "The price for family is $17.99 per month.");
        tree.addRight(question3,"Sorry, you can only share the membership with  at most 5 family members.");
        
        Scanner kb = new Scanner(System.in);//create Scanner object
        Position<String> position = tree.root();
        System.out.println(position.getElement());//display the root quesiton
        //ask questions until reach a external position
        while(tree.isInternal(position)){
            String answer = kb.nextLine().toLowerCase();
            //if user input "yes", go left, or else go right.
            if(answer.equals("yes")){
                position = tree.left(position);
                System.out.println(position.getElement());
            } 
            else
            {
                position = tree.right(position);
                System.out.println(position.getElement());
            }
        }
    }
    
 
}
