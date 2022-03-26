package problem1;

import java.util.Objects;

public class Phone implements IValidator<String>{
  private Integer specifiedLength;

  public Phone(Integer specifiedLength) {
    this.specifiedLength = specifiedLength;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(specifiedLength);
  }

  @Override
  public String toString() {
    return "Phone{" +
        "specifiedLength=" + specifiedLength +
        '}';
  }
}
