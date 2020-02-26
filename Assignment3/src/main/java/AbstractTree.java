
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * The AbstractTree class which implements Tree interface.
 * @author Yuehong Zhang 3109345 
 */
public abstract class AbstractTree<E> implements Tree<E> {
    public boolean isInternal(Position<E> p){return numChildren(p)>0;}
    public boolean isExternal(Position<E> p){return numChildren(p)==0;}
    public boolean isRoot(Position<E> p){return p==root();}
    public boolean isEmpty(){return size()==0;}
     //-------nested ElementIterator class-------------
    /* This class adapts the iteration produced by positions() to return elements. */
    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext(){return posIterator.hasNext();}
        public E next(){return posIterator.next().getElement();}
        public void remove(){posIterator.remove();}
    }//------end of nested class------
    
    /**this method will return an ElementIterator*/
    public Iterator<E> iterator(){return new ElementIterator();}

    
     /** Adds positions of the subtree rooted at Position p to the given snapshot. */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);//for preorder, we add position p before exploring subtrees
        for(Position<E> c:children(p))
            preorderSubtree(c, snapshot);
    }
    
    /** Returns an iterable collection of positions of the tree, reported in preorder. */
    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty())
            preorderSubtree(root(),snapshot); // fill the snapshot recursively
        return snapshot;
    }
    
    /**
     * Adds positions of the subtree rooted at Position p to the given snapshot.
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
        for (Position<E> c : children(p)) {
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p); // for postorder, we add position p after exploring subtrees
    }

    /**
     * Returns an iterable collection of positions of the tree, reported in
     * postorder.
     */
    public Iterable<Position<E>> postorder() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            postorderSubtree(root(), snapshot); // fill the snapshot recursively
        }
        return snapshot;
    }
    
    /**
     * Returns an iterable collection of positions of the tree in breadth-first
     * order.
     */
    public Iterable<Position<E>> breadthfirst() {
        List<Position<E>> snapshot = new ArrayList<>();
        if (!isEmpty()) {
            Queue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root()); // start with the root
            while (!fringe.isEmpty()) {
                Position<E> p = fringe.dequeue(); // remove from front of the queue
                snapshot.add(p); // report this position
                for (Position<E> c : children(p)) {
                    fringe.enqueue(c); // add children to back of queue
                }
            }
        }
        return snapshot;
    }
    
    /**Returns an Iterable collection of positions of the tree, using breadthfirst method*/
    public Iterable<Position<E>> positions(){
        return breadthfirst();
    }
}
