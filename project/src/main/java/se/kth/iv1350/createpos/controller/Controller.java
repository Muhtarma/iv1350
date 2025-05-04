
package se.kth.iv1350.createpos.controller;

import se.kth.iv1350.createpos.dto.ItemDTO;
import se.kth.iv1350.createpos.dto.ReceiptDTO;
import se.kth.iv1350.createpos.dto.SaleDTO;
import se.kth.iv1350.createpos.integration.Integration;
import se.kth.iv1350.createpos.integration.Printer;
import se.kth.iv1350.createpos.model.Item;
import se.kth.iv1350.createpos.model.Payment;
import se.kth.iv1350.createpos.model.Sale;
import se.kth.iv1350.createpos.integration.DiscountDataBase;
import se.kth.iv1350.createpos.integration.ExternalInventorySystem;

/**
 * The Controller class is responsible for handling the interaction between the
 * view, model, and integration layers of the application. It processes user
 * input, manages the sale process, and communicates with external systems.
 */

public class Controller {
    private Integration integration;
    private Sale sale;
    private SaleDTO saleDTO;
    private Printer printer;
    private DiscountDataBase discountDataBase;

    /**
     * This is the constructor for the Controller class.
     * @param integration is responsible for handling the integration with external systems.
     * @param printer is responsible for printing receipts.
     * @param discountDataBase  is responsible for managing discount information.
     */
    
    public Controller(Integration integration, Printer printer, DiscountDataBase discountDataBase){
        this.integration = integration;
        this.printer = printer; 
        this.discountDataBase = discountDataBase;

    }

    /**
     * Initiates a new sale by creating a new Sale object.
     */
   public void initiateSale () {
       sale = new Sale();
   }
   
   /**
    * Scans an item with the given item ID and quantity, adds it to the current sale, and calculates
    the running total.
    * @param itemID The ID of the item to be scanned.
    * @param quantity The quantity of the item to be scanned.
    * @return The scanned Item object.
    */
   public Item scanItems(String itemID, int quantity){ 
        ItemDTO itemDTO = ExternalInventorySystem.getItemID(itemID);
        Item item = itemDTO.toItem(quantity);
        sale.addItems(item, quantity);
        sale.calculateRunningTotal();
        return item;
    }
   
    /**
     * Registers the payment for the current sale, updates the external systems and prints receipt.
     * @param amount The amount paid by the customer.
     */

   public void registerPayment(double amount) {
    Payment payment = new Payment(amount);
    sale.setPayment(payment);
    saleDTO = sale.toDTO(); 
    integration.updatesSystems(saleDTO);
    ReceiptDTO receiptDTO = sale.getReceiptInformation();
    printer.printReceipt(receiptDTO); 
   }
   
   /**
    * Checks if the customer is eligible for a discount based on their customer ID.
    * @param customerID The ID of the customer.
    * @return The amount of discount.
    */
   public double IDChecked(int customerID){
       double discount = discountDataBase.fetchDiscount(customerID);
        return sale.applyDiscount(discount);
   }
   /**
    * Ends the sale and calculates the final price containing amount of discount (which is 0 for this seminar).
    * @return the final price of the sale.
    */
   public double endSale(){
       return sale.calculateFinalPrice();
   }

   /**
    * Gets the receipt information for the current sale.
    * @return The ReceiptDTO object containing receipt information.
    */

   public ReceiptDTO getReceiptInformation(){
       return sale.getReceiptInformation();
   }

   /**
    * Gets the total price for all items in the sale.
    * @return The total price for all items.
    */
    public double getCalculateRunningTotal() {
        return sale.calculateRunningTotal();
    }

    /**
     * Gets the amount of VAT for the current sale.
     * @return The amount of VAT for the current sale.
     */
    public double getAmountOfVat(){
        return sale.amountOfVAT();
    }
}

