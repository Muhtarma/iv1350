package se.kth.iv1350.createpos.integration;

import se.kth.iv1350.createpos.dto.SaleDTO;

/**
 * This class represents the integration layer of the system.
 * It contains instances of the external systems such as the discount database, inventory system, accounting system, 
 * and printer. It provides methods to update the external systems with the sale information.
 * It also provides a method to get the printer instance.
 * The integration layer is responsible for communicating with the external systems and updating them with the sale information.
 */

public class Integration {
    DiscountDataBase discountDB = new DiscountDataBase(0);
    ExternalInventorySystem invS = new ExternalInventorySystem(); 
    ExternalAccountingSystem aacS = new ExternalAccountingSystem();
    Printer pri = new Printer(); 
    

/**
 * This method retrieves the printer instance.
 * @return The printer instance.
 */
public Printer getPrinter() {
    return pri;
}
/**
 * This method retrieves the discount database instance.
 * @return The discount database instance.
 */
public DiscountDataBase getDiscountDB() {
    return discountDB;
}

/**
 * This method updates the external systems with the sale information.
 * It updates the inventory system and accounting system with the sale information.
 * @param saleDTO SaleDTO object as a parameter, which contains the information about the sale.
 */
public void updatesSystems(SaleDTO saleDTO) {
    invS.updatesInventorySystem(saleDTO);
    aacS.updatesAccountingSystem(saleDTO);
    }
}