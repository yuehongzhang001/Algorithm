/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
class MyAddress {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class MyAddress implements Cloneable {
    private String city;
    private String street;
    public MyAddress(String c,String s){
        city = c;
        street = s;
    }
    public MyAddress clone()throws CloneNotSupportedException{
        return (MyAddress)super.clone();
    }
}

}
