import budgettracker.BudgetTracker;
import budgettracker.TransactionCategories;
import java.util.ArrayList;

/**
 * The starting point of the application.
 * 
 * @author Maria Jansson
 * @version 1.0.0
 */

public class Main {
  public static void main(String[] args) {
    BudgetTracker budgetManager = new BudgetTracker();
    
    String transactionName1 = "Fika";
    double amount1 = 25.50;
    TransactionCategories category1 = TransactionCategories.FOOD;

    String transactionName2 = "Bensin";
    double amount2 = 562;
    TransactionCategories category2 = TransactionCategories.TRANSPORTATION;

    String transactionName3 = "Hyra";
    double amount3 = 7503.67;
    TransactionCategories category3 = TransactionCategories.HOUSING;

    String transactionName4 = "Hyra";
    double amount4 = 5503.67;

    int id1 = budgetManager.addTransactionAndLogIt(transactionName1, amount1, category1);
    int id2 = budgetManager.addTransactionAndLogIt(transactionName2, amount2, category2);
    int id3 = budgetManager.addTransactionAndLogIt(transactionName3, amount3, category3);
    int id4 = budgetManager.addTransactionAndLogIt(transactionName4, amount4, category3);

    System.out.println(budgetManager.getCurrentTotal());
    System.out.println(budgetManager.getCurrentTotalByCategory(category3));
    System.out.println(budgetManager.getInfoOnLargestTransaction());
    
    ArrayList<String> log1 = budgetManager.getTransactionLog();
    System.out.println("Log 1:");
    System.out.println("Action\tID\tTimestamp\tCategory\tName\tAmount");
    for (String entry : log1) {
      System.out.println(entry);
    }

    budgetManager.removeTransactionAndLogIt(id4);
    
    ArrayList<String> log2 = budgetManager.getTransactionLog();
    System.out.println("Log 2:");
    System.out.println("Action\tID\tTimestamp\tCategory\tName\tAmount");
    for (String entry : log2) {
      System.out.println(entry);
    }

    String filename = "src/data/transactionlog.txt";
    budgetManager.saveLogToFile(filename);

  }
}
