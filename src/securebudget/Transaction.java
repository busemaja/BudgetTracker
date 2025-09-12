package securebudget;

import java.util.Date;

/**
 * A class representing a single transaction.
 * Consists of amount, date, category, and an optional description of the transaction.
 * 
 * @author Maria Jansson
 * @version 1.0.0
 */

class Transaction {
  private double amount;
  private Date date;
  private String category;
  private String description;

  /**
   * Constructor.
   */
  Transaction(double amount, String category, String description) {
    this.amount = amount;
    this.date = new Date();
    this.category = category;
    this.description = description;
  }
  
  
}
