package se.kth.iv1350.createpos.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    private Item item;
 
  
    @Before
    public void setUp() {
        item = new Item(100.0, "123", "Test Item", 25.0, "Test Description", 5);
    }


  @Test 
        public void testToIncreaseQuantity() {
        int amount = 5;
        int expectedQuantity = 5+ amount;
        item.increaseQuantity(amount);
        assertEquals(expectedQuantity, item.getQuantity());
  }
}
