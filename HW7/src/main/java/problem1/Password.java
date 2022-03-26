package problem1;

import java.util.Objects;

public class Password implements IValidator<String>{

  private Integer minLength;
  private Integer maxLength;
  private Integer minLowercase;
  private Integer minUppercase;
  private Integer minDigits;

  public Password(Integer minLength, Integer maxLength) {
    this.minLength = minLength;
    this.maxLength = maxLength;
  }

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

    @Override
    public boolean isValid (String input){
      if (input.length() >= this.minLength && input.length() <= this.maxLength && validCount(input) && !input.contains(" ")) {
        return true;
      }
      return false;
    }

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

  @Override
  public int hashCode() {
    return Objects.hash(minLength, maxLength, minLowercase, minUppercase, minDigits);
  }

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
