

/**
 * Implement concrete Comparator class for comparing Team objects called
 * TeamComparator.
 * @author Yuehong Zhang 3109345 lab6
 */
import java.util.Comparator;
public class TeamComparator implements Comparator<Team>{
    public int compare(Team t1, Team t2){
        
        if(t1.points()!=t2.points())//if total points are not eqaul
            return t2.points()-t1.points();//team with the higher total points is ordered before the other team.
        else if(t1.gamesPlayed()!=t2.gamesPlayed())//if total points equal, but gamesPlayed not equal
            return t1.gamesPlayed()-t2.gamesPlayed();//the one with fewer games played is ordered before the other team.
        else//both total points and gamesPlayed are equal
            return t2.getRow()-t1.getRow();//The team with higher ROW is placed before the other 
    }
    
}
