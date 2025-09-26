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
  private final ArrayList <LogEntry> transactionLog = new ArrayList<>();

  public BudgetTracker() {}

  /**
   * Adds a transaction to the list of transactions, and also adds it to the log.
   * @param transactionName - a descriptive name, for example "Coffee" or "Petrol".
   * @param amount - primitive type double
   * @param category - enums found in the file TransactionCategories, change there if needed.
   */
  public void addTransactionAndLogIt(String transactionName, double amount, TransactionCategories category) {
    // TODO: add validation of input?
    Transaction transaction = new Transaction(transactionName, amount, category);
    transactions.add(transaction);
    logTransaction(transaction, LogEntry.Action.ADD);
  }

  /**
   * Removes a transaction from the list of transactions, and also adds the removal to the log.
   * @param transactionId - the current transaction's unique ID
   */
  public void removeTransactionAndLogIt(int transactionId) {
    try {
      Transaction transaction = getTransaction(transactionId);
      Transaction transactionCopyForLog = new Transaction(
        transaction.getName(),
        transaction.getAmount(),
        transaction.getCategory()
      );
      if (transactions.remove(transaction)) {
        logTransaction(transactionCopyForLog, LogEntry.Action.REMOVE);
      }
    } catch (Exception e) {
      System.out.println("Something went wrong, please try again.");
    }
  }

  /**
   * Returns the total sum of all transactions in the list of transactions.
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
   * Returns the total sum of all transactions in the list of transactions that belong to a certain category.
   * @param category - found in the file TransactionCategories
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
   * Returns the info of the transaction with the largest amount in the list of transactions.
   * @return - the info as a String, formatted as: "yyyy-MM-dd CATEGORY Name of transaction Amount with 2 decimals kr" with tabs between the fields.
   */
  public String getInfoOnLargestListedTransaction() {
    ArrayList<Transaction> transactionsCopy = new ArrayList<>(transactions);
    transactionsCopy.sort((transaction1, transaction2) -> 
      Double.compare(transaction1.getAmount(), transaction2.getAmount()));
    
    Transaction transaction = transactionsCopy.get(transactionsCopy.size() - 1);
    String transactionInfo = transaction.toFormattedString();
    
    return transactionInfo;
  }

  /**
   * Returns an arraylist of all logged transaction events as strings.
   * @return 
   */
  public ArrayList<String> getTransactionLog() {
    ArrayList <String> transactionLogCopy = new ArrayList<>();
    for (LogEntry entry : transactionLog) {
      transactionLogCopy.add(entry.toFormattedString());
    }
    return transactionLogCopy;
  }

  // Returns the actual transaction object, so be careful what you do with it!
  private Transaction getTransaction(int transactionId) {
    for (Transaction transaction : transactions) {
      if (transaction.getId() == transactionId) {
        return transaction;
      }
    }
    throw new NoSuchElementException("Transaction with ID " + transactionId + " not found");
  }

  // Logs the transaction, available actions found in class LogEntry.
  private void logTransaction(Transaction transaction, LogEntry.Action action) {
    LogEntry log;
    switch (action) {
      case ADD:
        log = new LogEntry(LogEntry.Action.ADD, transaction.getCategory(), transaction.getId(), transaction.getName(), transaction.getAmount());
      break;
      case REMOVE:
        log = new LogEntry(LogEntry.Action.REMOVE, transaction.getCategory(), transaction.getId(), transaction.getName(), transaction.getAmount());
      break;
      default:
        throw new RuntimeException("Action not found.");
    }
    transactionLog.add(log);
  }

}
