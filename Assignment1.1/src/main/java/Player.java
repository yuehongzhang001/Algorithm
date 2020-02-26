
/**
 * This is a Player class that stores the player name and score information.
 * @author Yuehong Zhang 3109345 Assignment 1 part A
 */

public class Player {
    private String name; //name of the player
    private int score = 0;//score of the player
    
    public Player(String n){//constructor
        name = n;
    }
    /**
     * This method return player's scores
     * @return player's score
     */
    public int getScore(){return score;}//method to return score
    
    /**
     * The method to set score
     * @param s new score to set
     * @throws IllegalArgumentException 
     */
    public void setScore(int s)throws IllegalArgumentException{
        if(s<0)//s is negative throw an IllegalArgumentException
            throw new IllegalArgumentException("The score can't be negative!");
        score = s;//set the score to new value
    }
    /**
     * The method to get player's name
     * @return player's name
     */
    public String getName(){
        return name;//return player's name
    }
    
    /**
     * The method to return player's information as String
     * @return the name and the score of player
     */
    public String toString(){return name+"'s score: "+score;}//return player's name and score in String
}
