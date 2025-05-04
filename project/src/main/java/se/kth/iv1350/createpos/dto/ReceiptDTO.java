
package se.kth.iv1350.createpos.dto;

import java.util.List;

import se.kth.iv1350.createpos.model.Item;

/**
 * This class represents a receipt that is generated after a sale. It contains information about the sale, such as 
 * the total price, time of sale, date, VAT, quantity of items, amount of change, amount paid, and items in the
 * item basket.
 */

public class ReceiptDTO {
    private double totalPrice;
    private int timeOfSale;
    private int date;
    private double VAT;
    private int quantityOfItems;
    private double amountOfChange; 
    private double amountPaid;
    private List<Item> itemBasket;;


  /**
   * Constructor for ReceiptDTO class.
   *  It initializes the receipt with the total price, time of sale, date, VAT, quantity of items, amount of change,
   *  amount paid, and item basket.
   * @param totalPrice the total price of the sale.
   * @param timeOfSale the time of sale in hours and minutes.
   * @param date the date of sale.
   * @param VAT the VAT of the sale.
   * @param quantityOfItems the quantity of items in the sale.
   * @param amountOfChange the amount of change from the sale.
   * @param amountPaid the amount paid from the sale.
   * @param itemBasket the item basket containing items to be purchased by the customer.
   */  

public ReceiptDTO (double totalPrice, int timeOfSale, int date, double VAT, int quantityOfItems, 
double amountOfChange, double amountPaid, List<Item> itemBasket) {
    this.totalPrice = totalPrice;
    this.timeOfSale = timeOfSale;
    this.date = date;
    this.VAT = VAT;
    this.quantityOfItems = quantityOfItems;
    this.amountOfChange = amountPaid - totalPrice;
    this.amountPaid = amountPaid;
    this.itemBasket = itemBasket;
}

/**
 * Gets the total price of the sale.
 * @return the total price of the sale
 */
public double getTotalPrice(){
    return this.totalPrice;
}

/**
 * Gets the time of sale.
 * @return the time of sale in hours and minutes.
 */
public int getTimeOfSale(){
    return this.timeOfSale;
}
 
/**
 * Gets the date of sale.
 * @return the date of sale.
 */
public int getDate(){
    return this.date;
}

/**
 * Gets the VAT of the sale.
 * @return the VAT of the sale.
 */
public double getVAT(){
    return this.VAT;
}

/**
 * Gets the quantity of items in the sale.
 * @return the quantity of items in the sale.
 */
public int getQuantityOfItems(){
    return this.quantityOfItems;
}

/**
 * Method to get the amount of change from the sale.
 * @returns the amount of change from the sale.
 */
public double getAmountOfChange(){
    return this.amountOfChange; 

}

/**
 * Method to get the amount paid.
 * @return the amount paid.
 */
public double getAmountPaid(){
    return this.amountPaid; 
}

/**
 * Gets the item basket containing items to be purchased by the customer.
 * @return the item basket from the sale.
 */
 
public List<Item> getItemBasket(){
    return this.itemBasket;
}

}