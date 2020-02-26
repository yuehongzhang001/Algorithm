
/**
 * The diver class to test the program.
 * @author Yuehong Zhang 3109345 
 */
import java.util.Iterator;
public class TreeDriver {
    public static void main(String[] args){
        LinkedBinaryTree<String> tree = new LinkedBinaryTree<>(); //create a LinkedBinaryTree object
        Position<String> root = tree.addRoot("Jay"); //add a root to the tree.
        tree.addLeft(root,"Jane"); // add left child to root
        tree.addRight(root,"John");//add right child to root
        displayFamily(tree,root);//call a method to display the tree content
    }
    
    /**
     * The method to display all elements of a simple family tree.
     * @param lbt the LinkedBinaryTree to store elements
     * @param p the root position
     */
    public static void displayFamily(LinkedBinaryTree<String> lbt,Position<String> p){
        System.out.println("Children of "+p.getElement()+":");//display the parent element
        Iterator<Position<String>> posIter = lbt.children(p).iterator(); //get an iterator
        System.out.println(posIter.next().getElement()+" and "+posIter.next().getElement());//use the iterator to get children.
    }
}
