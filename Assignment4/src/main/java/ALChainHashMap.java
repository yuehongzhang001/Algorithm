import java.util.ArrayList;
/**
 * ACS-2947 As4 Part B
 * @author Yuehong Zhang 3109345
 */
public class ALChainHashMap<K,V> extends AbstractHashMap<K,V> {
    
    private ArrayList<MapEntry<K,V>>[] table;
    
    public ALChainHashMap() {
        super();
    }
    
    public ALChainHashMap(int cap) {
        super(cap);
    }
    
    public ALChainHashMap(int cap, int p) {
        super(cap, p);
    }

    protected void createTable() {
        table = (ArrayList<MapEntry<K,V>>[])new ArrayList[capacity];
    }
    
    /**
     * Return the value in bucket.
     */
    protected V bucketGet(int h, K k) {
        ArrayList<MapEntry<K,V>> bucket = table[h];       
        if (bucket == null) 
            return null;        
        for (MapEntry<K,V> entry : bucket) 
            if (entry.getKey().equals(k))
                return entry.getValue();
        return null;
    }
	
	
    /**
     * Associates key k with value v in bucket with hash value h; returns old
     * value.
     */
    protected V bucketPut(int h, K k, V v) {
        ArrayList<MapEntry<K,V>> bucket = table[h];
        if (bucket == null) {
            bucket = table[h] = new ArrayList<>();
        }
        int oldSize = bucket.size();
        int j= findIndex(bucket,k);
        V answer;
        if (j == -1) {
            bucket.add(new MapEntry<>(k, v)); // add new entry
            answer = null;
        } else // key already exists
            answer = bucket.get(j).setValue(v);
        
        n += (bucket.size() - oldSize); // size may have increased
        return answer;
    }

    /**
     * Removes entry having key k from bucket with hash value h (if any).
     */
    protected V bucketRemove(int h, K k) {
        ArrayList<MapEntry<K,V>>  bucket = table[h];
        if (bucket == null) {
            return null;
        }
        int oldSize = bucket.size();
        V answer;
        int j= findIndex(bucket,k);
        if (j == -1) {
            answer = null;
        } else {// key already exists
            answer = bucket.get(j).getValue();
            if (j != bucket.size() - 1)
                bucket.set(j, bucket.get(bucket.size()-1)); // relocate last entry to ’hole’ created by removal
            bucket.remove(bucket.size()-1).getValue(); // remove last entry of table
        }
            
        n -= (oldSize - bucket.size()); // size may have decreased
        return answer;
    }

    /**
     * Returns an iterable collection of all key-value entries of the map.
     */
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> buffer = new ArrayList<>();
        for (int h = 0; h < capacity; h++) {
            if (table[h] != null) {
                for (Entry<K, V> entry : table[h]) {
                    buffer.add(entry);
                }
            }
        }
        return buffer;
    }

    /**
     * Return the number of collisions
     */
    public int numCollisions(){
        int num = 0;
        for (int h = 0; h < capacity; h++) {
            if (table[h] != null) {
                if(table[h].size()>1)
                    num++;
            }
        }
        return num;
    }
    
    /**
     * Method to help find the index of the key in an ArrayList bucket.
     */
    private int findIndex(ArrayList<MapEntry<K, V>> bucket, K key) {
        int n = bucket.size();
        for (int j = 0; j < n; j++) {
            if (bucket.get(j).getKey().equals(key)) {
                return j;
            }
        }
        return -1; // special value denotes that key was not found
     }
	
    //Method to convert the Object to String
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Entry<K,V> e: entrySet()){
            sb.append(e+"\n");
        }
        return sb.toString();
    }
	
	
}