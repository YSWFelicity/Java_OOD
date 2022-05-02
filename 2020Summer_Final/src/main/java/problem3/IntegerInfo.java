package problem3;

import java.util.Objects;

public class IntegerInfo {

  private Integer originalInteger;
  private Integer numOccurrences;
  private Integer numDigits;

  public IntegerInfo(Integer originalInteger, Integer numOccurrences, Integer numDigits) {
    this.originalInteger = originalInteger;
    this.numOccurrences = numOccurrences;
    this.numDigits = numDigits;
  }

  public Integer getOriginalInteger() {
    return originalInteger;
  }

  public Integer getNumOccurrences() {
    return numOccurrences;
  }

  public void setNumOccurrences(Integer numOccurrences) {
    this.numOccurrences = numOccurrences;
  }

  public Integer getNumDigits() {
    return numDigits;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IntegerInfo that = (IntegerInfo) o;
    return Objects.equals(originalInteger, that.originalInteger)
        && Objects.equals(numOccurrences, that.numOccurrences) && Objects.equals(
        numDigits, that.numDigits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originalInteger, numOccurrences, numDigits);
  }

  @Override
  public String toString() {
    return "IntegerInfo{" +
        "originalInteger=" + originalInteger +
        ", numOccurrences=" + numOccurrences +
        ", numDigits=" + numDigits +
        '}';
  }
}
