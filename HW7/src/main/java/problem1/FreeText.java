package problem1;

import java.util.Objects;

public class FreeText implements IValidator<String>{
  private Integer lines;
  private Integer numberOfCharactersPerLine;


  @Override
  public boolean isValid(String input) {
    return input.length() <= this.lines * this.numberOfCharactersPerLine;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(lines, numberOfCharactersPerLine);
  }

  @Override
  public String toString() {
    return "FreeText{" +
        "lines=" + lines +
        ", numberOfCharactersPerLine=" + numberOfCharactersPerLine +
        '}';
  }
}
