
/**
 * This is a class to handle and records transactions.
 * @author Yuehong Zhang 3109345 Assignment 1 part B
 */
public class TransactionsHandler {
    private LinkedQueue<Item>  itemsHeld = new LinkedQueue<>();//this queue stores all the items in stock
    private LinkedQueue<Item> itemsSold = new LinkedQueue<>();//this queue stores all items have been sold
    private Item itemJustSold;//this variable only stores the most recent 1 item sold
    public TransactionsHandler(){}//constructor
    
    public void buyItems(Item item){//the method to add item in the itemsHeld queue
        itemsHeld.add(item);//item added
    }
    
    /**
     * the method to remove item in the itemsHeld queue and add it to itemsSold queue
     * @param itemName
     * @param sellingPrice
     * @return 
     */
    public boolean sellItems(String itemName, int sellingPrice){
        if(itemName == "" )return false;//if empty name, no item is sold.
        if(itemsHeld.isEmpty()) return false;//if queue is empty, no item is sold.
     
        boolean itemFound = false;
        //loop through the queue until all items are checked or item is found.
        for(int i=0;i<itemsHeld.size();i++){
            String firstItemName =itemsHeld.peek().getName();//get the item name
            //if the item was found, break out of the loop
            if(itemName.equals(firstItemName)){
                itemFound = true;
                break;
            }
            //first item is not what we are lookingfor, so remove it and add the back to the queue
            Item removed = itemsHeld.poll();
            itemsHeld.offer(removed);//add to the last one      
        }
        if(itemFound){//if we find the item
            itemJustSold = itemsHeld.poll();//poll the item out from  itemsHeld list
            itemJustSold.setSellingPrice(sellingPrice);//set its selling price
            itemsSold.offer(itemJustSold);//add it to the itemsSold list
            return true;//sell successfully
        }else
            return false;// sell fails
    }
    //this method calculate the profit/loss for the item which is just sold.
    public int getProfitLoss(){
        return itemJustSold.getSellingPrice()-itemJustSold.getPurchasePrice();
    }
    
    public int getTotalValue(){//the method to return the total value of items hold and sold 
        int totalValue = 0;//totoal value
        for(int i=0;i<itemsHeld.size();i++){//loop through the itemsHeld queue
            Item firstItemHeld = itemsHeld.poll();//poll first item
            totalValue += firstItemHeld.getPurchasePrice();// add first item's value to total
            itemsHeld.offer(firstItemHeld);//add it back to the queue
        }
        for(int i=0;i<itemsSold.size();i++){//loop through the itemsSold queue
            Item firstItemSold = itemsSold.poll();//poll first item
            totalValue += firstItemSold.getPurchasePrice();//add first item's value to total
            itemsSold.offer(firstItemSold);//add item back to the queue
        }
        return totalValue;//return the total value
    }
    
    public int getTotalSales(){//method to get total sales
        int totalSales = 0;//total sales
        for(int i=0;i<itemsSold.size();i++){//loop through itemsSold queue
            Item firstItem = itemsSold.poll();//poll first item
            totalSales += firstItem.getSellingPrice();//add item's selling price to totalSales
            itemsSold.offer(firstItem);//add item back to itemsSold queue
        }
        return totalSales;//return total sales
    }
    public int getTotalProfitLoss(){//method to get total profit/loss
        int totalProfitLoss = 0;
        for(int i=0;i<itemsSold.size();i++){//loop through itemsSold queue
            Item firstItem = itemsSold.poll();//poll first item
            //get profit/loss of it
            totalProfitLoss += firstItem.getSellingPrice() - firstItem.getPurchasePrice();
            itemsSold.offer(firstItem);//add item back to queue
        }
        return totalProfitLoss;//return the totalProfitLoss
    }
}
