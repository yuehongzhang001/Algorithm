/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class Address implements Cloneable {
    private String city;
    private String street;
    public Address(String c,String s){
        city = c;
        street = s;
    }
    public Address clone()throws CloneNotSupportedException{
        return (Address)super.clone();
    }
}
