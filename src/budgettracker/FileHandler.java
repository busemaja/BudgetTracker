package budgettracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The file handler class for the module, currently only writes the transaction log to file.
 * Please remember to set the file path (using setFilePath()) before trying to save to file. Example file path: "src/main/resources/transactionlog.data"
 * 
 * @author Maria Jansson
 */

class FileHandler {
  private static String FILE_NAME;
  public void saveLogToFile(List<LogEntry> transactionLog) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
      for (LogEntry logEntry : transactionLog) {
        writer.write(logEntry.toFormattedString());
        writer.newLine();
      }
    } catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}
