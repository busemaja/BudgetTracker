package budgettracker;

import java.util.Date;

/**
 * A class representing a single transaction.
 * Consists of Id, name (descriptive, ie "Coffe" or "Petrol"), amount, timestamp, category.
 * 
 * @author Maria Jansson
 * @version 1.0.0
 */

class Transaction {
  private static int idCounter = 1;
  private int Id;
  private String name;
  private double amount;
  private Date date;
  private TransactionCategories category;
  
  Transaction(String name, double amount, TransactionCategories category) {
    this.Id = idCounter++;
    this.name = name;
    this.amount = amount;
    this.date = new Date();
    this.category = category;
  }
  
  String getName() {
    return this.name;
  }
  double getAmount() {
    return this.amount;
  }
  
  TransactionCategories getCategory() {
    return this.category;
  }

  int getId() {
    return this.Id;
  }

  // TODO: lägg till toString()
}
