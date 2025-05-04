
package se.kth.iv1350.createpos.dto;


import se.kth.iv1350.createpos.model.Item;

/**
 * This class represents items in the inventory system. It contains information about the items, such as its price, 
 * item ID, name, VAT, and description.
 */
public class ItemDTO {
    private double price; 
    private String itemID;
    private String name;
    private double VAT;
    private String description;
    
    /**
     * Constructor for ItemDTO class.  
     * It initializes the item with its price, item ID, name, VAT, and description.
     * @param price the price of the item.
     * @param itemID the ID of the item.
     * @param name the name of the item.
     * @param VAT the VAT of the item.
     * @param description the description of the item.
     */
public ItemDTO (double price, String itemID, String name, double VAT, String description){
    this.price = price;
    this.itemID = itemID;
    this.name = name;
    this.VAT = VAT;
    this.description = description;
}

/**
* Gets the price of the item.
 @return It returns the price of the item.
 */
public double getPrice(){
    return this.price;
}
/**
 * Gets the item ID of the item.
 * @return It returns the item ID of the item.
 */
public String getItemID(){
    return this.itemID;
}

/**
 * Get the name of the item.
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
 * Converts the ItemDTO to an Item object with a specified quantity.
 * @param quantity The quantity of the item.
 * @return An Item object with the specified quantity.
 */
public Item toItem(int quantity) {
    return new Item(price, itemID, name, VAT, description, quantity);
    }


}

