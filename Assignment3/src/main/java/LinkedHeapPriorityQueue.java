
import java.util.Comparator;
import java.util.Iterator;
/**
 * The LinkedHeapPriorityQueue class 
 * @author Yuehong Zhang 3109345
 */
public class LinkedHeapPriorityQueue<K, V> extends AbstractPriorityQueue<K, V>{
    /** primary collection of priority queue entries */
    protected LinkedBinaryTree<Entry<K, V>> heap = new LinkedBinaryTree<>();
    /** Creates an empty priority queue based on the natural ordering of its keys. */
    public LinkedHeapPriorityQueue(){super();}
    /** Creates an empty priority queue using the given comparator to order keys. */
    public LinkedHeapPriorityQueue(Comparator<K> comp){
        super(comp);
    }
    
    /**exchange the entries of two Positions.*/
    protected void swap(Position<Entry<K, V>> p1, Position<Entry<K, V>> p2){
        Entry<K, V> temp = p1.getElement();
        heap.set(p1, p2.getElement());
        heap.set(p2, temp);
    }
    /** Moves the entry at position child higher, if necessary, to restore the heap property. */
    protected void upheap(Position<Entry<K, V>> child){
        while(!heap.isRoot(child)){   // continue until reaching root (or break statement)
            Position<Entry<K, V>> parent = heap.parent(child);
            if(compare(child.getElement(), parent.getElement())>=0) break; //heap property verified
            swap(parent,child);
            child = parent;        // continue from the parent's location
        }
    }
    
    /** Moves the entry at position parent lower, if necessary, to restore the heap property. */
    protected void downheap(Position<Entry<K, V>> parent){
        while(heap.isInternal(parent)){   // continue to bottom (or break statement)
            Position<Entry<K, V>> leftChild = heap.left(parent);
            Position<Entry<K, V>> smallChild = leftChild; //right maybe smaller
            if(heap.right(parent)!=null){ //if right exists
                Position<Entry<K, V>> rightChild = heap.right(parent);
                if(compare(leftChild.getElement(), rightChild.getElement())>0)//compare the left and right
                    smallChild = rightChild;//get the smaller one
            }
            if(compare(parent.getElement(),smallChild.getElement())<=0) break;// heap property has been restored
            swap(parent,smallChild);
            parent = smallChild;// continue at position of the child
        }
    }
    /** Returns the number of items in the priority queue. */
    public int size(){
        return heap.size();
    }
    
    /** Returns (but does not remove) an entry with minimal key (if any). */
    public Entry<K, V> min(){
        if(heap.isEmpty()) return null;
        return heap.root().getElement(); 
    }
 
    /** Inserts a key-value pair and returns the entry created. */
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        checkKey(key); // auxiliary key-checking method (could throw exception)
        Entry<K, V> newest = new PQEntry<>(key, value);
        
        if (isEmpty()) { //if empty, insert at the root
            heap.addRoot(newest);
        } else {
            String binaryString = Integer.toBinaryString(size() + 1);//get the binary string of the position to insert.
            Position<Entry<K, V>> position = heap.root();
            int i = 1;
            //use a for loop to find the parent of the position where we want to insert
            for (; i < binaryString.length() - 1; i++) {
                //if the character is '0', go to the left, if not '0', go to right
                if (binaryString.charAt(i) == '0') {
                    position = heap.left(position);
                } else {
                    position = heap.right(position);
                }
            }
            //add the entry to the tree
            if (binaryString.charAt(i) == '0') {
                position = heap.addLeft(position, newest);
            } else {
                position = heap.addRight(position, newest);
            }
            upheap(position); // upheap newly added entry
        }
        return newest;
    }
    
    /** Removes and returns an entry with minimal key (if any). */
    public Entry<K, V> removeMin() {
        if (heap.isEmpty()) {
            return null;
        }
        Entry<K, V> answer = heap.root().getElement();
        //todo get the last positoin.
        String binaryString = Integer.toBinaryString(size());
        Position<Entry<K, V>> position = heap.root();
        //if there are more than 1 entry, put minimum item at the end
        if (heap.size() > 1) {
            for (int i = 1; i < binaryString.length(); i++) {
                if (binaryString.charAt(i) == '0') {
                    position = heap.left(position);
                } else {
                    position = heap.right(position);
                }
            }
            swap(heap.root(), position); // put minimum item at the end
        }
        heap.remove(position); // remove the minimum item from the BinaryTree;
        if(!heap.isEmpty())
            downheap(heap.root()); // then fix new root
        return answer;
    }
    
    /** The method to convert the object to String */
    public String toString(){
        if(isEmpty()) return "{}";
        StringBuilder sb = new StringBuilder();
        Iterator<Entry<K,V>> iter = heap.iterator();
        sb.append("{" + iter.next());
        while(iter.hasNext()){
            sb.append(", "+iter.next());
        }
        sb.append("}");
        return sb.toString();
    }
    
}
