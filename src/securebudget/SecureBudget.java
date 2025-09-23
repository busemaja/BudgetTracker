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
  private ArrayList <Transaction> transactions = new ArrayList<>();
  private ArrayList <TransactionLog> transactionLogs = new ArrayList<>();

  public SecureBudget() {}

  public void addTransactionAndLogIt(String transactionName, double amount, TransactionCategories category) {
    // TODO: add validation of input?
    Transaction transaction = new Transaction(transactionName, amount, category);
    transactions.add(transaction);
    logTransaction(transaction);
  }

  public void removeTransactionAndLogIt(Transaction transaction) {
    try {
      if (transactions.remove(transaction)) {
        logTransaction(transaction);
      }
    } catch (Exception e) {
      System.out.println("Something went wrong, please try again.");
    }
  }

  public void getCurrentTotal() {}

  public void getCurrentTotalByCategory() {}

  public void getLargestListedTransaction() {}

  private void logTransaction(Transaction transaction) {
    // TODO: convert the following values to strings and log per transaction:
    // date and time
    // category
    // name
    // amount
    // transactionLogs.add(formattedTransaction?)
  }

}
