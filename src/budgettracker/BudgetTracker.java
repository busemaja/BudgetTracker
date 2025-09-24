package budgettracker;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * A lightweight Java module for secure transaction management and financial analysis.
 * Think of it as a digital form of the classic account book, where you list all of your transactions, but with a few more functions making it easier and more fun to keep track and analyze!
 * 
 * @author Maria Jansson
 * @version 1.0.0
 */
public class BudgetTracker {
  private final ArrayList <Transaction> transactions = new ArrayList<>();
  private final ArrayList <LogEntry> transactionLogs = new ArrayList<>();

  public BudgetTracker() {}

  /**
   * Adds a transaction to the active list of transactions, and also adds it to the log.
   * @param transactionName - a descriptive name, for example "Coffee" or "Petrol".
   * @param amount - primitive type double
   * @param category - found in the class TransactionCategories, change there if needed.
   */
  public void addTransactionAndLogIt(String transactionName, double amount, TransactionCategories category) {
    // TODO: add validation of input?
    Transaction transaction = new Transaction(transactionName, amount, category);
    transactions.add(transaction);
    logTransaction(transaction, LogEntry.Action.ADD);
  }

  /**
   * Removes a transaction from the active list, and adds the removal to the log.
   * @param transactionId - the current transaction's unique ID
   */
  public void removeTransactionAndLogIt(int transactionId) {
    try {
      Transaction transaction = getTransaction(transactionId);
      if (transactions.remove(transaction)) {
        logTransaction(transaction, LogEntry.Action.REMOVE);
      }
    } catch (Exception e) {
      System.out.println("Something went wrong, please try again.");
    }
  }

  /**
   * Returns the total sum of all transactions in the active list.
   * @return - the sum as a double
   */
  public double getCurrentTotal() {
    double sum = 0;
    for (Transaction transaction : transactions) {
      sum += transaction.getAmount();
    }
    return sum;
  }

  /**
   * Returns the total sum of all transactions of a certain category in the active list.
   * @param category - found in the class TransactionCategories
   * @return - the sum as a double
   */
  public double getCurrentTotalByCategory(TransactionCategories category) {
    double sum = 0;
    for (Transaction transaction : transactions) {
      if(transaction.getCategory() == category) {
        sum += transaction.getAmount();
      }
    }
    return sum;
  }

  /**
   * Returns the transaction whith the largest amount in the active list.
   * @return - the transaction object
   */
  public Transaction getLargestListedTransaction() {
    ArrayList<Transaction> transactionsCopy = new ArrayList<>(transactions);
    transactionsCopy.sort((transaction1, transaction2) -> 
      Double.compare(transaction1.getAmount(), transaction2.getAmount()));
    return transactionsCopy.get(transactionsCopy.size() - 1);
  }

  private Transaction getTransaction(int transactionId) {
    for (Transaction transaction : transactions) {
      if (transaction.getId() == transactionId) {
        return transaction;
      }
    }
    throw new NoSuchElementException("Transaction with ID " + transactionId + " not found");
  }
  private void logTransaction(Transaction transaction, LogEntry.Action action) {
    LogEntry log;
    switch (action) {
      case ADD:
        log = new LogEntry(LogEntry.Action.ADD, transaction.getId(), transaction.getName(), transaction.getAmount());
      break;
      case REMOVE:
        log = new LogEntry(LogEntry.Action.REMOVE, transaction.getId(), transaction.getName(), transaction.getAmount());
      break;
    }
    transactionLogs.add(log);
  }

}
