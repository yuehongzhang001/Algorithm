
/**
 * This is generic SinglyLinkedList class.
 * @author Yuehong Zhang 3109345 
 */
public class SinglyLinkedList<E> {

    //---------------- nested Node class ----------------
    private static class Node<E> {

        private E element; // reference to the element stored at this node
        private Node<E> next; // reference to the subsequent node in the list

        public Node(E e, Node<E> n) {//constructor
            element = e;
            next = n;
        }

        public E getElement() {//access method to return element
            return element;
        }

        public Node<E> getNext() {//access method to return next node
            return next;
        }

        public void setNext(Node<E> n) {// method to update next node
            next = n;
        }
    } //----------- end of nested Node class -----------

    private Node<E> head = null; // head node of the list (or null if empty)
    private Node<E> tail = null; // last node of the list (or null if empty)
    private int size = 0; // number of nodes in the list

    public SinglyLinkedList() {
    } // constructs an initially empty list


    public int size() {// access method to return the list size
        return size;
    }

    public boolean isEmpty() {//method to tell if the list is empty
        return size == 0;
    }

    /**
     * the method to get the first element
     * @return first element
     */
    public E first() { // returns (but does not remove) the first element
        if (isEmpty()) {//if list empty
            return null;// null will be returned
        }
        return head.getElement();//return the first element
    }

    /**
     * the method to get last element
     * @return last element
     */
    public E last() { // returns (but does not remove) the last element
        if (isEmpty()) {//if list empty
            return null;//null will be returned
        }
        return tail.getElement();//return the last element
    }  
// update methods

    public void addFirst(E e) { // adds element e to the front of the list
        head = new Node<>(e, head); // create and link a new node
        if (size == 0) {
            tail = head; // special case: new node becomes tail also
        }
        size++;// size increment
    }

    /**
     * the method to add element to last
     * @param e the element to add
     */
    public void addLast(E e) { // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null); // node will eventually be the tail
        if (isEmpty()) {
            head = newest; // special case: previously empty list
        } else {
            tail.setNext(newest); // new node added after tail
        }
        tail = newest; // new node becomes the tail
        size++;//size increment
    }

    /**
     * the method to remove first element
     * @return the first element removed
     */
    public E removeFirst() { // removes and returns the first element
        if (isEmpty()) {
            return null; // nothing to remove
        }
        E answer = head.getElement();
        head = head.getNext(); // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null; // special case as list is now empty
        }
        return answer;// the removed element
    }
    
    public String toString(){
        if(isEmpty()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> walker = head;
        sb.append(walker.getElement());
        walker = walker.getNext();
        while(walker!=null){
            sb.append(","+walker.getElement());
            walker = walker.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
    
}
