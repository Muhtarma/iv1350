
package se.kth.iv1350.createpos.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import se.kth.iv1350.createpos.dto.ReceiptDTO;
import se.kth.iv1350.createpos.dto.SaleDTO;

/**
 * This class represents a sale in the system. It contains information about the
 * items sold, the time of sale, and the payment.
 */
public class Sale {
  private int amountOfDiscount;
  private LocalTime timeOfSale;
  private ArrayList<Item> itemBasket;
  private Payment payment;

  /**
   * Constructor for Sale class.
   * It initializes the sale with the current time and an empty item basket.
   */

  public Sale() {
    this.timeOfSale = LocalTime.now();
    this.itemBasket = new ArrayList<>();
  }

  /**
   * Gets the time of sale.
   * @return the time of sale.
   */

  public LocalTime getTimeOfSale() {
    timeOfSale = LocalTime.now();
    return timeOfSale;
  }

  /**
   * Adds an item to the item basket.
   * If the item is null, it does nothing.
   * If the item already exists in the basket, it updates the quantity.
   * If the item does not exist in the basket, it adds the item to the basket.
   * @param item  the item to be added.
   * @param quantity  the quantity of the item to be added.
   */

  public void addItems(Item item, int quantity) {
    if (item == null)
      return;

    for (Item chosenItem : itemBasket) {
      if (chosenItem.getItemID().equals(item.getItemID())) {
        chosenItem.increaseQuantity(quantity);
        return;
      }
    }
    itemBasket.add(item);
  }

  /**
   * Calculates the running total of the items in the basket
   * @return the running total of the items in the basket.
   */
  public double calculateRunningTotal() {
    double totalPrice = 0;
    for (Item item : itemBasket) {
      totalPrice += item.getPrice() * item.getQuantity();
    }
    return totalPrice;
  }

  /**
   * Gets the receipt information.
   * @return the receipt information.
   */
  public ReceiptDTO getReceiptInformation() {
    double totalPrice = calculateRunningTotal();
    int timeOfSale =
        LocalTime.now().getHour() * 60 + LocalTime.now().getMinute();
    int date = LocalDate.now().getDayOfMonth();
    double VAT = amountOfVAT();
    int quantityOfItems = calculateNumberOfItems();
    double amountOfChange = calculateChange();
    double amountPaid = payment.getAmountPaid();

    ReceiptDTO receiptDTO =
        new ReceiptDTO(totalPrice, timeOfSale, date, VAT, quantityOfItems,
                       amountOfChange, amountPaid, itemBasket);
    return receiptDTO;
  }

  /**
   * Gets the receipt for the sale.
   * @return the receipt for the sale.
   */
  public Receipt getReceipt() {
    double totalPrice = calculateFinalPrice();
    int items = itemBasket.size();
    double VAT = amountOfVAT();
    int quantityOfItems = calculateNumberOfItems();

    ReceiptDTO receiptDTO = getReceiptInformation();
    return new Receipt(totalPrice, items, VAT, receiptDTO, quantityOfItems);
  }

  /**
   * Converts the sale to a SaleDTO object.
   * @return the SaleDTO object representing the sale.
   */
  public SaleDTO toDTO() {
    return new SaleDTO(calculateNumberOfItems(), calculateFinalPrice(),
                       getNameList());
  }

  /**
   * Gets the list of item names in the basket.
   * @return an array of item names.
   */

  private String[] getNameList() {
    String[] name = new String[itemBasket.size()];
    int i = 0;
    for (Item item : itemBasket) {
      name[i] = item.getName();
      i++;
    }
    return name;
  }

  /**
   * Calculates the number of items in the basket.
   *  @return the number of items in the basket.
   */
  private int calculateNumberOfItems() {
    int numberOfItems = 0;
    for (Item item : itemBasket) {
      numberOfItems += item.getQuantity();
    }
    return numberOfItems;
  }

  /**
   * Applies a discount to the total price of the items in the basket.
   * @param amountOfDiscount  the amount of discount to be applied.
   * @return the total price after applying the discount.
   */

  public double applyDiscount(double amountOfDiscount) {
    for (Item item : itemBasket) {
      amountOfDiscount +=
          item.getPrice() * item.getQuantity() * (amountOfDiscount / 100);
    }
    return amountOfDiscount;
  }

  /**
   * Calculates the final price after applying the discount.
   * @param amountOfDiscount the amount of discount to be applied.
   * @return the final price after applying the discount.
   */

  public double calculateFinalPrice() {
    return calculateRunningTotal() - amountOfDiscount;
  }

  /**
   * Gets the amount of VAT for the items in the basket.
   * @return the amount of VAT for the items in the basket.
   */

  public double amountOfVAT() {
    double amountOfVAT = 0;
    for (Item item : itemBasket) {
      amountOfVAT +=
          item.getPrice() * item.getQuantity() * (item.getVAT() / 100);
    }
    return amountOfVAT;
  }

  /**
   * Calculates the change to be given to the customer.
   * @return the amount of change to be given to the customer.
   */

  private double calculateChange() {
    double amountOfChange = payment.getAmountPaid() - calculateFinalPrice();
    return amountOfChange;
  }

  /**
   * Sets the payment.
   * @param payment the payment to be set.
   */

  public void setPayment(Payment payment) { this.payment = payment; }

  /**
   * Gets the list of items in the basket.
   * @return the list of items in the basket.
   */
  public ArrayList<Item> itemBasket() { return itemBasket; }
}
