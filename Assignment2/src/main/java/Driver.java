
/**
 * The Class to simulate the game of Simon.
 * @author Yuehong Zhang 3109345 Assignment 2
 */
import java.util.Random;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) throws InterruptedException{
        int totalScore=0;//total score
        int numberOfColors = 1; //number of colors next round
        while(playNextLevel(numberOfColors)){//play next level till there is a mismatch
            totalScore++;// total score increment
            numberOfColors++;//next level will increase the number of colors
        }
        System.out.println("System: Game over! Your score is "+totalScore);//display the final score
    }
    
    /**
     * The method to get a random color;
     * @return one color from  from red , blue , green, black and yellow.
     */
    public static String getRandomColor(){
        Random generator = new Random();//create a Random object generator
        int randomInteger= generator.nextInt(5); //get a random int from 0 to 5;
        //return a random color from 5 colors according to the random integer.
        switch(randomInteger){
            case 0: return "red";
            case 1: return "blue";
            case 2: return "green";
            case 3: return "black";
            default: return "yellow";
        }
    }
    
    /**
     * The method to start a new level of play
     * @param numberOfColors
     * @return false if there is a mismatch, true if all color matches.
     * @throws InterruptedException 
     */
    public static boolean playNextLevel(int numberOfColors) throws InterruptedException{
        ArrayList<String> systemColors = new ArrayList<>();//ArrayList to store the program’s growing color sequence
        ArrayList<String> userColors = new ArrayList<>();//ArrayList to store user’s input
        //add random colors to ArrayList;
        for(int i=0;i<numberOfColors;i++){
            String randomColor = getRandomColor();//method to get a random color
            systemColors.add(i, randomColor);
        }
        //display system colors
        System.out.println("System: ");
        for(String color: systemColors){// display each color and then clear it briefly
            System.out.print(color);//display the color
            Thread.sleep(1500);
            System.out.print('\b');//clear the word
            Thread.sleep(500);
        }
        System.out.println();
        Scanner kb = new Scanner(System.in);//create a Scanner object for keyboard input
        System.out.print("User: ");
        String inputStr = kb.nextLine();//get user's input
        Scanner input = new Scanner(inputStr);//create a Scanner object for string input
        int k=0;//index of ArrayList for user's color
        while(input.hasNext()){//read color from user's input string until no words left
            userColors.add(k++, input.next());//store the color in ArrayList
        }
        if(systemColors.equals(userColors)) //compare two ArrayList
            return true;//match
        else 
            return false;//unmatched
    }
}
