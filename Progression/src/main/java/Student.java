/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yuehongzhang
 */
public class Student extends Person implements Cloneable{
    private static class  Address implements Cloneable {
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
    public String name;
    public int age=18;
    public Address address;
    public Student(String n, int a){name = n;age=a;}
   
    @Override
    protected Student clone()throws CloneNotSupportedException{
        Student newStudent = (Student)super.clone();
        newStudent.address = (Address)address.clone();
        return newStudent;
    }
    
    public boolean equals(Person other){
        Student s;
        try{
            s = (Student)other;
        }catch(ClassCastException e){
            return false;
        }
        return name.equals(s.name);
    }
    public String toString(){
        return "{"+name+","+age+"}";
    }
}
