package FileProcessor;

/**
 * InvalidIndexException is an exception that will be thrown if the
 * given index is invalid
 */
public class InvalidIndexException extends Exception{
  /**
   * Constructor
   *
   * @param message the output message that will be printed when the exception is thrown
   */
  public InvalidIndexException(String message) {
    super(message);
  }

}
