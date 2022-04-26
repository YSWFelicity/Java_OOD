package Service;

import FileProcessor.CSVWriter;
import FileProcessor.InvalidIndexException;
import Model.Builder;
import Viewer.TodoViewer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



/**
 *CMDMainProcessor is a class that mainly process the user's input command lines, and
 * add the new to do task, update the existing to do task., etc.
 */
public class CMDMainProcessor {
  private String[] args;
  // required commands
  private static final String CSV_COMMAND = "--csv-file";
  private static final String DISPLAY = "--display";
  private static final String ADD_TODO = "--add-todo";
  private static final String TODO_TEXT = "--todo-text";

  // optional commands
  private static final String COMPLETE_TODO = "--complete-todo";
  private static final String DUE = "--due";
  private static final String PRIORITY = "--priority";
  private static final String CATEGORY = "--category";
  private static final String COMPLETED = "--completed";
  private static final String SHOW_INCOMPLETE = "--show-incomplete";
  private static final String SHOW_CATEGORY = "--show-category";
  private static final String SORT_BY_DATE = "--sort-by-date";
  private static final String SORT_BY_PRIORITY = "--sort-by-priority";

  /**
   * Constructor
   *
   * @param args - a list of command line arguments, expected as a list of string
   */
  public CMDMainProcessor(String[] args) {
    this.args = args;
  }

  /**
   * cmdProcessor is the method to process all the command line inputs from
   * the user, and process them accordingly.
   *
   * @return true if the args getting from the user can be processed.
   * @throws IOException - IOException will be thrown when the reading file process is problematic.
   */
  public Boolean cmdProcessor() throws IOException, InvalidIndexException {
    String csvFilePath = null;
    String todoTextDescription = null;
    Boolean addNewTodo = false;
    Boolean completeForNewAddedTodo = false;
    LocalDate dueDate = null;
    Integer priorityNum = -99;
    String category = null;

    Boolean changeCompleteStatusForExisting = false;
    Integer idForChangeCompletedStatus = -1;

    Boolean displayDefault = true;
    Boolean displayFilterIncomplete = false;
    Boolean displayFilterCategory = false;
    String filterByCategory = null;
    Boolean displaySortByDue = false;
    Boolean displaySortByPriority = false;
    Boolean flag = false;


    CMDInputValidator cmdInputValidator = new CMDInputValidator(args);
    if (cmdInputValidator.checkValidCMDInput()){
      for (String cmd:args){
        CMDParser cmdParser = new CMDParser(cmd);
        switch (cmd){
          case DISPLAY:
          case ADD_TODO:
            break;
          case CSV_COMMAND:
            if (cmdParser.validatePath(cmdParser.getNextArgument(args))) {
              csvFilePath = cmdParser.getNextArgument(args);
            }
            break;
          case TODO_TEXT:
            addNewTodo = true;
            todoTextDescription = cmdParser.getNextArgument(args);
            break;
          case COMPLETE_TODO:
            changeCompleteStatusForExisting = true;
            if (cmdParser.validatePath(cmdParser.getNextArgument(args))) {
              idForChangeCompletedStatus = Integer.valueOf(cmdParser.getNextArgument(args));
            }
            break;
          case DUE:
            if (cmdParser.validatePath(cmdParser.getNextArgument(args))) {
              dueDate = LocalDate.parse(cmdParser.getNextArgument(args));
            }
            break;
          case PRIORITY:
            if (cmdParser.validatePath(cmdParser.getNextArgument(args))) {
              priorityNum = Integer.valueOf(cmdParser.getNextArgument(args));
            }
            break;
          case CATEGORY:
            if (cmdParser.validatePath(cmdParser.getNextArgument(args))) {
              category = cmdParser.getNextArgument(args);
            }
            break;
          case COMPLETED:
            completeForNewAddedTodo = true;
            break;
          case SHOW_INCOMPLETE:
            displayFilterIncomplete = true;
            displayDefault = false;
            break;
          case SHOW_CATEGORY:
            displayFilterCategory = true;
            displayDefault = false;
            if (cmdParser.validatePath(cmdParser.getNextArgument(args))) {
              filterByCategory = cmdParser.getNextArgument(args);
            }
            break;
          case SORT_BY_DATE:
            displaySortByDue = true;
            displayDefault = false;
            break;
          case SORT_BY_PRIORITY:
            displayDefault = false;
            displaySortByPriority = true;
            break;
        }

      }
      flag = true;
    } else {
      return false;
    }
    // update the csv file if new to do needs to be added
    CSVWriter csvWriter = new CSVWriter(csvFilePath);
    if (addNewTodo && csvFilePath!= null){
      // build for the new to do
      Builder builder = new Builder(todoTextDescription);
      // add extra fields for the new to do including "complete" status, the due date, the priority, and category
      // if such parameters are provided
      if (completeForNewAddedTodo) builder.setComplete();
      if (dueDate != null) builder.addDate(dueDate);
      if (priorityNum > 0) builder.addPriority(priorityNum);
      if (category != null) builder.addCategory(category);
      csvWriter.AddNewToDoUpdateCSVFile(builder);
    }

    // update the csv file when we need to change the complete status of an existing todo_
    if (changeCompleteStatusForExisting){
      if (idForChangeCompletedStatus != -1)
        csvWriter.completeExistingTodoUpdateCSVFile(idForChangeCompletedStatus);
    }

    // display the todos to the user in the terminal, either default or after filtering
    System.out.println();
    List<List<String>> filteredTodos = new ArrayList<>();
    TodoViewer todoViewer = new TodoViewer(csvFilePath);
    if (displayDefault){
      System.out.println("Default display: ");
      todoViewer.defaultDisplay();
    }else{
      if(displayFilterIncomplete){
        filteredTodos = todoViewer.filterIncomplete(); //update the infor list
        System.out.println("Show all to dos that are incomplete: ");
        todoViewer.otherDisplay(filteredTodos);
      }
      if (displayFilterCategory){
        filteredTodos = todoViewer.filterByCategory(filterByCategory);
        System.out.println("Show all to dos whose category is " + filterByCategory);
        todoViewer.otherDisplay(filteredTodos);
      }
      if (displaySortByDue){
        todoViewer.sortByDue();
        System.out.println("Show all to dos after sorting by due date is: ");
        todoViewer.defaultDisplay();
      }
      if (displaySortByPriority){
        todoViewer.sortByPriority();
        System.out.println("Show all to dos after sorting by priority is: ");
        todoViewer.defaultDisplay();
      }
    }
    return flag;
  }

}