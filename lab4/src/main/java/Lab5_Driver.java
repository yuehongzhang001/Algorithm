
/**
 * ACS-2947-001 Lab 5
 * Driver to test the program
 * @author Yuehong Zhang 3109345 
 */
import java.util.Iterator;

public class Lab5_Driver {

    public static void main(String[] args) {
        PositionalList<Integer> list = new LinkedPositionalList<>();
        int[] temp = {8, 1, 8, 6, 2, 7, 5, 1, 2, 5, 5, 4, 0, 9, 1, 2, 9};
        for (int i : temp) {
            list.addLast(i);
        }
        System.out.println("Original list: \n" + list);

        Iterator<Integer> iter = list.iterator();//create an iterator
        //Iterate through the list and remove thepositions where elements are a 1 or 2.
        while (iter.hasNext()) {
            int n = iter.next();
            if (n == 1 || n == 2) {
                iter.remove();
            }
        }
        System.out.println("Step a - list: \n" + list);//display the list

        //Using the position enhanced for, replace every 4 with 3
        for (Position<Integer> p : list.positions()) {
            if (p.getElement() == 4) {
                list.set(p, 3);//replace the element
            }
        }
        System.out.println("Step b - list: \n" + list);//display the list

        Iterator<Integer> iter1 = list.iterator();//create a new iterator
        if (iter1.hasNext()) {//if this is not an empty list, check it
            int last = iter1.next();//create a variable to store last value
            while (iter1.hasNext()) {
                int current = iter1.next();//create a variable to store current value
                if (current == last) {//if duplicate remove current value
                    iter1.remove();
                }
                last = current;
            }
        }
        System.out.println("Step c - list: \n" + list);//display the list
        
        int sum=0;//create a variable to store the sum
        //Using the element enhanced for, calculate the sum of integer
        for(Integer n:list){
            sum += n;
        }
        System.out.println("Step d - sum of list: \n" + sum);//display the sum of all elements
        System.out.println("list: \n" + list);//display the list

    }
}
