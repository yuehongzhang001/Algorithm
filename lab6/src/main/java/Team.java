/**
 * ACS-2947
 * A class that stores NHL team information
 * @author Yuehong Zhang 3109345 lab6
 */

public class Team implements Comparable<Team>{
    private String city, name;              //Team name
    private int wins, losses, otl, row;     //Team stats

    //Constructor
    public Team (String c, String n, int w, int l, int o, int r){
        city = c;
        name = n;
        wins = w;
        losses = l;
        otl = o;
        row = r;
    }

    /**
     * Calculates total points
     * @return points
     */
    public int points(){
        return 2 * wins + otl;
    }

    /**
     * Calculates number of games played
     * @return games played
     */
    public int gamesPlayed(){
        return wins + losses + otl;
    }

    /**
     * Gets regulation overtime wins
     * @return row
     */
    public int getRow(){
        return row;
    } 
    
    /**
     * Gets team name
     * @return name
     */
    public String getCity(){
        return city;
    } 

    /**
     * Provides the natural ordering: alphabetically by Team name
     * @return int representing ordering between 2 teams
     */    
    public int compareTo(Team t){
        return city.compareTo(t.getCity());  //uses natural ordering of Strings
    }
    
    
    /**
     * Gets the team name
     * @return city + name;
     */
    public String toString() {
        return city + " " + name;
    }    

}
