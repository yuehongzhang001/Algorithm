
/**
 * The Driver to test the program
 * @author Yuehong Zhang 3109345
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartA_Driver {
    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner input = new Scanner(new File("PartA.txt"));
        Map<String, Integer> map = new ProbeHashMap<>();//create a Map
        while(input.hasNext()){
            String word = input.next();//get next word
            word = word.replaceAll("[^a-zA-Z']+", "").toLowerCase();//delete the punctuation and convert all letters to lower case
            Integer frequency = map.get(word);//get the frequency of the word
            if(frequency==null){//if not in the map yet
                map.put(word, 1);//put that word in the Map and set frequency as 1.
            }else{//if already exist
                map.put(word, ++frequency);//increment the frequency and put it in the map
            }
        }
        int i=0;
        //create Array to store all the entries
        Entry<String, Integer>[] entries = (Entry<String, Integer>[])new Entry[map.size()];
        //add all entries.
        for(Entry<String, Integer> e:map.entrySet()){
            entries[i++]=e;
        }
        //create MergeSort Object to sort the Array
        MergeSort mergeSort = new MergeSort(entries);
        //display top ten
        for(int j=0;j<10;j++){
            System.out.println(entries[j]);
        }
    }
}
