
package se.kth.iv1350.createpos.integration;

import se.kth.iv1350.createpos.dto.ItemDTO;
import se.kth.iv1350.createpos.dto.SaleDTO;

/**
 * This class represents the external inventory system that is used to update
 * the inventory records.
 */

public class ExternalInventorySystem {
  /**
   *It contains a method to retrieve the item information based on the item ID.
   * It contains a static array of ItemDTO objects that represents the inventory
   *system. It contains a method to retrieve the inventory system.
   */
  private static final ItemDTO[] inventorySystem = {
      new ItemDTO(
          29.90, "abc123", "BigWheel Oatmeal", 6,
          "BigWheel Oatmeal 500g, whole grain oats, high fiber, gluten free"),
      new ItemDTO(
          14.90, "def456", "YouGoGo Blueberry", 6,
          "YouGoGo Blueberry 240g, low sugar youghurt, blueberry flavour"),
  };

  /**
   * This method updates the external inventory system with the sale
   * information.
   * @param saleDTO It takes a SaleDTO object as a parameter, which contains the
   *     information about the sale.
   */
  public void updatesInventorySystem(SaleDTO saleDTO) {}

  /**
   * This method retrieves the item information based on the item ID.
   * @param itemID The ID of the item to be retrieved.
   * @return The ItemDTO object that matches the given item ID, or null if no
   *     match is found.
   */
  public static ItemDTO getItemID(String itemID) {
    for (ItemDTO item : inventorySystem) {
      if (item.getItemID().equals(itemID)) {
        return item;
      }
    }
    return null;
  }

  /**
   * This method retrieves the inventory system.
   * @return The inventory system as an array of ItemDTO objects.
   */

  public static ItemDTO[] getInventorySystem() { return inventorySystem; }
}
