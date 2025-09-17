package securebudget;

import java.util.ArrayList;

/**
 * A lightweight Java module for secure transaction management and financial analysis.
 * Think of it as a digital form of the classic account book, where you list all of your transactions, but with a few more functions making it easier and more fun to keep track and analyze!
 * 
 * @author Maria Jansson
 * @version 1.0.0
 */
public class SecureBudget {
  /**
   * An arraylist of all transactions made, both positive and negative.
   */
  private ArrayList <Transaction> transactions = new ArrayList<>();
  private ArrayList <AuditLog> transactionLogs = new ArrayList<>();

  /**
   * Constructor.
   */
  public SecureBudget() {}

  /**
   * Adds a transaction.
   */
  public void addTransaction(String transactionName, double amount, TransactionCategories category) {
    // double amount; // positive or negative amount important to differentiate
    // enum category; // need to reach both here and in class Transaction
    Transaction transaction = new Transaction(transactionName, amount, category);

  }

  /**
   * Removes a transaction.
   */
  public void removeTransaction() {}

  /**
   * Returns the current total amount.
   */
  public void getCurrentTotal() {}

  /**
   * Returns the current total amount in a single category.
   */
  public void getCurrentTotalByCategory() {}

  /**
   * Returns the largest listed transaction.
   */
  public void getLargestListedTransaction() {}

}
