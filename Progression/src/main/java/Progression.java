/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class Progression {
    protected int current=0;
    public Progression(){}
    public Progression(int start){current=start;}
    public int nextValue(){
        int answer = current;
       advance();
        return answer;
    }
    //current advance to next vaule;
    protected void advance(){
         current++;//increase current by 1
    }
    public void printProgression(int n){
        for(int i=0;i<n;i++){//loop through the progression
            System.out.print(nextValue()+"\t");//display every value
        }
    }

}
