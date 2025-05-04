
package se.kth.iv1350.createpos.integration;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a discount database that stores customer IDs and their corresponding discounts.
 */

public class DiscountDataBase {
    private int customerID;
    private Map<Integer, Double> discountDataBase = new HashMap<>();
    

    /**
     * Constructor for DiscountDataBase class.
     * Initializes the discount database with a customer ID and its corresponding discount.
     * @param customerID  the ID of the customer.
     * @param discount  the discount for the customer.
     */
public DiscountDataBase(int customerID) {
        discountDataBase.put(8769, 0.00); 
        this.customerID = customerID;
    }
    
    /**
     * Fetches the discount for a given customer ID.
     * @param customerID
     * @return the amount of discount for the customer with the given ID, or 0.0 if no discount is found.
     */
public double fetchDiscount(int customerID) {
        if (discountDataBase.containsKey(customerID)) {
            return discountDataBase.get(customerID);
        } else {
            return 0.0; // No discount for this customer
        }
    }    
    
    /**
    * Gets the customer ID.
    * @return the customer ID.
    */
public int getcustomerID(){
    return this.customerID;
    }

}


