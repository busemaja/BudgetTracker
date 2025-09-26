package budgettracker;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The file handler class for the module, currently only writes the transaction log to file.
 * 
 * @author Maria Jansson
 */

class FileHandler {
  private String filePath;

/**
 * Must be set before calling saveLogToFile()
 * @param filePath - Example file path: "src/main/resources/transactionlog.data"
 */
  void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  /**
   * Please remember to set the file path (using setFilePath()) before trying to save to file, otherwise it will not work.
   * @param transactionLog - ArrayList of strings
   */
  public void saveLogToFile(List<LogEntry> transactionLog) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
      writer.write("Action\tID\tTime stamp\tCategory\tName\tAmount");
      writer.newLine();
      for (LogEntry logEntry : transactionLog) {
        writer.write(logEntry.toFormattedString());
        writer.newLine();
      }
    } catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}
