/**
 * The file handler class for the module, can currently only write the transaction log to file.
 * 
 * @author Maria Jansson
 */

package budgettracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;

class FileHandler {

  /**
   * @param transactionLog - ArrayList of strings
   */
  void saveLogToFile(ArrayList<String> transactionLog, String directoryPath) throws IOException{
    LocalDate date = LocalDate.now();
    Path filePath = Path.of(directoryPath, "transactionlog_" + date + ".txt");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath.toString()))) {
      writer.write("Action\tID\tTime stamp\tCategory\tName\tAmount");
      writer.newLine();
      for (String logEntry : transactionLog) {
        writer.write(logEntry);
        writer.newLine();
      }
    }
  }
}
