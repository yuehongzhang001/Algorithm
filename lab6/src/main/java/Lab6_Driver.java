import java.util.ArrayList;
import java.util.Collections;

/**
 * ACS-2947 Lab 6
 * @author Yuehong Zhang 3109345
 */

public class Lab6_Driver {

    public static void main(String[] args) {
        TeamComparator comp = new TeamComparator();//create a TeamComparator object.
        ArrayList<Team> teams = new ArrayList();//create an ArrayList object. 

        //add teams to the ArrayList.
        teams.add(new Team("Winnipeg", "Jets", 52, 20, 10, 48));
        teams.add(new Team("Chicago", "Blackhawks", 33, 39, 10, 32));
        teams.add(new Team("Dallas", "Stars", 42, 32, 8, 38)); 
        teams.add(new Team("Nashville", "Predators", 53, 18, 11, 42));                
        teams.add(new Team("Colorodo", "Avalanche", 46, 27, 9, 40));
        teams.add(new Team("Minnessota", "Wild", 45, 26, 11, 41));
        teams.add(new Team("St. Louis", "Blues", 44, 32, 6, 41));
        
        //sort the team using defined TeamComparator.
        Collections.sort(teams, comp);
        System.out.println("Curret Standing:");
        //loop through every elements of arraylist to print its name and points
        for(Team t: teams){
            System.out.println(t+": "+t.points()+" points");
        }

    }  
}
