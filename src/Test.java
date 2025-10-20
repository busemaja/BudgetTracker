/**
 * Testing class for the BudgetTracker module.
 * 
 * @author Maria Jansson
 */

import budgettracker.BudgetTracker;
import budgettracker.TransactionCategories;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Test {
  public static void main(String[] args) {
    BudgetTracker tracker = new BudgetTracker();

    // Test 1: Add transactions
    System.out.println("Test 1: Add transactions");
    tracker.addTransactionAndLogIt("Fika", 25.50, TransactionCategories.FOOD);
    tracker.addTransactionAndLogIt("Bensin", 562, TransactionCategories.TRANSPORTATION);
    int id4 = tracker.addTransactionAndLogIt("Hyra", 5503.67, TransactionCategories.HOUSING); // Will be removed later
    tracker.addTransactionAndLogIt("Hyra", 7503.67, TransactionCategories.HOUSING);
    tracker.addTransactionAndLogIt("Elräkning", 1200.00, TransactionCategories.UTILITIES);
    tracker.addTransactionAndLogIt("Vatten", 300.00, TransactionCategories.UTILITIES);
    tracker.addTransactionAndLogIt("Bilförsäkring", 1500.00, TransactionCategories.INSURANCE);
    tracker.addTransactionAndLogIt("Städning", 450.34, TransactionCategories.HOUSEHOLD);
    tracker.addTransactionAndLogIt("Bio", 200.00, TransactionCategories.ENTERTAINMENT);
    tracker.addTransactionAndLogIt("Spotify", 99.78, TransactionCategories.ENTERTAINMENT);
    tracker.addTransactionAndLogIt("Klänning", 799.00, TransactionCategories.PERSONAL);
    tracker.addTransactionAndLogIt("Semester", 5078.22, TransactionCategories.SAVINGS);
    tracker.addTransactionAndLogIt("Matvaror", 600.00, TransactionCategories.FOOD);

    double expectedTotal = 23822.18;
    double actualTotal = tracker.getCurrentTotal();
    System.out.println("Current total (Expect: 23822,18): " + String.format("%.2f", actualTotal));
    assert Math.abs(actualTotal - expectedTotal) < 0.01 : "Total mismatch!";

    // Test 2: Remove transaction
    System.out.println("\nTest 2: Remove transaction");
    tracker.removeTransactionAndLogIt(id4);
    double expectedTotalAfterRemoval = 18318.51;
    actualTotal = tracker.getCurrentTotal();
    System.out.println("Current total after removal (Expect: 18318,51): " + String.format("%.2f", actualTotal));
    assert Math.abs(actualTotal - expectedTotalAfterRemoval) < 0.01 : "Total after removal mismatch!";

    // Negative test: remove non-existing transaction
    System.out.println("\nTest 2b: Remove non-existing transaction (Expect NoSuchElementException)");
    try {
      tracker.removeTransactionAndLogIt(99999);
      System.out.println("Unexpected: no exception thrown");
    } catch (NoSuchElementException e) {
      System.out.println("Caught expected NoSuchElementException: " + e.getMessage());
    }

    // Test 3: Get total by category
    System.out.println("\nTest 3: Get total by category");
    System.out.println("FOOD (Expect: 625,50): " + String.format("%.2f", tracker.getCurrentTotalByCategory(TransactionCategories.FOOD)));
    System.out.println("HOUSING (Expect: 7503,67): " + String.format("%.2f", tracker.getCurrentTotalByCategory(TransactionCategories.HOUSING)));

    // Test 4: Get info on largest transaction
    System.out.println("\nTest 4: Get info on largest transaction");
    System.out.println(tracker.getInfoOnLargestTransaction());

    // Test 5: Get percentages by category
    System.out.println("\nTest 5: Get percentages by category");
    String[] percentages = tracker.getPercentagesByCategory();
    for (String entry : percentages) {
      System.out.println(entry);
    }

    // Negative test: percentages when total is 0
    System.out.println("\nTest 5b: Percentages with empty tracker");
    BudgetTracker emptyTracker = new BudgetTracker();
    String[] emptyPercentages = emptyTracker.getPercentagesByCategory();
    for (String entry : emptyPercentages) {
      assert entry == null : "Expected null for empty tracker";
    }

    // Test 6: Transaction log
    System.out.println("\nTest 6: Transaction log");
    ArrayList<String> log = tracker.getTransactionLog();
    System.out.println("Action\tID\tTimestamp\tCategory\tName\tAmount");
    for (String entry : log) {
      System.out.println(entry);
    }

    // Test 7: Save log to file
    System.out.println("\nTest 7: Save log to file");
    String validDir = "src/data/";
    try {
      tracker.saveLogToFile(validDir);
      
      System.out.println("Log saved to directory: " + validDir);
    } catch (Exception e) {
      System.out.println("Unexpected exception when saving log to valid directory: " + e);
    }

    // Negative test: invalid file path (should throw IOException)
    System.out.println("\nTest 7b: Save log to invalid file path (Expect IOException)");
    String invalidDir = "/invalid/path/that/does/not/exist";
    try {
      tracker.saveLogToFile(invalidDir);
      System.out.println("Log saved to invalid directory (unexpected)");
    } catch (java.io.IOException e) {
      System.out.println("Caught expected IOException: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Caught unexpected exception: " + e);
    }

    // Negative test: null or empty path (should throw IllegalArgumentException)
    System.out.println("\nTest 7c: Save log to null/empty path (Expect IllegalArgumentException)");
    try {
      tracker.saveLogToFile(null);
    } catch (IllegalArgumentException e) {
      System.out.println("Caught expected exception: " + e.getMessage());
    } catch (java.io.IOException e) {
      System.out.println("Caught unexpected IOException: " + e.getMessage());
    }
    try {
      tracker.saveLogToFile("");
    } catch (IllegalArgumentException e) {
      System.out.println("Caught expected exception: " + e.getMessage());
    } catch (java.io.IOException e) {
      System.out.println("Caught unexpected IOException: " + e.getMessage());
    }
  }
}

