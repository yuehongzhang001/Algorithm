/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class ArithmeticProgression extends Progression {
    private int increment;
    public ArithmeticProgression(){this(1,0);}
    public ArithmeticProgression(int stepsize){this(stepsize,0);}
    public ArithmeticProgression(int stepsize,int start){super(start);increment=stepsize;}
    
    
    @Override
    protected void advance(){
        current+=increment;//define the advance as increase by increment value.
    }
}
