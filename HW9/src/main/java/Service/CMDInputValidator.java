package Service;


import java.io.File;

/**
 * CMDInputValidator. CMDInputValidator is a class
 * that is used to check all the validness of the arguments from the user input.
 */
public class CMDInputValidator {
  private String[] args;
  private static final String CSV_COMMAND = "--csv-file";
  private static final String ADD_TODO = "--add-todo";
  private static final String TODO_TEXT = "--todo-text";
  private static final String DISPLAY = "--display";
  private static final String COMPLETE_TODO = "--complete-todo";
  private static final Integer MIN_COMMANDS_LENGTH = 3;
  private static final String DUE= "--due";
  private static final String PRIORITY = "--priority";
  private static final String CATEGORY = "--category";
  private static final String COMPLETED = "--completed";
//    private static final String SHOW_INCOMPLETE = "--show-incomplete";
//    private static final String SHOW_CATEGORY = "--show-category";
//    private static final String SORT_BY_DATE = "--sort-by-date";
//    private static final String SORT_BY_PRIORITY = "--sort-by-priority";


  /**
   * Constructor
   *
   * @param args the given args from the user's input
   */
  public CMDInputValidator(String[] args) {
    this.args = args;
  }

  /**
   * checkLengthOfCMDInput is a method to check whether the command inputs' length
   * meets the requirement or not.
   *
   * @return true if the args meets the length requirement.
   */
  public Boolean checkLengthOfCMDInput(){
    if (this.args.length < MIN_COMMANDS_LENGTH){
      System.out.println("The required command length is at least 3!");
      return false;
    }
    System.out.println("Length requirement meets");
    return true;
  }


  /**
   * checkOutputInputCMD is a method to check whether the input command
   * is valid or not
   *
   * @return true if both input command is valid.
   */
  public Boolean checkInputCMD(){
    Boolean inputCMDValid = false;

    for (int i = 0; i < this.args.length; i++){
      if (this.args[i].equals(CSV_COMMAND)){
        File csv = new File(this.args[i+1]);
        if(!csv.exists()) {
          return false;
        }
        System.out.println("The input command and dir is valid");
        inputCMDValid = true;
      }
    }
    return inputCMDValid;

  }

  /**
   * checkAddToDoCommandGroup is a method to check whether the --add-to-do command and the
   * to do test command are valid
   *
   * @param addTodoCmd - the given add to do command
   * @param todoTextCmd -the given to do text command
   * @return
   */
  private Boolean checkAddToDoCommandGroup(String addTodoCmd, String todoTextCmd) {
    Boolean todoCmdExist = false;
    Boolean todoTextCMDExist = false;
    for (int i = 0; i < this.args.length; i++){
      if (this.args[i].equals(addTodoCmd)){
        todoCmdExist = true;
        System.out.println("Add to do command exists.");
      }
      if (this.args[i].equals(todoTextCmd) && i+1 < this.args.length){
        todoTextCMDExist = true;
        System.out.println("To do text description exists.");
      }
    }
    if (todoCmdExist != todoTextCMDExist){
      System.out.println("Error: add to do command or to do text description command is missing");
    }
    return todoCmdExist == todoTextCMDExist;
  }

  /**
   * checkCompleteToDoCMD is a method to check whether the complete to do
   * command is valid
   *
   * @return true if it's valid
   */
  public Boolean checkCompleteToDoCMD() {
    Boolean completeTodoCMDExist = false;
    Boolean todoIDValid = false;
    for (int i = 0; i < this.args.length; i++){
      if (this.args[i].equals(COMPLETE_TODO) && i+1 < this.args.length){
        completeTodoCMDExist = true;
        todoIDValid = true;
        System.out.println("Add to do command exists.");
      }
    }
    return completeTodoCMDExist == todoIDValid;
  }


  /**
   * checkCompletedCMD is a method to check whether the completed
   * command is valid
   *
   * @return true if it's valid when the add to do command and the completed commands both exist.
   */
  private Boolean checkCompletedCMD() {
    Boolean completedCMDExist = false;
    Boolean addTodoIDValid = false;
    for (int i = 0; i < this.args.length; i++){
      if (this.args[i].equals(COMPLETED)){
        completedCMDExist = true;
        System.out.println("Completed command exists.");
      }
    }
    addTodoIDValid = this.checkAddToDoCommandGroup(ADD_TODO, TODO_TEXT);

    if (completedCMDExist & (!addTodoIDValid)){
      System.out.println("Error: the completed command exist, but the add to do command is invalid!");
      return false;
    }
    return true;
  }

  /**
   * checkDueCMD is a method to check whether the add due command is valid
   *
   * @return true if the check due command is valid
   */
  private Boolean checkDueCMD() {
    Boolean dueCMDExist = false;
    Boolean dueDateExist = false;
    for (int i = 0; i < this.args.length; i++){
      if (this.args[i].equals(DUE)){
        dueCMDExist = true;
        if (i + 1 < this.args.length){
          dueDateExist = true;
          System.out.println("Due commands are valid!");}
      }
    }

    if (dueCMDExist != dueDateExist){
      System.out.println("Error: the due command is invalid!");
      return false;
    }
    return dueCMDExist == dueDateExist;
  }


  /**
   * checkPriorityCMD is a method to check whether the priority command is valid
   *
   * @return true if the check due command is valid
   */
  private Boolean checkPriorityCMD(){
    Boolean priorityCMDExist = false;
    Boolean priorityValueValid = false;
    for (int i = 0; i < this.args.length; i++){
      if (this.args[i].equals(PRIORITY)){
        priorityCMDExist = true;
        if (i + 1 < this.args.length)
          priorityValueValid = true;
        System.out.println("Priority command is valid!");
      }
    }

    if (priorityCMDExist != priorityValueValid){
      System.out.println("Error: the priority command is invalid!");
      return false;
    }
    return priorityCMDExist == priorityValueValid;
  }

  /**
   * checkCategoryCMD is a method to check whether the category command is valid
   *
   * @return true if the check category command is valid
   */
  private Boolean checkCategoryCMD() {
    Boolean categoryCMDExist = false;
    Boolean categoryNameExist = false;
    for (int i = 0; i < this.args.length; i++){
      if (this.args[i].equals(CATEGORY)){
        categoryCMDExist = true;
        if (i + 1 < this.args.length)
          categoryNameExist = true;
        System.out.println("Category command is valid!");
      }
    }

    if (categoryCMDExist != categoryNameExist){
      System.out.println("Error: the category command is invalid!");
      return false;
    }
    return categoryCMDExist == categoryNameExist;
  }

  /**
   * checkOptionalCMDValid is a method to check whether the given optional commands are valid
   *
   * @return true if the check given optional commands are valid.
   */
  private Boolean checkOptionalCMDValid() {
    if (!this.checkCompletedCMD() || !this.checkDueCMD() || !this.checkPriorityCMD() ||!this.checkCategoryCMD())
    {
      return false;
    }
    return true;
  }

  /**
   * checkValidCMDInput is a method to check whether the command lines input from the user is valid
   * in general.
   *
   * @return true if all the command lines are valid.
   */
  public Boolean checkValidCMDInput(){
    if (!this.checkLengthOfCMDInput() || !this.checkInputCMD() || !this.checkAddToDoCommandGroup(ADD_TODO, TODO_TEXT) ||
        !this.checkCompleteToDoCMD() || !this.checkOptionalCMDValid()){
//            System.out.println("Error: The command lines are not valid in general!");
      return false;
    }
//        System.out.println("The command lines are valid in general!");
    return true;
  }
}