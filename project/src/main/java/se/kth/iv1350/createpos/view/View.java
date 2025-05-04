
package se.kth.iv1350.createpos.view;
import se.kth.iv1350.createpos.controller.Controller;
import se.kth.iv1350.createpos.dto.ItemDTO;
import se.kth.iv1350.createpos.integration.ExternalInventorySystem;
import se.kth.iv1350.createpos.model.Item;

/**
 * This class represents the view of the program. It is responsible for displaying information to the user.
 */
public class View {
    private Controller contr;
    
    /**
     * Constructor for the View class.
     * It initializes the controller for the view.
     * @param contr The controller for the view.
     */
    public View(Controller contr){
        this.contr = contr;
    }
    
    /**
     * This method simulates a new sale execution.
     * It initiates a sale, scans items, and registers payment.
     * It also displays information about the items and the total cost.
     * It prints the item information to the console.
     */
    public void newSaleExecution(){
        System.out.println("");
        contr.initiateSale();
        System.out.println("Sale has been initiated ");
      

        String[] itemIDs = {"abc123", "abc123", "def456"};
        int [] quantities = {1, 1, 1};
        for (int i = 0; i < itemIDs.length; i++){
            System.out.println();
        Item item = contr.scanItems(itemIDs[i], quantities[i]);    
        System.out.println("Add 1 item with item ID: " + item.getItemID());
        System.out.println("Item ID: " + item.getItemID());
        System.out.println("Item name: " + item.getName());
        System.out.printf("Item cost: %.2f SEK%n", item.getPrice());
        System.out.println("VAT:" + item.getVAT() + " %");
        System.out.println("Item Description: " + item.getDescription());
        System.out.println("");
        System.out.printf("Total cost (including VAT): %.2f SEK%n", contr.getCalculateRunningTotal());
        System.out.printf("Total VAT: %.2f SEK%n", contr.getAmountOfVat());
 
        }

        System.out.println("");
        System.out.println("End Sale: ");
        System.out.printf("Total cost (including VAT): %.2f SEK%n", contr.getCalculateRunningTotal());

       contr.endSale();
        System.out.println("");

        contr.registerPayment(100);


    }

    /**
     * This method prints the information of all items in the inventory system.
     * It prints the item ID, name, price, quantity, VAT, and total cost to the console.
     */

    public void printItemInformation(){
        ItemDTO[] items = ExternalInventorySystem.getInventorySystem();
        for (ItemDTO item : items){
            System.out.println("Item ID: " + item.getItemID());
            System.out.println("Item: " + item.getName());
            System.out.println("Price: " + item.getPrice());
            System.out.println("Quantity: " );
            System.out.println("VAT: " + item.getVAT());
            System.out.println("Total cost:  " + contr.getCalculateRunningTotal());
        }
    }
}
