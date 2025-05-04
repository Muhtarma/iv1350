package se.kth.iv1350.createpos.model;

/**
 * This class represents a payment made by the customer.
 * It contains information about the amount paid.
 */

public class Payment {
    private double amountPaid;

    /**
     * Constructor for Payment class.
     * It initializes the amount paid by the customer.
     * @param amountPaid a parameter that represents the amount paid by the customer.
     */
     
 public Payment(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * Gets the amount paid by the customer.
     * @return It returns the amount paid by the customer.
     */
public double getAmountPaid() {
        return amountPaid;
    }    
}
