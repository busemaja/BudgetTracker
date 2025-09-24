# BudgetTracker
A lightweight Java module for secure transaction management and financial analysis.

## Description
BudgetTracker is a Java module that allows you to manage financial transactions in a simple and reusable way. 
It was originally developed as part of a software quality course, but can be reused for personal or professional projects.

## Functionality and features
- Add and remove transactions with amount, date, category, and name.
- Compute totals, largest transaction, and summaries by category.
- Audit log of all transactions.
- Simple and reusable API suitable for integration into other applications.

## Project structure
- /src        → Main Java source code (the BudgetTracker module)
- README.md   → This file
- .gitignore  → Ignored files (compiled classes, IDE files, temp files)
- LICENSE     → Information about the license covering this project

## Installation and usage
- Include the module in your Java project.
- Use the public methods to add, remove, and analyze transactions.

## Module information
- All transactions are tracked in an internal audit log, recording every addition or removal. 
  This allows you to review all changes made to the data.
- All features are implemented using standard Java classes; no external libraries are required.

## License 
This project is open for personal and professional use. 
You are free to reuse and adapt the module in your own projects.  
Please see the [LICENSE](/LICENSE) file for more information.