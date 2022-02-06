package problem1;

/**
 * A custom exception class representing invalid booking.
 */
public class IllegalBookException extends Exception{

  public IllegalBookException(){
    super("Invalid book exception");
  }
}
