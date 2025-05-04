package se.kth.iv1350.createpos.model;

/**
 * This class represents an item in the store. 
 * It contains information about the item's price, ID, name, VAT, description, and quantity.
 */
public class Item {
    private double price;
    private String itemID;
    private String name;
    private double VAT;
    private String description;
    private int quantity;

    /**
     * Constructor for Item class.
     * @param price The price of the item.
     * @param itemID The ID of the item.
     * @param name The name of the item.
     * @param VAT The VAT of the item.
     * @param description The description of the item.
     * @param quantity The quantity of the item.
     */

    public Item (double price, String itemID, String name, double VAT, String description, int quantity){
        this.price = price;
        this.itemID = itemID;
        this.name = name;
        this.VAT = VAT;
        this.description = description;
        this.quantity = quantity;
    }

    /**
     * Method to get the price of the item.
     * @return It returns the price of the item.
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * Get the item ID of the item.
     * @return It returns the item ID of the item.
     */
    public String getItemID(){
        return this.itemID;
    }

    /**
     * Method to get the name of the item.
     * @return It returns the name of the item.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get the VAT of the item.
     * @return It returns the VAT of the item.
     */
    public double getVAT(){
        return this.VAT;
    }

    /**
     * Get the description of the item.
     * @return It returns the description of the item.
     */
     
    public String getDescription() {
        return description;
    }

   
   /**
    * Get the quantity of the item.
    * @return It returns the quantity of the item.
    */
     
    public int getQuantity() {
        return quantity;
    }

    /**
     * Method to increase the quantity of the item.
     * @param amount The amount to increase the quantity by.
     */
    public void increaseQuantity(int amount) {
        quantity = quantity + amount;
    }

}
