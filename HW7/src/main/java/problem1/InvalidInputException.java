package problem1;

/**
 * class InvalidInputException is a child class of Throwable.
 */
public class InvalidInputException extends Throwable {

  /**
   * Throw invalid Input
   *
   * @param message the exception message
   */
  public InvalidInputException(String message) {
    super(message);
  }

}