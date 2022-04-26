package Viewer;

import FileProcessor.CSVProcessor;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * TodoViewer is a class that displays all to dos to the user in the terminal
 *
 */
public class TodoViewer {
  private String csvFilePath;
  private List<String> headerInfo;
  private List<List<String>> allInfoList = new ArrayList<>();
  private static final String FALSE = "false";
  private static final Integer CATEGORY_HEADER_INDEX = 5;
  private static final Integer COMPLETED_HEADER_INDEX = 2;

  /**
   * Constructor
   *
   * @param csvFilePath - the given csv file path, expected as a string
   * @throws IOException - IOException will be thrown when the file cannot be read in
   */
  public TodoViewer(String csvFilePath) throws IOException {
    this.csvFilePath = csvFilePath;
    this.readInCSV(this.csvFilePath); // load the headInfo map and the allInfoList from the todo_ csv file
  }

  /**
   * readInCSV is a method to read in the csv file and load the header and the all to dos information
   *
   * @param csvFilePath - the given csv file path, expected as a string
   * @throws IOException - IOException will be thrown when the file cannot be read in
   */
  public void readInCSV(String csvFilePath) throws IOException {
    CSVProcessor csvProcessor = new CSVProcessor(csvFilePath);
    this.headerInfo = csvProcessor.getHeaderInfo();
    this.allInfoList = csvProcessor.getAllInfoList();
  }

  /**
   * filterIncomplete is a method to filter the to dos that are incomplete yet.
   *
   * @return the filtered to do tasks, expected a list of list of string.
   */
  public List<List<String>> filterIncomplete() {
    List<List<String>> filteredTodo = new ArrayList<>();
    for (List<String> oneTodo : this.allInfoList){
//            Integer index = this.headerInfo.indexOf(COMPLETED_HEADER);
      if (oneTodo.get(COMPLETED_HEADER_INDEX).equals(FALSE)){
        filteredTodo.add(oneTodo);
      }
    }
    return filteredTodo;

  }

  /**
   * filterByCategory is a method to filter the to dos whose category matches the given
   * category
   * @param category - the given category, a string
   * @return the filtered to do tasks, expected a list of list of string.
   */
  public List<List<String>> filterByCategory(String category) {
    List<List<String>> filteredTodo = new ArrayList<>();
    for (List<String> oneTodo : this.allInfoList){
//            Integer index = this.headerInfo.indexOf(CATEGORY_HEADER);
      if (oneTodo.get(CATEGORY_HEADER_INDEX).equals(category)){
        filteredTodo.add(oneTodo);
      }
    }
    return filteredTodo;
  }

  /**
   * sortByPriority is a method to sort all to dos by priority
   * and update the allInfoList
   *
   */
  public void sortByPriority() {
    Collections.sort(this.allInfoList, Comparator.comparingInt(a -> Integer.parseInt(a.get(4)))); // allInfo list
  }

  /**
   *  sortByDue is a method to sort all to dos by due date
   *  and update the allInfoList
   *
   */
  public void sortByDue() {
    Collections.sort(this.allInfoList, (a, b) -> {
      try {
        return new SimpleDateFormat("yyyy-MM-dd").parse(a.get(3)).compareTo(new SimpleDateFormat("yyyy-MM-dd").parse(b.get(3)));
      } catch (ParseException e) {
        e.printStackTrace();
      }
      return 0;
    });
  }

  /**
   * defaultDisplay is a method to display all to dos to the user
   * according to the allInfoList
   */
  // display according to the allInfoList
  public void defaultDisplay(){
    for (String s: this.headerInfo){
      System.out.print(s + " ");
    }
    System.out.println();
    for (List<String> todo : this.allInfoList){
      for (String str: todo){
        System.out.print(str + " ");
      }
      System.out.println();
    }
    System.out.println();
  }


  /**
   * otherDisplay is a method to display all to dos after filtering
   * or sorting based on the given list of list of string
   *
   ** @param filteredTodos - the given list of list of string after
   *                       filtering or sorting.
   */
  // display according to the filtered to do list
  public void otherDisplay(List<List<String>> filteredTodos){
    for (String s: this.headerInfo){
      System.out.print(s + " ");
    }
    System.out.println();
    for (List<String> todo: filteredTodos){
      for (String str: todo){
        System.out.print(str + " ");
      }
      System.out.println();
    }
    System.out.println();
  }


}