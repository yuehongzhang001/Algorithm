
/**
 * The driver class to test two questions
 * @author Yuehong Zhang 3109345 Lab 3
 */
public class Lab3_driver {

    public static void main(String[] args) {
        //*******this is to test question 1************
        //Create an instance of LinkedPositionalList to hold integers
        System.out.println("1. Linked positional lists************************************");
        LinkedPositionalList<Integer> positionalList = new LinkedPositionalList<>();
        for (int i = 1; i <= 20; i++) {//loop for 20 times
            positionalList.addLast(i);//add integer to the list
        }
        
        Position<Integer> cursor = positionalList.first();//Use variable cursor to point to first position
        System.out.println("i.Declare a variable named cursor and assign it to the first item in the list.");//output the first step
        System.out.println("List content:"+positionalList.toString());// display list content
        System.out.println("Cursor element:"+cursor.getElement());//display element in cursor
        
        for (int i = 0; i < 9; i++) {//loop for 9 times
            cursor = positionalList.after(cursor);//Move the cursor to the 10th position 
        }
        System.out.println("ii.Move the cursor to the 10th position in the list, "
                + "i.e. the cursor should hold the position that references 10.");//output the second step
        System.out.println("List content:"+positionalList.toString());// display list content
        System.out.println("Cursor element:"+cursor.getElement());//display element in cursor
        
        positionalList.addBefore(cursor, 8);//add the number 8 before the cursor 
        positionalList.addAfter(cursor, 2);//add the number 2 after the cursor
        System.out.println("iii.Add the number 8 before the cursor and the number 2 after the cursor.");//output the third step
        System.out.println("List content:"+positionalList.toString());// display list content
        System.out.println("Cursor element:"+cursor.getElement());//display element in cursor
        
        for (int i = 0; i < 5; i++) {//loop for 5 times
            cursor = positionalList.after(cursor);//move the cursor backward 5 positions
        }
        System.out.println("iv.Move the cursor backward 5 positions.");//output the fourth step
        System.out.println("List content:"+positionalList.toString());// display list content
        System.out.println("Cursor element:"+cursor.getElement());//display element in cursor
        
        System.out.println("v.Change the number after the cursor to 0. Delete the item before the cursor.");//output the fifth step
        positionalList.set(positionalList.after(cursor), 0);//Change the number after the cursor to 0.
        positionalList.remove(positionalList.before(cursor));//Delete the item before the cursor.
        System.out.println("List content:"+positionalList.toString());// display list content
        System.out.println("Cursor element:"+cursor.getElement());//display element in cursor

        //*******this is to test question 2************
        System.out.println("\n\n2. Dynamic arrays************************************");//display second question test
        
        //display the outcome when creating DynamicArray with no initial capacity
        System.out.println("------------Create DynamicArray with no initial capacity-------------");
        DynamicArray<Integer> dArray = new DynamicArray<>();//create DynamicArray with no argument constructor
        System.out.println(dArray.toString() + "Capacity: " + dArray.getCapacity());//display DynamicArray content and capacity
        
        //display the outcome when adding elements(auto grow)
        System.out.println("------------Adding elements(auto grow)-------------");
        for (int i = 0; i < 16; i++) {//loop 16 times
            dArray.add(i);//add 0-16 into the DynamicArray
            System.out.println(dArray.toString() + "Capacity: " + dArray.getCapacity());//display DynamicArray content and capacity
        }
        
         //display the outcome when removing elements(auto shrink)
        System.out.println("------------Removing elements(auto shrink)-------------");
        for (int i = 0; i < 16; i++) {//loop 16 times
            dArray.remove(0);//remove the element at index 0 every time
            System.out.println(dArray.toString() + "Capacity: " + dArray.getCapacity());//display DynamicArray content and capacity
        }
        
        //display the outcome when creating DynamicArray with initial capacity
        System.out.println("------------Create DynamicArray with initial capacity-------------");
        dArray = new DynamicArray<>(6);//create DynamicArray with given capacity argument
        System.out.println(dArray.toString() + "Capacity: " + dArray.getCapacity());//display DynamicArray content and capacity
        for(int i=0;i<16;i++){//loop for 16 times
            dArray.add(i);//add 0-16 into the DynamicArray
            System.out.println(dArray.toString() + "Capacity: " + dArray.getCapacity());//display DynamicArray content and capacity
        }
        
        //display the outcome when manually resize the capacity(increase)
        System.out.println("----------Manual resize the capacity(increase)--------------");
        dArray.resize(30);//resize the DynamicArray to 30
        System.out.println(dArray.toString() + "Capacity: " + dArray.getCapacity());//display DynamicArray content and capacity
        
        ////display the outcome when manually resize the capacity(decrease)
        System.out.println("----------Manual resize the capacity(decrease)--------------");
        dArray.resize(16);//resize the DynamicArray to 16
        System.out.println(dArray.toString() + "Capacity: " + dArray.getCapacity());//display DynamicArray content and capacity
    }
}
