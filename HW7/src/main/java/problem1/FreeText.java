package problem1;

import java.util.Objects;

/**
 * FreeText is a class that implements the IValidator interface, which takes
 * String as its generics and with following parameters including lines values
 * and number of characters per line.
 */
public class FreeText implements IValidator<String>{
  private Integer lines;
  private Integer numberOfCharactersPerLine;

  /**
   * isValid is a method to check whether a given string will provide the number of lines in the text field and the number
   * of characters allowed per line.
   *
   * @param input - the given input, expected as a string
   * @return input must be no longer than the number of lines multiplied by the number of characters allowed per line.
   */
  @Override
  public boolean isValid(String input) {
    return input.length() <= this.lines * this.numberOfCharactersPerLine;
  }

  /**
   * equals is a method to check whether two objects have same fields.
   *
   * @param o - the given object to be compared to current object.
   * @return true if two objects have same fields. Otherwise, return false.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FreeText freeText = (FreeText) o;
    return Objects.equals(lines, freeText.lines) && Objects.equals(
        numberOfCharactersPerLine, freeText.numberOfCharactersPerLine);
  }

  /**
   * hashCode is a method to get the hashCode of an object
   *
   * @return the hashCode value of an object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(lines, numberOfCharactersPerLine);
  }

  /**
   * toString is a method of the representation of current object
   *
   * @return a string with following information about the object.
   */
  @Override
  public String toString() {
    return "FreeText{" +
        "lines=" + lines +
        ", numberOfCharactersPerLine=" + numberOfCharactersPerLine +
        '}';
  }
}
