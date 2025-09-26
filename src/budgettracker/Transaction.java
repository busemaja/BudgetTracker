package budgettracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A class representing a single transaction.
 * Consists of Id, name (descriptive, ie "Coffe" or "Petrol"), amount, timestamp, category.
 * 
 * @author Maria Jansson
 */

class Transaction {
  private static int idCounter = 1;
  private int Id;
  private String name;
  private double amount;
  private LocalDateTime timestamp;
  private TransactionCategories category;
  
  Transaction(String name, double amount, TransactionCategories category) {
    this.Id = idCounter++;
    this.name = name;
    this.amount = amount;
    this.timestamp = LocalDateTime.now();
    this.category = category;
  }
  
  String getTimestamp() {
    DateTimeFormatter wantedDateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String formattedDateTime = this.timestamp.format(wantedDateTimeFormat);
    return formattedDateTime;
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

  // Returns format "yyyy-MM-dd CATEGORY Name of transaction Amount with 2 decimals kr" with tabs between the fields.
  public String toFormattedString() {
    return this.getTimestamp() + "\t" + this.getCategory() + "\t" + this.getName() + "\t" + String.format("%.2f", this.getAmount()) + "kr";
  }
}
