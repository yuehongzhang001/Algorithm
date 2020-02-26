/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *Create a class named Order that stores:
 * - strings orderID and customerID
 * - double amount
 * @author Yuehong Zhang 3109345
 */
public class Order {
    private String orderID;
    private String customerID;
    private double amount;
    
    /**
     * Constructor 
     */
    
    public Order(String o, String c, double a){
        orderID = o;
        customerID = c;
        amount = a;
    }
    /**
     * accessors
     */
    public String getOrderID(){return orderID;}
    public String getCustomerID(){return customerID;}
    public double getAmount(){return amount;}
    
    /**
     * setters
     */
    public void setOrderID(String o){ orderID=o;}
    public void setCustomerID(String c){ customerID=c;}
    public void setAmount(double a){ amount=a;}
    
    /**
     * method to convert the Object to String
     */
    public String toString(){
        return "{"+orderID+" "+customerID+" "+amount+"}";
    }
}
