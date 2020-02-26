/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class GeometricProgression extends Progression {
    protected int base;
    public GeometricProgression(){this(2,1);}
    public GeometricProgression(int b){this(b,1);}
    public GeometricProgression(int b,int start){super(start);base = b;}
    @Override
    protected void advance(){
        current *= base;
    }
}
