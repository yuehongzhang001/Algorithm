

/**
 * This Item class stores the name,purchasePrice and sellingPrice of an item
 * @author Yuehong Zhang 3109345 Assignment 1 part B
 */
public class Item {
    private String name;//name of the item
    private int purchasePrice;//purchase price of the item
    private int sellingPrice;//selling price of the item
    public Item(String n,int p){//constructor
        name = n;
        purchasePrice = p;
    }
    public String getName(){return name;}// the method to return item name
    public int getSellingPrice(){return sellingPrice;}//the method to return selling price
    public int  getPurchasePrice(){return purchasePrice;}//the method to return purchase price
    
    public void setSellingPrice(int p){// the method to update selling price
        sellingPrice = p;
    }
}
