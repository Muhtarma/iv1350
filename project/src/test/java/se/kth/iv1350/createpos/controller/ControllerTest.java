package se.kth.iv1350.createpos.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.createpos.dto.ItemDTO;
import se.kth.iv1350.createpos.dto.ReceiptDTO;
import se.kth.iv1350.createpos.integration.DiscountDataBase;
import se.kth.iv1350.createpos.integration.Integration;
import se.kth.iv1350.createpos.integration.Printer;
import se.kth.iv1350.createpos.model.Sale;
import se.kth.iv1350.createpos.model.Item;


public class ControllerTest {
    private Controller controller;
    private Integration integration;
    private Printer printer;
    private ItemDTO item;
    private DiscountDataBase discountDataBase;

    @BeforeEach
    public void setUp() {
        integration = new Integration();
        printer = new Printer();
        discountDataBase = new DiscountDataBase(0); 
        controller = new Controller(integration, printer, discountDataBase);
        new Sale();
        controller.initiateSale();
        item = new ItemDTO(29.90, "abc123", "BigWheel Oatmeal", 6,
                "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free");     

    }

    @AfterEach
    public void tearDown() {
        controller = null;
        integration = null;
        printer = null;
        item = null;
        discountDataBase = null;
    }
    
   @Test    
    public void testIfScannedItemsGivesCorrectItemID() {
        controller.scanItems("abc123", 1);
        assertEquals("abc123", item.getItemID(), "Item ID returned should be equal to the scanned item ID");
        
    }

    @Test
    public void testAddItems() {
       Item item = controller.scanItems("abc123", 2);
        assertEquals(2, item.getQuantity(), "Item quantity should be the same as the quanitity scanned");
    }

    @Test public void testCalculateRunningTotal() {
        Item item = controller.scanItems("abc123", 1);
        double expectedTotal = item.getPrice()*item.getQuantity(); 
        assertEquals(expectedTotal, controller.getCalculateRunningTotal(), "Running total should be equal to the item price times the quantity");
    }
 
    @Test
    public void testRegisterPayment() {
        controller.scanItems("abc123", 1);
        controller.registerPayment(100);
        ReceiptDTO receiptTest = controller.getReceiptInformation();  
        assertEquals(100, receiptTest.getAmountPaid(), "Amount paid should be 100");
    }


    @Test
    public void testIDCheckedForDiscount() {
       double checkForDiscount = controller.IDChecked(8769);
       double expectedDiscount = 0;
       assertEquals(expectedDiscount,checkForDiscount, "Discount should be 0");
    }

    @Test
    public void testEndSale() {
        controller.scanItems("abc123", 3);
        double expectedFinalPrice = controller.getCalculateRunningTotal();
        double finalPrice = controller.endSale();
        assertEquals(expectedFinalPrice, finalPrice, 0.01, "Final price should be calculated correctly");
}

}

