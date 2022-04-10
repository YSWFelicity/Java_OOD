package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


/**
 * A class that get csv file info to a new ArrayList.
 */
public class CSVProcessor {

  List<Map<String, String>> personInformationList = new ArrayList<>();

  private static final String DELIMITER = "\"*,*\"";

  public CSVProcessor(String csvFilePath) throws IOException {
      this.personInformationList = this.collectCSVData(csvFilePath);
  }

  //  private ArrayList<Person> personInformationList = new ArrayList<>();

//  private static final Integer ZERO = 0;
//  private static final Integer ONE = 1;
//  private static final Integer TWO = 2;
//  private static final Integer THREE = 3;
//  private static final Integer FOUR = 4;
//  private static final Integer FIVE = 5;
//  private static final Integer SIX = 6;
//  private static final Integer SEVEN = 7;
//  private static final Integer EIGHT = 8;
//  private static final Integer NINE = 9;
//  private static final Integer TEN = 10;
//  private static final Integer ELEVEN = 11;

  /**
   * BufferRead csv file info to store and temporary file and return this ArrayList.
   *
   * @param csvFilePath, String cvs file path
   * @return ArrayList personInformationList
   */
  public List<Map<String, String>> collectCSVData(String csvFilePath) throws IOException {

    BufferedReader in = new BufferedReader(new FileReader(csvFilePath));
    String line = in.readLine();
    String[] headers = line.split(DELIMITER);
    for (String header: headers) {
      header = header.replace("\"", "");
    }
    List<Map<String, String>> infoList = new ArrayList<>();
    while ((line = in.readLine()) != null) {
      Map<String, String> user = new HashMap<>();
      String[] info = line.split(DELIMITER);
      for (String item: info) {
        item = item.replace("\"", "");
      }
      for (int i = 0; i < headers.length; i++){
        user.put(headers[i], info[i]);
      }
      infoList.add(user);
    }
    return infoList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CSVProcessor that = (CSVProcessor) o;
    return Objects.equals(personInformationList, that.personInformationList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(personInformationList);
  }

  @Override
  public String toString() {
    return "CSVProcessor{" +
        "personInformationList=" + personInformationList +
        '}';
  }
}