package p3;

import java.util.Objects;

public class StringData {

  private final String originalString;
  private final String refactoredString;
  private final Integer numberCharsReplaced;


  public StringData(String originalString, String refactoredString,
      Integer numberCharsReplaced) {
    this.originalString = originalString;
    this.refactoredString = refactoredString;
    this.numberCharsReplaced = numberCharsReplaced;
  }

  public String getOriginalString() {
    return originalString;
  }

  public String getRefactoredString() {
    return refactoredString;
  }

  public Integer getNumberCharsReplaced() {
    return numberCharsReplaced;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StringData that = (StringData) o;
    return Objects.equals(originalString, that.originalString) && Objects.equals(
        refactoredString, that.refactoredString) && Objects.equals(numberCharsReplaced,
        that.numberCharsReplaced);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalString, refactoredString, numberCharsReplaced);
  }

  @Override
  public String toString() {
    return "StringData{" +
        "originalString='" + originalString + '\'' +
        ", refactoredString='" + refactoredString + '\'' +
        ", numberCharsReplaced=" + numberCharsReplaced +
        '}';
  }
}
