package se.kth.iv1350.createpos.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DiscountDataBaseTest {
  private DiscountDataBase discountDB;

  @BeforeEach
  public void setUp() {
    discountDB = new DiscountDataBase(8769);
  }

  @Test
  public void testFetchDiscount() {
    int customerID = 8769;
    double expectedDiscount = 0.00;
    double actualDiscount = discountDB.fetchDiscount(customerID);
    assertEquals(expectedDiscount, actualDiscount,
                 "The discount should be the same as the one in the database");
  }
}
