package se.kth.iv1350.createpos.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import se.kth.iv1350.createpos.dto.ItemDTO;

public class ExternalInventorySystemTest {

  @Test
  public void testExistentItemID() {
    String itemID = "abc123";
    ItemDTO item = ExternalInventorySystem.getItemID(itemID);
    assertEquals(itemID, item.getItemID(),
                 "Item ID should match the requested item ID");
    assertEquals(
        "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free",
        item.getDescription(),
        "Item description should match the requested item ID");
    assertEquals(29.90, item.getPrice(), 0.01,
                 "Item price should match the requested item ID");
    assertEquals(6, item.getVAT(),
                 "Item quantity should match the requested item ID");
    assertNotNull(item, "Item should not be null");
  }

  @Test
  public void testNonExistentItemID() {
    ItemDTO item = ExternalInventorySystem.getItemID("nonexistent");
    assertNull(item, "Item should be null for a non-existent item ID");
  }
}
