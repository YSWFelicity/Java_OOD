package FileProcessor;


import Model.Builder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * CSV Writer is a method to write and update the csv file
 */
public class CSVWriter {
  private String csvFilePath;
  private List<String> headerInfo;
  private List<List<String>> allInfoList = new ArrayList<>();
  private static final String COMPLETED_HEADER = "completed";


  /**
   * Constructor
   *
   * @param csvFilePath - the given csv file path, expected as a string
   * @throws IOException - IOException will be thrown when the file cannot be read in
   */
  public CSVWriter(String csvFilePath) throws IOException {
    this.csvFilePath = csvFilePath;
    this.readInCSV(this.csvFilePath); // load the headInfo and the allInfoList from the todo_ csv file
  }


  /**
   * readInCSV is a method to read in the csv file
   *
   * @param csvFilePath - the given path of the csv file, expected as a string.
   * @throws IOException - IOException will be thrown when the file cannot be read in
   */
  public void readInCSV(String csvFilePath) throws IOException {
    CSVProcessor csvProcessor = new CSVProcessor(csvFilePath);
    this.headerInfo = csvProcessor.getHeaderInfo();
    this.allInfoList = csvProcessor.getAllInfoList();
  }


  /**
   * AddNewToDoUpdateCSVFile is a method to add the new to do to the csv file
   *
   * @param builder - the builder of the new to do object
   * @throws IOException - the exception will be thrown if the csv file cannot be written
   */
  public void AddNewToDoUpdateCSVFile(Builder builder) throws IOException {
    // 是否应该更新那个a list of list of string，然后再根据那个来write！！！, 怎么加入新一行的呢？？？
    // 应该再原来的list of list string里面，加入一个新的list of string，然后更新这个list of list string，然后再来根据这个新的list
    // of list of string来写文件。
    List<String> newTodo = new ArrayList<>();
    // get the last id from the allInfoList, and then increment it by 1;
    Integer size = this.allInfoList.size();
    Integer previousID = Integer.valueOf(this.allInfoList.get(size - 1).get(0));
    Integer newID = previousID + 1;
    newTodo.add(String.valueOf(newID));
    newTodo.add(builder.getText());
    newTodo.add(String.valueOf(builder.getCompleted()));
    newTodo.add(String.valueOf(builder.getDue()));
    newTodo.add(String.valueOf(builder.getPriority()));
    newTodo.add(builder.getCategory());

    this.allInfoList.add(newTodo); // update the list of list of string
    this.updateTheTodoCSVFile();
  }

  /**
   * completeExistingTodoUpdateCSVFile is a method to update the given to do object
   * as completed
   * @param id
   * @throws IOException
   * @throws InvalidIndexException
   */
  public void completeExistingTodoUpdateCSVFile(Integer id) throws IOException, InvalidIndexException {
    Integer todoObjectIndexInCSV = id - 1;
    if (todoObjectIndexInCSV < 0 || todoObjectIndexInCSV > this.allInfoList.size())
      throw new InvalidIndexException("Error: The id given is invalid!");
    // get the to do list of string to be updated
    List<String> todoToBeUpdated = this.allInfoList.get(todoObjectIndexInCSV);
    // get the index of the todo_ object where it shall be updated
    Integer indexOfCompleted = this.headerInfo.indexOf(COMPLETED_HEADER);
    // use the index where the completed column of the todo_ to update the completed value;
    todoToBeUpdated.set(indexOfCompleted, "true");
    this.updateTheTodoCSVFile();
  }

  /**
   * updateTheTodoCSVFile is a method to update the csv file
   *
   * @throws IOException - the exception will be thrown if the csv file can not be written.
   */
  // rewrite the csv file. the same fileName;
  public void updateTheTodoCSVFile() throws IOException {
    if (!this.csvFilePath.endsWith(File.separator)){
      this.csvFilePath = this.csvFilePath + File.separator;
    }
    // save the fileNames in the designated output dir.
    String fileName = this.csvFilePath;
    FileWriter writer = new FileWriter(fileName);
    // write file for the header;
    int a = 0;
    for (String str: this.headerInfo) // the key in the map is unsorted. !!!可以直接用 String[]存
    {
      if (a == this.headerInfo.size() - 1){
        writer.write( "\"" + "\"" + str+ "\"" + "\""); // add single quotes on one side "\"";
      }else{
        writer.write(  "\"" + "\"" + str + "\"" + "\"" + ',');
      }
      a += 1;
    }
    writer.write(System.lineSeparator());

    for (List<String> oneRow : this.allInfoList){
      for (int i = 0; i < oneRow.size();i++)
      {
        if (i != oneRow.size() - 1){
          writer.write("\"" + "\"" + oneRow.get(i) + "\"" + "\"" + ',');
        }
        else{
          writer.write("\"" + "\"" + oneRow.get(i) + "\"" + "\"");
        }
      }
      writer.write(System.lineSeparator());
    }
    writer.close();
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
    if (!(o instanceof CSVWriter)) return false;
    CSVWriter csvWriter = (CSVWriter) o;
    return Objects.equals(csvFilePath, csvWriter.csvFilePath) && Objects.equals(headerInfo, csvWriter.headerInfo) && Objects.equals(allInfoList, csvWriter.allInfoList);
  }


  /**
   * hashCode is a method to get the hashcode of an object
   *
   * @return the hashcode value of an object
   */
  @Override
  public int hashCode() {
    return Objects.hash(csvFilePath, headerInfo, allInfoList);
  }


  /**
   * toString is a method to get the string representation of the current object
   *
   * @return the string that contains the info of the current object.
   */
  @Override
  public String toString() {
    return "CSVWriter{" +
        "csvFilePath='" + csvFilePath + '\'' +
        ", headerInfoMap=" + headerInfo +
        ", allInfoList=" + allInfoList +
        '}';
  }

}
