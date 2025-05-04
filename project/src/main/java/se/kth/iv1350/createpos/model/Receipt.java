
package se.kth.iv1350.createpos.model;

import se.kth.iv1350.createpos.dto.ReceiptDTO;

/**
 * This class represents a receipt that is generated after a sale.
 * It contains information about the sale, such as the total price, VAT, and items sold.
 */

public class Receipt {
    private ReceiptDTO receiptDTO;
    private int items;
    private double totalPrice;
    private double VAT;
    private int quantityOfItems;

    /**
     * Constructor for Receipt class.
     * It initializes the receipt with the total price, number of items, VAT, and receipt information.
     * @param totalPrice the total price of the sale.
     * @param items the number of items sold.
     * @param VAT the VAT of the sale.
     * @param receiptDTO the receipt information.
     * @param quantityOfItems the quantity of items sold.
     */

    public Receipt(double totalPrice, int items, double VAT, ReceiptDTO receiptDTO, int quantityOfItems) {
        this.receiptDTO = receiptDTO;
        this.items = items;
        this.totalPrice = totalPrice;
        this.VAT = VAT;
        this.quantityOfItems = quantityOfItems;
    }

    /**
     * Method to get the receiptDTO instance of the receipt.
     * @return the receiptDTO object.
     */ 

    public ReceiptDTO receiptDTO(){
        return receiptDTO;
    }
    
    /**
     * Gets the receipt information.
     * * @return the receipt information.
     */
   
    public ReceiptDTO getReceiptInformation(){
        return receiptDTO;
    }

    /**
     * Gets the number of items sold.
     * @return the number of items sold.
     */
     
    public int getItems(){
        return items;
    }

    /**
     * Gets the total price of the sale.
     * * @return the total price of the sale.
     */
     
    public double getTotalPrice(){
        return totalPrice;
    }

    /**
     * Gets the VAT of the sale.
     * * @return the VAT of the sale.
     */
    
    public double getVAT(){
        return VAT;
    }
    
    /**
     * * Gets the quantity of items sold.
     * * @return the quantity of items sold.
     */
     
    public int getQuantityOfItems(){
        return quantityOfItems;
    }
   
    
}
   
    


