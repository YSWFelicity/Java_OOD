package Model;

import java.time.LocalDate;


/**
 * Builder is a class to build the to do object
 */
public class Builder {
  private String text;
  private Boolean completed;
  private LocalDate due = LocalDate.now();
  private Integer priority;
  private String category = "?";
  private static final Integer HIGHEST_PRIORITY = 1;
  private static final Integer LOWEST_PRIORITY = 3;

  // when adding a new to do, only the to do description text will be passed in
  // other parameters can be built using other methods.

  /**
   * Constructor
   *
   * @param text - the given text description of the new added to do
   */
  public Builder(String text) {
    this.text = text;
    this.completed = false;
    this.priority = LOWEST_PRIORITY;
  }

  /**
   * Getter
   *
   * @return the text description of the to do object
   */
  public String getText() {
    return text;
  }

  /**
   * Getter
   *
   * @return the text description of the to do object
   */
  public Boolean getCompleted() {
    return completed;
  }

  /**
   * Getter
   *
   * @return the due of the to do, expected a LocalDate object
   */
  public LocalDate getDue() {
    return due;
  }

  /**
   * Getter
   *
   * @return the priority of the to do
   */
  public Integer getPriority() {
    return priority;
  }

  /**
   * Getter
   *
   * @return the text category of the to do object
   */
  public String getCategory() {
    return category;
  }

  /**
   * Setter
   * set the complete to be true
   */
  public void setComplete(){
    this.completed = true;
  }

  /**
   * Setter
   * add the due date to the to do
   */
  public void addDate(LocalDate due){
    this.due = due;
  }

  /**
   * checkPriority is a method to check the priority of the to do
   *
   * @param priority - an integer representing the priority of the task, including 1, 2, and 3.
   */
  private void checkPriority(Integer priority){
    if (priority < HIGHEST_PRIORITY || priority > LOWEST_PRIORITY) {
      throw new IllegalArgumentException("Priority needs to be between 1 and 3 inclusively");
    }
  }

  /**
   * addPriority is a method to add priority to the to do task.
   *
   * @param priority - an integer representing the priority of the task, including 1, 2, and 3.
   */
  public void addPriority(Integer priority){
    checkPriority(priority);
    this.priority = priority;
  }

  /**
   * addCategory is a method to add category to the to do task.
   *
   * @param category - the category of the to do task.
   */
  public void addCategory(String category){
    this.category = category;
  }

}
