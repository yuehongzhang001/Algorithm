
/**
 * The class to simulate using a menu to handle transactions and display information
 * @author Yuehong Zhang 3109345 Assignment 1 part B
 */
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
       
        TransactionsHandler transactionsHandler = new TransactionsHandler();//create a new transactionsHandler
        boolean quit = false;//if or not user quit the menu.
        while (!quit) {//if not quit
            String userSelection = displayMenuForSelection();//get user's selection
            switch (userSelection) {
                case "1":
                    selectBuyItem(transactionsHandler);//user select buy item
                    System.out.println("\n-----------------");
                    break;
                case "2":
                    selectSellItem(transactionsHandler);//user select sell item
                    System.out.println("\n-----------------");
                    break;
                case "3":
                    selectTotalExpenditures(transactionsHandler);//user select TotalExpenditures
                    System.out.println("\n-----------------");
                    break;
                case "4":
                    selectTotalSales(transactionsHandler);//user select selectTotalSales
                    System.out.println("\n-----------------");
                    break;
                case "5":
                    selectProfitLossToDate(transactionsHandler);//user select selectProfitLossToDate
                    System.out.println("\n-----------------");
                    break;
                case "6":
                    quit = true;//user select to quit
                    break;
                default:
                    System.out.println("Invalid selection!");//user select invalid number
                    System.out.println("\n-----------------");
                    break;
            }
        }
        System.out.println("Program ends");//program ends

    }

    //the method to display menu and get user's selection
    public static String displayMenuForSelection() {
        Scanner kb = new Scanner(System.in);
        System.out.println("Make a selection:\n"
                + "1. Buy item\n"
                + "2. Sell item\n"
                + "3. Total expenditures for all items in stock:\n"
                + "4. Total sales to date:\n"
                + "5: Profit/Loss to date:\n"
                + "6. Quit");
        System.out.print(">");
        String selection = kb.nextLine();//get user's selection
        return selection;
    }

    //method to check if selectin is valid
    public static boolean isValidSelection(String str) {
        switch (str) {
            case "1":
                return true;
            case "2":
                return true;
            case "3":
                return true;
            case "4":
                return true;
            case "5":
                return true;
            case "6":
                return true;
            default:
                return false;
        }
    }

    /**
     * This method try to parse an non-negative integer from user's input
     * @return the non-negative integer from user's input
     * @throws IllegalArgumentException 
     */
    public static int getValidInteger() throws IllegalArgumentException {
        Scanner kb = new Scanner(System.in);
        String input = kb.nextLine();
        ////calling parseInt may throw an NumberFormatException which also is a sub-Object of IllegalArgumentException
        int validInteger = Integer.parseInt(input);
        if (validInteger < 0) {//if not a non-negative integer
            throw new IllegalArgumentException();//throw the exception
        }
        return validInteger;//the valid integer from user
    }

    //the method to get item information to buy an item.
    public static void selectBuyItem(TransactionsHandler transactionsHandler) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter item: ");
        String itemName = kb.nextLine();//get item name
        try {
            System.out.print("Enter the purchase price for item: ");
            int price = getValidInteger();//get valid price
            System.out.print("Items Bought: ");
            int number = getValidInteger();//get valid number of item
            for (int i = 0; i < number; i++) {
                transactionsHandler.buyItems(new Item(itemName, price));//buy item one by one
            }
            int totalExpenditures = price * number;//get totalExpenditures
            //display totalExpenditures
            System.out.println("Total expenditures per item: " + formatMoney(totalExpenditures));
        } catch (IllegalArgumentException e) {
            //if user input invalid integer, back to main
            System.out.println("Invalid input, need nonnegative integers here! Back to main now.");
        }
    }

    public static void selectSellItem(TransactionsHandler transactionsHandler) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the item to sell: ");
        String itemName = kb.nextLine();//get item name to sell
        System.out.print("Enter the selling price per share: ");
        try {
            int sellPrice = getValidInteger();//get selling price from user
            boolean transactionSuccess = transactionsHandler.sellItems(itemName, sellPrice);
            if (!transactionSuccess) {
                System.out.println("Item not found!");
            } else {
                //display Item Profit/Loss
                System.out.println("Item Profit/Loss: " + formatMoney(transactionsHandler.getProfitLoss()));
            }
        } catch (IllegalArgumentException e) {
            //if user input invalid integer, back to main
            System.out.println("Invalid input, need nonnegative integers here! Back to main now.");
        }
    }

    //the method to display TotalExpenditures
    public static void selectTotalExpenditures(TransactionsHandler transactionsHandler) {
        System.out.println("Total expenditures to date: " + formatMoney(transactionsHandler.getTotalValue()));
    }
    //the method to display TotalSales
    public static void selectTotalSales(TransactionsHandler transactionsHandler) {
        System.out.println("Total sales to date: " + formatMoney(transactionsHandler.getTotalSales()));
    }
    //the method to display ProfitLossToDate
    public static void selectProfitLossToDate(TransactionsHandler transactionsHandler) {
        System.out.println("Profit/Loss to date: " + formatMoney(transactionsHandler.getTotalProfitLoss()));
    }
 //the method to format money
    public static String formatMoney(int number) {
        if (number >= 0) {
            return "$" + number + ".00";
        } else {
            return "-$" + (-number) + ".00";
        }
    }

}
