package budgettracker;

import java.time.LocalDateTime;

/**
 * A class representing a single log post for a transaction.
 * 
 * @author Maria Jansson
 */

public class LogEntry {
  private LocalDateTime timestamp;
  private Action action;
  private int transactionId;
  private String name;
  private double amount;

  /**
   * The only allowed actions for a log entry is ADD and REMOVE at this point.
   */
  public enum Action {
    ADD, 
    REMOVE
  }

  LogEntry(Action action, int transactionId, String name, double amount) {
    this.timestamp = LocalDateTime.now();
    this.action = action;
    this.transactionId = transactionId;
    this.name = name;
    this.amount = amount;
  }
  
}
