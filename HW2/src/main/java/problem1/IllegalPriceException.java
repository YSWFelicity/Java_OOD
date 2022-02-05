package problem1;

/**
 * A custom exception class representing invalid price.
 */
public class IllegalPriceException extends Exception{
  public IllegalPriceException(){
    super("Invalid price exception");
  }
}
