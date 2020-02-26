
/**
 *The ArrayList class implements the List interface.
 * ArrayList dynamic: the array should grow if it runs 
 * out of space and shrink if it is less than half full.
 * 
 * @author Yuehong Zhang 3109345 Assignment 2
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<E> implements List<E>{

    private E[] data;//generic array to store elements
    public static final int DEFAULT_CAPACITY = 4;//default capacity
    private int size = 0;//current number of elements

    /**
     * constructor with default capacity.
     */
    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor to initialize the array with given capacity.
     * @param initialCapacity
     * @throws IllegalArgumentException if initialCapacity is negative
     */
    public ArrayList(int capacity) throws IllegalArgumentException {
        if (capacity < 0)//if a negative initialCapacity 
            throw new IllegalArgumentException("Illegal Capacity: "
                    + capacity);//throw exception and warn.
        data = (E[]) new Object[capacity];//safe cast
    }
    /**
     * Returns the number of elements in the list.
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Tests whether the list is empty.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns (but does not remove) the element at index i.
     * @param i the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is negative or greater
     * than size()-1
     */
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    /**
     * Replaces the element at the specified index, and returns the element
     * previously stored.
     *
     * @param i the index of the element to replace
     * @param e the new element to be stored
     * @return the previously stored element
     * @throws IndexOutOfBoundsException if the index is negative or greater
     * than size()-1
     */
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    /**
     * Inserts the given element at the specified index of the list, shifting
     * all subsequent elements in the list one position further to make room.
     *
     * @param i the index at which the new element should be stored
     * @param e the new element to be stored
     * @throws IndexOutOfBoundsException if the index is negative or greater
     * than size()
     */
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length) {
            resize(data.length * 2);
        }
        for (int k = size - 1; k >= i; k--) {
            data[k + 1] = data[k];
        }
        data[i] = e;
        size++;
    }

    /**
     * Removes and returns the element at the given index, shifting all
     * subsequent elements in the list one position closer to the front.
     *
     * @param i the index of the element to be removed
     * @return the element that had be stored at the given index
     * @throws IndexOutOfBoundsException if the index is negative or greater
     * than size()
     */
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);//check if i valid
        E temp = data[i];//the value to be returned
        for (int k = i; k < size - 1; k++) {//shift elements to fill the hole
            data[k] = data[k+1];
        }
        data[size-1]=null;//help garbage collection
        size--;//size decrement
        if (size < data.length / 2) {//if the size is less than half of the capacity
            resize(data.length/2);//resize the data array.
        }
        return temp;
    }
    
    /**
     * The method to campare to another object.
     * @param other the object to compare
     * @return true if match, false if mismatch.
     */
    public boolean equals(Object other){
        if(other==null)return false; //if null, mismatch.
        if(getClass()!= other.getClass()) return false;//if have different class, mismatch
        ArrayList<E> otherArrayList = (ArrayList<E>) other;//safe cast
        if(size!=otherArrayList.size()) return false;//if have different size, mismatch
        for(int i=0;i<size;i++){//loop through to compare each elements in the ArrayList.
            if(!get(i).equals(otherArrayList.get(i))) return false;//if mismatch return false
        }
        return true;//if reach here, everything matches.
    }

    /**
     * Checks whether the given index is in the range [0, n−1].
     */
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n) {
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }

    /**
     * Method to resize the array
     *
     * @param newCapacity the new length of the array
     * @throws IllegalArgumentException if newCapacity is too small
     */
    protected void resize(int newCapacity) {
        E[] temp = (E[]) new Object[newCapacity];//safe cast
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;//start using the new array.
    }
    
        /**
     * The method to display object as a string
     * @return the string 
     */
    public String toString(){
        if(isEmpty()) return "[]";//if no element return a string with no elements
        StringBuilder sb = new StringBuilder("[");//create a StringBuilder object to append string.
        for(int i=0;i<size-1;i++){
            sb.append(data[i]+",");//append each element and comma excpet last element.
        }
        sb.append(data[size-1]+"]");//append last element
        return sb.toString();//return the final string
    }
   
//------nested ArrayIterator class--------
    /**
     * A (nonstatic) inner class. Note well that each instance contains an implicit 
     * reference to the containing list, allowing it to access the list's members
     */
    public class ArrayIterator implements Iterator<E> {
        private int j = 0;//index of the next element to report
        private boolean removable = false;//can remove be called at this time?
        
        /**
         * Test whether the iterator has a next object.
         * @return true if there are further objects, false otherwise
         */
        @Override
        public boolean hasNext() {
            return j < size; // size is field of outer instance
        }

        /**
         * Returns the next object in the iterator.
         * @return next object
         * @throws NoSuchElementException if there are no futher elements
         */
        @Override
        public E next() throws NoSuchElementException {
            if (j == size) {
                throw new NoSuchElementException("No next element");
            }
            removable = true;//this element can subsequently be removed
            return data[j++];// post-increment j, so it is ready for future call to next
        }

        /**
         *  Removes the element returned by most recent call to next.
         * @throws IllegalStateException if next has not yet been called
         */
        @Override
        public void remove()throws IllegalStateException{
            if(!removable)throw new IllegalStateException("nothing to remove");
            ArrayList.this.remove(j-1); // that was the last one returned
            j--; // next element has shifted one cell to the left
            removable = false; // do not allow remove again until next is called
        }
    }//------------ end of nested ArrayIterator class ------------

    /** Returns an iterator of the elements stored in the list. */
    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();// create a new instance of the inner class
    }

}
