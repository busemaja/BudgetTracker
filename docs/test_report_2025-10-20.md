# Test report
**Date:** 2025-10-20  
**Module version:** 2.0.0  
**System:** Windows 11 pro  
**Tester:** Maria Jansson  

**Notes:**  
All tests run as expected.  
Known issue: removal log shows a new ID; test output demonstrates the bug; fix pending.  

Output:  
```
Test 1: Add transactions
Current total (Expect: 23822,18): 23822,18

Test 2: Remove transaction
Current total after removal (Expect: 18318,51): 18318,51

Test 2b: Remove non-existing transaction (Expect NoSuchElementException)
Caught expected NoSuchElementException: Transaction with ID 99999 not found

Test 3: Get total by category
FOOD (Expect: 625.50): 625,50
HOUSING (Expect: 7503.67): 7503,67

Test 4: Get info on largest transaction
4       2025-10-20 19:13        HOUSING Hyra    7503,67kr

Test 5: Get percentages by category
FOOD 3,41%
HOUSING 40,96%
UTILITIES 8,19%
TRANSPORTATION 3,07%
INSURANCE 8,19%
HOUSEHOLD 2,46%
PERSONAL 4,36%
ENTERTAINMENT 1,64%
SAVINGS 27,72%

Test 5b: Percentages with empty tracker

Test 6: Transaction log
Action  ID      Timestamp       Category        Name    Amount
ADD     1       2025-10-20 19:13        FOOD    Fika    25,50kr
ADD     2       2025-10-20 19:13        TRANSPORTATION  Bensin  562,00kr
ADD     3       2025-10-20 19:13        HOUSING Hyra    5503,67kr
ADD     4       2025-10-20 19:13        HOUSING Hyra    7503,67kr
ADD     5       2025-10-20 19:13        UTILITIES       Elräkning       1200,00kr
ADD     6       2025-10-20 19:13        UTILITIES       Vatten  300,00kr
ADD     7       2025-10-20 19:13        INSURANCE       Bilförsäkring   1500,00kr
ADD     8       2025-10-20 19:13        HOUSEHOLD       Städning        450,34kr
ADD     9       2025-10-20 19:13        ENTERTAINMENT   Bio     200,00kr
ADD     10      2025-10-20 19:13        ENTERTAINMENT   Spotify 99,78kr
ADD     11      2025-10-20 19:13        PERSONAL        Klänning        799,00kr
ADD     12      2025-10-20 19:13        SAVINGS Semester        5078,22kr
ADD     13      2025-10-20 19:13        FOOD    Matvaror        600,00kr
REMOVE  14      2025-10-20 19:13        HOUSING Hyra    5503,67kr

Test 7: Save log to file
Log saved to directory: src/data/

Test 7b: Save log to invalid file path (Expect IOException)
Caught expected IOException: \invalid\path\that\does\not\exist\transactionlog_2025-10-20.txt (Det går inte att hitta sökvägen)

Test 7c: Save log to null/empty path (Expect IllegalArgumentException)
Caught expected exception: Directory path must not be null or empty.
Caught expected exception: Directory path must not be null or empty.
```