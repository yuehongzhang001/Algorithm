/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is DynamicArray class to use a static array to simulate a dynamic array.
 * @author Yuehong Zhang 3109345 Lab 3
 */
import java.util.Arrays;

public class DynamicArray<E> {
    private Object[] array;//generic array to store elements
    private static final Object[] EMPTY_ELEMENTDATA = {};//empty array for no argument constructor.
    private int size = 0;//initial size is 0
    
    //no argument constructor
    public DynamicArray(){
        array = EMPTY_ELEMENTDATA;//initialize array to be empty;
    }
    /**
     * Constructor to initialize the array with given capacity.
     * @param initialCapacity
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public DynamicArray(int initialCapacity)throws IllegalArgumentException{
        if (initialCapacity < 0)//if a negative initialCapacity 
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);//throw exception and warn.
        array = new Object[initialCapacity];//initialize array with initialCapacity
    }
        
    /**
     * Method to add an element to the back of the DynamicArray
     * @param element to add
     * @return true if successfully added.
     */
    public boolean add(E element){
        if(size==array.length){//if capacity is full
            if(size==0) //if size is 0
                resize(1);//resize the array length with 1
            else
                resize(array.length*2);//double length of the array.
        }
            array[size++] = element;// add the element to the back
            return true;//add successfully
    }
    
    /**
     * Method to add an element to certain position.
     * @param index the position to add element
     * @param element to add
     * @throws IndexOutOfBoundsException if index 
     */
    public void add(int index,E element)throws IndexOutOfBoundsException{
        if(index<0 || index>=size) // if an illegal index
            throw new IndexOutOfBoundsException();//throw exception and warn
        if(size==array.length){//if capacity is full
            if(size==0) //if size is 0
                resize(1);//resize the array length with 1
            else
                resize(array.length*2);//double length of the array.
        }
        size++;//increment of size
        //shift 1 index to the right
        for(int i=size-1;i>index;i--){//loop from last index to the index we want to add element
            array[i] = array[i-1];//copy each value from its left element
        }
        array[index] = element;//put the element to the index 
    }
    
    //Method to access the size of DynamicArray
    public int size(){return size;}
    
    //Method to access the capacity of DynamicArray
    public int getCapacity(){return array.length;}
    
    /**
     * Method to remove element at an index
     * @param index the position of the element we want to remove
     * @return the element removed
     */
    public E remove(int index){
        if(index < 0 ||index >= size())//if index if out of bounds
            throw new IndexOutOfBoundsException();//throw exception and warn
        E answer = (E)array[index];//the removed element
        for(int i=index; i<size-1;i++){//loop from the given index to the last index
            array[i]=array[i+1];//copy each value from right element
        }
        array[size-1]=null;// set the element at last index to null for garbage colletion.
        size--;//decrement of size
        if(size<array.length/2){//if the element is less than half of capacity
            resize(array.length/2);//cut half the capacity
        }
        return answer;//return the removed element
    }
    
    /**
     * The method to remove given object
     * @param o the object to remove
     * @return true if the object is found and removed
     */
    public boolean remove(Object o){
        for(int i=0;i<size;i++){//loop through all the existing elements
            if(array[i].equals(o)){//if the object is found
                remove(i);//remove the element at index i
                return true;// removed successfully
            }   
        }
        return false;//not removed.
    }
    
    /**
     * Method to resize the array
     * @param newCapacity the new length of the array
     * @throws IllegalArgumentException if newCapacity is too small
     */
    public void resize(int newCapacity)throws IllegalArgumentException{
        if(size>newCapacity){//if newCapacity  smaller than existing number of elements
            throw new IllegalArgumentException("This new capacity is too small for all data!");
        }else{
            array = Arrays.copyOf(array, newCapacity);//set array to point to a array with newCapacity .
        }
    }
    
    /**
     * Method to convert the DynamicArray to string
     * @return the string of DynamicArray information
     */
    public String toString(){
        return Arrays.toString(array);//the string of DynamicArray information
    }
  
}
