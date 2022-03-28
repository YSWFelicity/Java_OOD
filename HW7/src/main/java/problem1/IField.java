package problem1;

/**
 * generic interface IField
 * @param <T> the type of the field value
 */
public interface IField<T> {

  /**
   * update the value of the field
   *
   * @param input The data type of input will either be String or Boolean
   * @throws InvalidInputException throw an exception if the input is invalid
   */
  void updateValue(T input) throws InvalidInputException;

  /**
   * check if the field is filled.
   *
   * @return Boolean -- return true if the Field is not required, or has been filled out if it
   * required.
   */
  boolean isFilled();
}