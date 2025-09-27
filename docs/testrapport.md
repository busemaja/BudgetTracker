# Testrapport: BudgetTracker

## Summering

Modulen BudgetTracker har testats genom en separat testapplikation (`Test.java`) som körs från terminalen. Testapplikationen skapar en instans av BudgetTracker, lägger till och tar bort transaktioner, och anropar alla publika metoder. Resultaten skrivs ut i konsolen och jämförs manuellt med förväntade värden. För att utföra testet, kör `Test.java` och jämför utdata med tabellen nedan.

---

| Vad som testats (metod/krav)                | Hur det testats (beskrivning)                                                                 | Testresultat (förväntat/utfört)                |
|---------------------------------------------|----------------------------------------------------------------------------------------------|------------------------------------------------|
| addTransactionAndLogIt                      | Lägger till flera transaktioner och kontrollerar totalen                                      | Totalen ökar korrekt, loggposter skapas        |
| removeTransactionAndLogIt                   | Tar bort en transaktion och kontrollerar att totalen minskar                                  | Totalen minskar, loggpost för borttagning      |
| removeTransactionAndLogIt (felaktigt id)    | Försöker ta bort en transaktion med ogiltigt id                                               | Felmeddelande skrivs ut                        |
| getCurrentTotalByCategory                   | Hämtar totalsumma för en kategori                                                             | Rätt summa returneras                          |
| getInfoOnLargestTransaction                 | Hämtar info om största transaktionen                                                          | Rätt transaktion returneras                    |
| getPercentagesByCategory                    | Hämtar procentuell fördelning mellan kategorier                                               | Procentvärden stämmer                          |
| getTransactionLog                           | Hämtar logg och kontrollerar att alla händelser finns med                                     | Loggen innehåller alla poster                  |
| saveLogToFile                               | Sparar loggen till fil och kontrollerar att filen skapas                                      | Filen skapas, innehåll stämmer                 |
| saveLogToFile (ogiltig sökväg)              | Försöker spara loggen till ogiltig sökväg                                                     | Felmeddelande skrivs ut                        |

---
