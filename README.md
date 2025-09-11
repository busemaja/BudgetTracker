# SecureBudget
A lightweight Java module for secure transaction management and financial analysis.

## Description
SecureBudget is a Java module that allows you to manage financial transactions in a secure and reusable way. 
It was originally developed as part of a software quality course, but can be reused for personal or professional projects.

## Functionality and features
- Add and remove transactions with amount, date, category, and description.
- Compute totals, averages, largest transaction, and summaries by category.
- Secure features:
  - Hashing to ensure data integrity.
  - Optional encryption of stored data.
  - Audit log of all changes to transactions.
- Simple and reusable API suitable for integration into other applications.

## Project structure
- /src        → Main Java source code (the SecureBudget module)
- README.md   → This file
- .gitignore  → Ignored files (compiled classes, IDE files, temp files)
- LICENSE     → Information about the license covering this project

## Installation and usage
- Include the module in your Java project.
- Use the public methods to add, remove, and analyze transactions.
- Optionally, run the demo console app to see example usage.

## Security information
- All transactions are tracked in an internal audit log, recording every addition or removal. 
  This allows you to review all changes made to the data.
- The module includes a simple integrity check:
  - It keeps a running checksum of the total amount and the number of transactions.
  - You can use verifyIntegrity() to detect if any transaction data has been accidentally or maliciously modified.
- Optional file storage can be masked to obscure raw values, providing a basic layer of data privacy.
- All features are implemented using standard Java classes; no external libraries are required.

## License 
This project is open for personal and professional use. 
You are free to reuse and adapt the module in your own projects.  
Please see the [LICENSE](/LICENSE) file for more information.