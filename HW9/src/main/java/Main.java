
import FileProcessor.InvalidIndexException;
import Service.CMDMainProcessor;

import java.io.IOException;


/**
 * Main is the class that drives the code which
 * can take the arguments from the user, and process
 * them. Either add a new to do task, update existing to do task,
 * or sort the to do objects.
 *
 */
public class Main {
  //Example input for run configuration:
  //--csv-file src/todos.csv --add-todo --todo-text "new todo" --priority 2
  //--csv-file src/todos.csv --add-todo --todo-text "new todo1" --completed --due 2021-03-24 --category home --complete-todo 3
  //--csv-file src/todos.csv --add-todo --todo-text "clean dishes" --complete-todo 1 --display --show-incomplete --show-category home
  //--csv-file src/todos.csv --add-todo --todo-text "cook" --complete-todo 1 --display --show-category home --sort-by-date
  //--csv-file src/todos.csv --add-todo --todo-text "write assays" --priority 2 --complete-todo 1 --display --show-incomplete --show-category home --sort-by-priority

  /**
   * main
   *
   * @param args - the arguments input from the user, a list of string
   * @throws IOException - the exception will be thrown if the csv file cannot be processed.
   * @throws InvalidIndexException - the exception will be thrown if the given index is invalid.
   */
  public static void main(String[] args) throws IOException, InvalidIndexException {
    System.out.println("Usage:\n" +
        "--csv-file <path/to/folder> The CSV file to process. This option is required. \n" +
        "--display Display all the todos. This option is required. \n" +
        "--add-todo Add a new to do to the csv file. \n" +
        "--todo-text The new added to do text description. This command must co-exist with the --add-todo command \n" +
        "--due <Due date> Add due date for the new to do \n"  +
        "--priority <1, 2, 3> Add the priority for the new to do, 1 is the highest priority\n"  +
        "--category <category> Add the category for the new to do \n"  +
        "--completed Make the new to do as completed \n"  +
        "--complete-todo <id> Complete an existing todo \n"  +
        "--show-incomplete Filter all the todos that are incomplete \n"  +
        "--show-category <category> Filter all the todos whose category is the given category\n"  +
        "--sort-by-priority Sort the todos by priority \n"  +
        "----sort-by-date Sort the todos by date \n"
    );
    CMDMainProcessor cmdMainProcessor = new CMDMainProcessor(args);
    cmdMainProcessor.cmdProcessor();
  }


}