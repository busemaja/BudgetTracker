# BudgetTracker
A lightweight Java module for secure transaction management and financial analysis.

## Description
BudgetTracker is a Java module that allows you to manage financial transactions in a simple and reusable way. 
It was originally developed as part of a software quality course, but can be freely reused for personal or professional projects.
>Please note that this module uses double instead of BigDecimal, which means that number size is limited and calculation accuracy is not optimal.

## Quick Start Example
```java
import budgettracker.*;

public class Main {
  public static void main(String[] args) {
    BudgetTracker tracker = new BudgetTracker();
    int id = tracker.addTransactionAndLogIt("Coffee", 45.50, TransactionCategories.FOOD);
    tracker.removeTransactionAndLogIt(id);
    System.out.println(tracker.getCurrentTotal());
    System.out.println(tracker.getInfoOnLargestTransaction());
  }
}
```

## Functionality and features

BudgetTracker provides:
- Addition and removal of transactions
- Categorization of transactions (e.g., FOOD, TRANSPORTATION, HOUSING)
- Calculation of totals and percentages by category
- Audit logging of all transaction events
- Easy integration into other Java applications

## Public API Methods
- `addTransactionAndLogIt(String name, double amount, TransactionCategories category)`: Add a transaction and log it.
- `removeTransactionAndLogIt(int transactionId)`: Remove a transaction and log the removal.
- `getCurrentTotal()`: Get the total sum of all transactions.
- `getCurrentTotalByCategory(TransactionCategories category)`: Get the total for a specific category.
- `getInfoOnLargestTransaction()`: Get info on the largest transaction.
- `getPercentagesByCategory()`: Get percentage breakdown by category.
- `getTransactionLog()`: Get a copy of the full transaction log as an ArrayList.
- `saveLogToFile(String filepath)`: Save the transaction log to a file.

## Project structure

The main files and folders are:
- `src/` — Java source code, including the BudgetTracker module and supporting classes
- `README.md` — Project documentation
- `.gitignore` — Git ignore rules for build artifacts and IDE files
- `LICENSE` — License information

## Requirements
- Java 11 or higher

## Installation and usage

1. Clone or download the repository.
2. Add the `src/budgettracker` folder to your Java project.
3. Use the public API methods to manage and analyze transactions.
4. See the Quick Start Example above for basic usage.

## Module information
BudgetTracker maintains an internal audit log of every transaction added or removed. This log records:
- The action performed (add/remove)
- Transaction details (id, category, name, amount, timestamp)  

You can review the log to see a complete history of changes, and export it to a file for further analysis or record-keeping.

## Contributing
Contributions are welcome! Please fork the repository and submit a pull request with your improvements.

## Author
Maria Jansson  
Contact: [maria.elvira.jansson@gmail.com]

## License 
This project is open for personal and professional use. 
You are free to reuse and adapt the module in your own projects.  
Please see the [LICENSE](/LICENSE) file for more information.
