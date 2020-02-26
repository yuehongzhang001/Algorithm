/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class CompositProgression extends Progression{
    private int increment;
    private int base;
    public CompositProgression(){this(1,1,0);}
    public CompositProgression(int b,int stepsize){this(b,stepsize,0);}
    public CompositProgression(int b,int stepsize,int start){
        super(start);
        base = b;
        increment = stepsize;
    }
    @Override
    protected void advance(){
        current = current*base + increment;
    }
}
