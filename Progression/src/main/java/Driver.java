/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
import java.util.Arrays;
import java.util.Random;
public class Driver {
    
    public static void main(String[] args)throws CloneNotSupportedException{
        Student s = new Student("abc",11);
        Student s2 = s.clone();
        System.out.println(s2);
    }
    
    public static <T> void revearse(T[] array){
        int lowEnd = 0;
        int highEnd = array.length;
        while(lowEnd<highEnd){
            T temp = array[lowEnd];
            array[lowEnd]=array[highEnd];
            array[highEnd]=temp;
            lowEnd--;
            highEnd--;
        }
    }
}
