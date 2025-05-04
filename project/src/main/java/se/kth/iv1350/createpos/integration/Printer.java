
package se.kth.iv1350.createpos.integration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import se.kth.iv1350.createpos.dto.ReceiptDTO;
import se.kth.iv1350.createpos.model.Item;

/**
 * This class represents the printer that is used to print the receipt after a sale.
 * It contains a method to print the receipt with the sale information.
 */

public class Printer {

    public void printReceipt(ReceiptDTO receipt) {
        System.out.println("----------Begin Receipt----------");
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Sale Time: " + now.format(formatter));
        System.out.println("");

        for (Item item : receipt.getItemBasket()) {
            double price = item.getPrice() * item.getQuantity();
            System.out.printf("%s %d x %.2f    %.2f    SEK%n", item.getName(), item.getQuantity(),
        item.getPrice(), price);
        }
        System.out.println("");
       
        System.out.printf("Total Price: %.2f SEK%n", receipt.getTotalPrice());
        System.out.println("");
        System.out.printf("VAT: %.2f%n", receipt.getVAT());
        System.out.println("");
        System.out.printf("Quantity of Items: %d%n", receipt.getQuantityOfItems());
        System.out.println("");
        System.out.printf("Amount Paid: %.2f SEK%n", receipt.getAmountPaid());
        System.out.println("");
        System.out.printf("Amount of Change: %.2f SEK%n",receipt.getAmountOfChange());
        System.out.println("");
        System.out.println("----------End Receipt----------");
    }
} 