

/**
 * This is LinkedPositionalList that implements PositionalList interface and has
 * nested Node class which implements Position interface.
 *
 * @author Yuehong Zhang 3109345 Lab 5
 */
/** Implementation of a positional list stored as a doubly linked list. */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements PositionalList<E> {

    //---------------- nested Node class ----------------

    private static class Node<E> implements Position<E> {
        private E element; // reference to the element stored at this node
        private Node<E> prev; // reference to the previous node in the list
        private Node<E> next; // reference to the subsequent node in the list

        //the constructor
        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        //method to get the element in the node
        public E getElement() throws IllegalStateException {
            if (next == null) // convention for defunct node
            {
                throw new IllegalStateException("Position no longer valid");
            }
            return element;
        }

        //method to get previous node
        public Node<E> getPrev() {
            return prev;
        }

        //method to get next node
        public Node<E> getNext() {
            return next;
        }

        //method to set element in the node
        public void setElement(E e) {
            element = e;
        }

        //set previous node as a new node
        public void setPrev(Node<E> p) {
            prev = p;
        }

        //set next node as a new node
        public void setNext(Node<E> n) {
            next = n;
        }
    } //----------- end of nested Node class -----------

    // instance variables of the LinkedPositionalList
    private Node<E> header; // header sentinel
    private Node<E> trailer; // trailer sentinel
    private int size = 0; // number of elements in the list

    /**
     * Constructs a new empty list.
     */
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        // create header
        trailer = new Node<>(null, header, null); // trailer is preceded by header
        header.setNext(trailer); // header is followed by trailer
    }
    // private utilities

    /**
     * Validates the position and returns it as a node.
     */
    private Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Invalid p");
        }
        Node<E> node = (Node<E>) p; // safe cast
        if (node.getNext() == null) // convention for defunct node
        {
            throw new IllegalArgumentException("p is no longer in the list");
        }
        return node;
    }

    /**
     * Returns the given node as a Position (or null, if it is a sentinel).
     */
    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) {
            return null; // do not expose user to the sentinels
        }
        return node;
    }
    // public accessor methods

    /**
     * Returns the number of elements in the linked list.
     */
    public int size() {
        return size;
    }

    /**
     * Tests whether the linked list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the first Position in the linked list (or null, if empty).
     */
    @Override
    public Position<E> first() {
        return position(header.getNext());
    }

    /**
     * Returns the last Position in the linked list (or null, if empty).
     */
    @Override
    public Position<E> last() {
        return position(trailer.getPrev());
    }

    /**
     * Returns the Position immediately before Position p (or null, if p is
     * first).
     */
    public Position<E> before(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);

        return position(node.getPrev());
    }

    /**
     * Returns the Position immediately after Position p (or null, if p is
     * last).
     */
    public Position<E> after(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return position(node.getNext());
    }

    // private utilities
    /**
     * Adds element e to the linked list between the given nodes.
     */
    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ); // create and link a new node
        pred.setNext(newest);
        succ.setPrev(newest);
        size++;
        return newest;
    }
    // public update methods

    /**
     * Inserts element e at the front of the linked list and returns its new
     * Position.
     */
    public Position<E> addFirst(E e) {
        return addBetween(e, header, header.getNext()); // just after the header
    }

    /**
     * Inserts element e at the back of the linked list and returns its new
     * Position.
     */
    public Position<E> addLast(E e) {
        return addBetween(e, trailer.getPrev(), trailer); // just before the trailer
    }

    /**
     * Inserts element e immediately before Position p, and returns its new
     * Position.
     */
    public Position<E> addBefore(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node.getPrev(), node);
    }

    /**
     * Inserts element e immediately after Position p, and returns its new
     * Position.
     */
    public Position<E> addAfter(Position<E> p, E e)
            throws IllegalArgumentException {
        Node<E> node = validate(p);
        return addBetween(e, node, node.getNext());
    }

    /**
     * Replaces the element stored at Position p and returns the replaced
     * element.
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException {
        Node<E> node = validate(p);
        E answer = node.getElement();
        node.setElement(e);
        return answer;
    }

    /**
     * Removes the element stored at Position p and returns it (invalidating p).
     */
    public E remove(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);//validate the postion
        Node<E> predecessor = node.getPrev();//get previous node
        Node<E> successor = node.getNext();//get next node
        predecessor.setNext(successor);//set next node
        successor.setPrev(predecessor);//set previous node
        size--;//size decrement
        E answer = node.getElement();//get the answer we need
        node.setElement(null); // help with garbage collection
        node.setNext(null); // and convention for defunct node
        node.setPrev(null);

        return answer;
    }

    /**
     * Method to convert all the list contents to string
     *
     * @return the list contents
     */
    public String toString() {
        StringBuilder sb = new StringBuilder("(");//create a StringBuilder object to add string
        Node<E> walk = header.getNext();//get the first element
        while (walk != trailer) {//loop until the trailer
            sb.append(walk.getElement());//append new element to StringBuilder object
            walk = walk.getNext();//get next element
            if (walk != trailer) {
                sb.append(", ");//append a comma after each element except the last one
            }
        }
        sb.append(")");//finish of the string
        return sb.toString();
    }

    //---------------- nested PositionIterator class ----------------
    private class PositionIterator implements Iterator<Position<E>> {

        private Position<E> cursor = first(); // position of the next element to report
        private Position<E> recent = null; // position of last reported element

        /**
         * Tests whether the iterator has a next object.
         */
        public boolean hasNext() {
            return (cursor != null);
        }

        /**
         * Returns the next position in the iterator.
         */
        public Position<E> next() throws NoSuchElementException {
            if (cursor == null) {
                throw new NoSuchElementException("nothing left");
            }
            recent = cursor; // element at this position might later be removed
            cursor = after(cursor);
            return recent;
        }

        /**
         * Removes the element returned by most recent call to next.
         */
        public void remove() throws IllegalStateException {
            if (recent == null) {
                throw new IllegalStateException("nothing to remove");
            }
            LinkedPositionalList.this.remove(recent); // remove from outer list
            recent = null; // do not allow remove again until next is called
        }
    } //------------ end of nested PositionIterator class ------------

    //---------------- nested PositionIterable class ----------------
    private class PositionIterable implements Iterable<Position<E>> {

        public Iterator<Position<E>> iterator() {
            return new PositionIterator();
        }
    } //------------ end of nested PositionIterable class ------------
    
      /**
     * Returns an iterable representation of the list's positions.
     * @return a PositionIterable object
     */
    public Iterable<Position<E>> positions() {
        return new PositionIterable(); // create a new instance of the inner class
    }
  

    //---------------- nested ElementIterator class ----------------
    /* This class adapts the iteration produced by positions() to return elements. */
    private class ElementIterator implements Iterator<E> {

        Iterator<Position<E>> posIterator = new PositionIterator();

        public boolean hasNext() {
            return posIterator.hasNext();
        }

        public E next() {
            return posIterator.next().getElement();
        } // return element!

        public void remove() {
            posIterator.remove();
        }
    }
    
    /**
     * The method to return an iterator of the elements stored in the list. 
     * @return an ElementIterator;
     */
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

}
