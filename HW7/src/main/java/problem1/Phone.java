package problem1;

import java.util.Objects;

/**
 * Phone is a class that implements the IValidator interface, which takes
 * String as its generics and with following parameters including specified length values.
 */
public class Phone implements IValidator<String>{
  private Integer specifiedLength;

  public Phone(Integer specifiedLength) {
    this.specifiedLength = specifiedLength;
  }

  /**
   * isValid is a method to check whether a given string contains only digits and has a specified
   * length supplied by client code
   * @param input - the given input, expected as a string
   * @return true if meets above requirements.
   */
  @Override
  public boolean isValid(String input) {
    if (input.length() != specifiedLength) {
      return false;
    }
      for (int i = 0; i < input.length(); i++) {
        if (!Character.isDigit(input.charAt(i))) {
          return false;
        }
      }
      return true;
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
    Phone phone = (Phone) o;
    return Objects.equals(specifiedLength, phone.specifiedLength);
  }

  /**
   * hashCode is a method to get the hashCode of an object
   *
   * @return the hashCode value of an object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(specifiedLength);
  }

  /**
   * toString is a method of the representation of current object
   *
   * @return a string with following information about the object.
   */
  @Override
  public String toString() {
    return "Phone{" +
        "specifiedLength=" + specifiedLength +
        '}';
  }
}
