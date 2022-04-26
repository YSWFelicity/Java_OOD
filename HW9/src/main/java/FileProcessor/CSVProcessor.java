package FileProcessor;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * CSVProcessor is a class to help to read in the csv file, extract the user's information
 * and save the information in a list of list of string.
 */
public class CSVProcessor {

  private static String DELIMITER = "\"*,*\"";
  private List<String> headerInfo = new ArrayList<>();
  private List<List<String>> allInfoList = new ArrayList<>();
  private String csvFilePath;

  /**
   * Constructor
   *
   * @param csvFilePath - the file path of the csv file, expected as a String
   * @throws IOException
   */
  public CSVProcessor(String csvFilePath) throws IOException {
    this.csvFilePath  = csvFilePath;
    this.readInCSV(this.csvFilePath);
  }

  /**
   * Getter
   *
   * @return the file path of the csv file, expected as a String
   */
  public String getCsvFilePath() {
    return csvFilePath;
  }

  /**
   * Getter
   *
   * @return the header info of the csv file, expected as a List of string.
   */
  public List<String> getHeaderInfo() {
    return headerInfo;
  }

  /**
   * Getter
   *
   * @return the all info list csv file, expected as a list of list of string.
   */
  public List<List<String>> getAllInfoList() {
    return allInfoList;
  }

  /**
   * readInCSV is a method to read in the csv file
   *
   * @param csvFilePath -the file path of the csv file, expected as a String
   * @throws IOException : the IOException is thrown when the file cannot be read in.
   */
  public void readInCSV(String csvFilePath) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(csvFilePath));
    String[] firstRowNames = br.readLine().split(DELIMITER); // read in the first row and save it in a list of string

    for (int i = 1; i < firstRowNames.length; i++) {
      String str = firstRowNames[i].replace("\"", "");
      if (!(str.isEmpty()))
        headerInfo.add(str);
    }
//        System.out.println("The header is: " + this.headerInfo);
    String line;
    while ((line = br.readLine()) != null) {
      String[] info = line.split(DELIMITER);
      List<String> eachRow = new ArrayList<>();
      for (int i = 1; i < info.length; i++) {
        String str = info[i].replace("\"", "");
        if (!str.isEmpty())
          eachRow.add(str);
      }
      allInfoList.add(eachRow);
    }
//        System.out.println("The to do csv: " + this.allInfoList);
  }

  /**
   * equals is a method to determine whether an object has equal fields to current object
   *
   * @param o - another object to be compared to current object
   * @return true if these two objects have the same fields in general.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CSVProcessor)) return false;
    CSVProcessor that = (CSVProcessor) o;
    return Objects.equals(getHeaderInfo(), that.getHeaderInfo()) && Objects.equals(getAllInfoList(), that.getAllInfoList()) && Objects.equals(getCsvFilePath(), that.getCsvFilePath());
  }

  /**
   * hashCode is a method to get the hashcode of an object
   *
   * @return the hashcode value of an object
   */
  @Override
  public int hashCode() {
    return Objects.hash(getHeaderInfo(), getAllInfoList(), getCsvFilePath());
  }

  /**
   * toString is a method to get the string representation of the current object
   *
   * @return the string that contains the info of the current object.
   */
  @Override
  public String toString() {
    return "CSVProcessor{" +
        "headerInfoMap=" + headerInfo +
        ", allInfoList=" + allInfoList +
        ", csvFilePath='" + csvFilePath + '\'' +
        '}';
  }
}