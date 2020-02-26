/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class FibonacciProgression extends Progression{
    protected int prev;
    public FibonacciProgression(){this(0,1);}
    public FibonacciProgression(int first,int second){super(first);prev = second-first;}
    
    @Override
    protected void advance(){
        int temp = current;
        current += prev;
        prev = temp;
    }
    
}
