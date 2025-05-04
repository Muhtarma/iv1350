
package se.kth.iv1350.createpos.dto;

/**
 * This class is a Data Transfer Object (DTO) that represents a sale.
 * It contains information about the number of items sold, the final price of the sale,
 * and the names of the items sold.
 */
public class SaleDTO {
    private int numberOfItems;
    private double finalPrice;
    private String[] name;

/**
 * Constructor for SaleDTO class.
 * It initializes the number of items sold, the final price of the sale,
 * @param numberOfItems a parameter that represents the number of items sold.
 * @param finalPrice   a parameter that represents the final price of the sale.
 * @param name a parameter that represents the names of the items sold.
 */
    public SaleDTO(int numberOfItems, double finalPrice, String[] name) {
        this.numberOfItems = numberOfItems;
        this.finalPrice = finalPrice;
        this.name = name;
    }
 
    /**
     * Gets the number of items sold.
     * @return the number of items sold.
     */
    public int getNumberOfItems() {
        return this.numberOfItems;
    }

    /**
     * Method to find the the final price of the sale.
     * @return the final price of the sale.
     */
    public double getFinalPrice() {
        return this.finalPrice;
    }

    /**
     * Gets the names each item sold.
     * @return the names of the items sold.
     */
    public String[] getName() {
        return name;
    }
}




