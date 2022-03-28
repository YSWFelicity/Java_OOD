package problem1;

import java.util.Objects;

/**
 * Password is a class that implements the IValidator interface, which takes
 * String as its generics and with following parameters including min length values
 * max length values, min lowercase, min uppercase, min digits.
 */
public class Password implements IValidator<String>{

  private Integer minLength;
  private Integer maxLength;
  private Integer minLowercase;
  private Integer minUppercase;
  private Integer minDigits;

  /**
   * Constructor
   *
   * @param minLength - the minimum acceptable length
   * @param maxLength - the maximum acceptable length
   *
   */
  public Password(Integer minLength, Integer maxLength) {
    this.minLength = minLength;
    this.maxLength = maxLength;
  }

  /**
   * Constructor
   *
   * @param minLength - the minimum acceptable length
   * @param maxLength - the maximum acceptable length
   * @param minLowercase - the minimum number of lowercase letters that the password must contain
   * @param minUppercase - the minimum number of uppercase letters that the password must contain
   * @param minDigits - the minimum number of digits that the password must contain
   *
   */
  public Password(Integer minLength, Integer maxLength, Integer minLowercase,
      Integer minUppercase, Integer minDigits) {
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.minLowercase = minLowercase;
    this.minUppercase = minUppercase;
    this.minDigits = minDigits;
  }


  private boolean validCount(String input) {
    Integer lowerCaseCount = 0;
    Integer upperCaseCount = 0;
    Integer digitsCount = 0;

    for (int i = 0; i < input.length(); i++) {
      char character = input.charAt(i);

      if (Character.isDigit(character)) {
        digitsCount++;
      } else if (Character.isLowerCase(character)) {
        lowerCaseCount++;
      } else if (Character.isUpperCase(character)) {
        upperCaseCount++;
      }
    }

    if (digitsCount >= this.minDigits && lowerCaseCount >= this.minLowercase
        && upperCaseCount >= this.minUppercase) {
      return true;
    }
    return false;
  }

  /**
   * isValid is a method to meet the length requirements and contain at least the minimum number of
   * each character type. Additionally, a valid password cannot contain a space (“ “). To keep
   * things simple, all other characters are allowed.
   *
   * @param input - the given input, expected as a string
   * @return true if meets above requirements.
   */
    @Override
    public boolean isValid (String input){
      if (input.length() >= this.minLength && input.length() <= this.maxLength && validCount(input) && !input.contains(" ")) {
        return true;
      }
      return false;
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
    Password password = (Password) o;
    return Objects.equals(minLength, password.minLength) && Objects.equals(
        maxLength, password.maxLength) && Objects.equals(minLowercase,
        password.minLowercase) && Objects.equals(minUppercase, password.minUppercase)
        && Objects.equals(minDigits, password.minDigits);
  }

  /**
   * hashCode is a method to get the hashCode of a object
   *
   * @return the hashCode value of an object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(minLength, maxLength, minLowercase, minUppercase, minDigits);
  }

  /**
   * toString is a method of the representation of current object
   *
   * @return a string with following information about the object.
   */
  @Override
  public String toString() {
    return "Password{" +
        "minLength=" + minLength +
        ", maxLength=" + maxLength +
        ", minLowercase=" + minLowercase +
        ", minUppercase=" + minUppercase +
        ", minDigits=" + minDigits +
        '}';
  }
}
