

/**
 * The AbstractBinaryTree class
 * @author Yuehong Zhang 3109345 
 */
import java.util.List;
import java.util.ArrayList;
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> 
                                            implements BinaryTree<E>{
    
    /** Returns the Position of p's sibling (or null if no sibling exists). */
    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);
        if(parent==null) return null;  //p must be the root
        if(p==left(parent))             // p is a left child
            return right(parent);       //(right child might be null)
        else                            //p is a right child
            return left(parent);        //(left child might be null)
    }
    
    /** Returns the number of children of Position p. */
    public int numChildren(Position<E> p){
        int count=0;
        if(left(p)!=null)
            count++;
        if(right(p)!=null)
            count++;
        return count;
    }
    
    /** Returns an iterable collection of the Positions representing p's children. */
    public Iterable<Position<E>> children(Position<E> p){
        List<Position<E>> snapshot = new ArrayList<>(2);  //maxt capacity of 2
        if(left(p)!=null)
            snapshot.add(left(p));
        if(right(p)!=null)
            snapshot.add(right(p));
        return snapshot;
    }
}
