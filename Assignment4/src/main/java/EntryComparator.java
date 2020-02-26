/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *  The EntryComparator class
 * @author Yuehong Zhang 3109345
 */
import java.util.Comparator;
public class EntryComparator implements Comparator<Entry>{
    
    public int compare(Entry e1,Entry e2)throws ClassCastException{
        return ((Comparable) e1.getValue()).compareTo(e2.getValue());
    }
}
