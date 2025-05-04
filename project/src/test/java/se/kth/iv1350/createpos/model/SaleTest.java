package se.kth.iv1350.createpos.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.createpos.dto.ReceiptDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;

public class SaleTest {
    private Sale sale; 
    private Item item;

    @BeforeEach
    public void setUp() {
        sale = new Sale();
        item = new Item(20, "3h78", "Chocolate Milk", 3, "Chcolate flavoured milk", 1);
           
    }      
    
    @AfterEach
    public void tearDown() {
        sale = null;
        item = null;
    }

    @Test
    public void testIfRunningTotalEqualsAddedNewItemsPrice() {
        sale.addItems(item, 1);
        assertEquals(20, sale.calculateRunningTotal(), 0.01, "Running total should be equal to the price of the item times the quantity");
    
    }


    @Test
    public void testAddingNullItem() {
        Sale sale = new Sale();
        Item item = null;
        sale.addItems(item, 2);
        assertTrue(sale.itemBasket().isEmpty(), "Item should not be added to the basket if item is null");
    }

    @Test
    public void testItemAlreadyInBasket(){
        sale.addItems(item, 1);
        sale.addItems(item, 2);
        assertEquals(3, item.getQuantity(), "Item quantity should be equal to the quantity added");
    }
    


@Test
    public void testGetReceiptInformation() {
        sale.addItems(item, 1);
        Payment payment = new Payment(20);
        sale.setPayment(payment);
        double totalPrice = sale.calculateRunningTotal();
        ReceiptDTO receipt = sale.getReceiptInformation();
        assertNotNull(receipt, "Receipt should not be null");
        assertEquals(totalPrice, receipt.getTotalPrice(), 0.01, "Total price should be equal to the price of the item times the quantity");
    }

 @Test
    public void testAmountOfVAT() {
        sale.addItems(item, 1);
        double expectedVAT = item.getPrice() * item.getVAT() * item.getQuantity()/ 100;
        assertEquals(expectedVAT, sale.amountOfVAT(), 0.01, "Amount of VAT should be equal to the expected VAT");
    }


}

