/**
 * The driver class to test the program
 * @author Yuehong Zhang 3109345
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
public class Lab7 {
    public static void main(String[] args){
        // create an ArrayList to hold the sample data
        ArrayList<String> list = new ArrayList<>();
        //add all sample data
        list.add("logarithm");
        list.add("elvis");
        list.add("canoe");
        list.add("algorithm");
        list.add("lives");
        list.add("freedom");
        list.add("ocean");
        list.add("veils");
        list.add("dobby");
        
        //call the findAnagrams method to get all the anagram groups.
        ArrayList<ArrayList<String>> groupedAnagrams = findAnagrams(list);
        //display the result
        System.out.print(groupedAnagrams);
    }
    
    //*The mothed to return anagrams found.*//
    public static ArrayList<ArrayList<String>> findAnagrams(List<String> list){
        //create an ArrayList to hold the groups.
        ArrayList<ArrayList<String>> groups = new ArrayList<>();
        //create an map to hold the words with same key.
        Map<String, ArrayList<String>> map = new ProbeHashMap<>();
        //loop through every word in the input list to add into the Map object
        for(String s: list){
            //convert the string to char array
            char[] chars = s.toCharArray();
            Arrays.sort(chars);//sort the array
            
            //use a StringBuilder Object to convert the sorted char array to String.
            StringBuilder sb = new StringBuilder();
            for(char c: chars){
                sb.append(c);
            }
            //now we get the key
            String key = sb.toString();
            
            if(map.get(key)==null){//if the key not exist int the map
                ArrayList<String> value = new ArrayList<>();//create an ArrayList as value
                value.add(s);//add the word in it
                map.put(key, value);//put the key and the value into the map
            }else{//if the key exist
                map.get(key).add(s);//get the value and add the word into the value.
            }
        }
        
        
        for(ArrayList<String> stringlist: map.values()){//loop through the map values
            if(stringlist.size()>=2)//find the value with at least two word in it.
                groups.add(stringlist);//add that value to our groups list.
        }
        
        return groups;//return the groups list.
    }
}
