package problem1;

public class CourseNotFoundException extends Exception{

  /**
   * Represents an Exception, thrown when no such course is found in the catalog
   */
  public CourseNotFoundException() {
    super("No such course is found.");
  }

}
