package se.kth.iv1350.createpos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class PaymentTest {
    private double amountPaid;
    
    @Before
    public void setUp() {
        amountPaid = 100;
    }

   @ Test
    public void testToCheckPaidAmount() {
        Payment payment = new Payment(amountPaid);
        double result = payment.getAmountPaid();
        assertEquals(amountPaid, result, 0.01);
    }

   

    
}



