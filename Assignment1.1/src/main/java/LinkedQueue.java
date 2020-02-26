
/**
 * The class to implements queue using SinglyLinkedList
 * @author Yuehong Zhang 3109345 Assignment 1 part B
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();//an empty list
    public LinkedQueue(){} //constructor
    public int size(){return list.size();}//access method to return queue size
    public boolean isEmpty(){return list.isEmpty();}// method to tell if the queue is empty

    @Override
    //override method to add an element to the queue
    public boolean add(E e) throws NullPointerException{
        if(e==null) throw new NullPointerException();//throw exception if add null
        list.addLast(e);//add the element to the last of the list
        return true;// return true when successfully add the elment
    }

    @Override
    //override method to add an element to the queue
    public boolean offer(E e)throws NullPointerException{
        if(e==null)throw new NullPointerException();//throw exception if add null
        list.addLast(e);//add the element to the last of the list
        return true;// return true when successfully add the elment
    }

    @Override
    //override method to remove an element from queue
    public E remove()throws NoSuchElementException  {
        if (isEmpty()) throw new NoSuchElementException("No such element exists!");//no element exists, throw exception
        return list.removeFirst();//return the removed element
    }

    @Override
    //override method to remove an element from the queue
    public E poll() {
        return list.removeFirst();//return the removed element
    }
    

    @Override
    public E element()throws NoSuchElementException {//method to get first element
        if(isEmpty()) throw new NoSuchElementException("No such element exists!");//no element exists, throw exception
        return list.first();//return first element
    }

    @Override
    public E peek() {//method to get first element
        return list.first();//return first element
    }

    //other methods below shall not be supported in this program, and will throw exception if trying to call them
    
    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
