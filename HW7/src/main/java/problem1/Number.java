package problem1;

import java.util.Objects;

/**
 * Number is a class that implements the IValidator interface, which takes
 * String as its generics and with following parameters including min values
 * max values, and max decimal places.
 */
public class Number implements IValidator<String>{
  private Double minValue;
  private Double maxValue;
  private Integer maxDecimalPlaces;

  /**
   * Constructor
   *
   * @param minValue - the min value of the given string after converting to numeric can be, expected
   *                 as a double.
   * @param maxValue - the min value of the given string after converting to numeric can be, expected
   *                as a double.
   * @param maxDecimalPlaces - the max decimal places that the given string after converting to numeric can be, expected
   *                as an integer.
   */
  public Number(Double minValue, Double maxValue, Integer maxDecimalPlaces) {
    this.minValue = minValue;
    this.maxValue = maxValue;
    if (maxDecimalPlaces < 0){
      this.maxDecimalPlaces = 0;
    }else{
      this.maxDecimalPlaces = maxDecimalPlaces;
    }
  }

  /**
   * Getter
   *
   * @return minValue - the min value of the given string after converting to numeric can be, expected
   *                as a double.
   */
  public Double getMinValue() {
    return minValue;
  }

  /**
   * Getter
   *
   * @return maxValue - the max value of the given string after converting to numeric can be, expected
   *                as a double.
   */
  public Double getMaxValue() {
    return maxValue;
  }

  /**
   * Getter
   *
   * @return maxDecimalPlaces - the max decimal places of the given string after converting to numeric can be, expected
   *                as an integer.
   */
  public Integer getMaxDecimalPlaces() {
    return maxDecimalPlaces;
  }

  /**
   * Setter
   *
   * @param minValue the min value of the given string after converting to numeric can be, expected
   *              as a double.
   */
  public void setMinValue(Double minValue) {
    this.minValue = minValue;
  }

  /**
   * Setter
   *
   * @param maxValue the max value of the given string after converting to numeric can be, expected
   *              as a double.
   */
  public void setMaxValue(Double maxValue) {
    this.maxValue = maxValue;
  }

  /**
   * Setter
   *
   * @param maxDecimalPlaces - the max decimal places of the given string after converting to numeric can be, expected
   *              as a double.
   */
  public void setMaxDecimalPlaces(Integer maxDecimalPlaces) {
    if (maxDecimalPlaces < 0){
      this.maxDecimalPlaces = 0;
    }else{
      this.maxDecimalPlaces = maxDecimalPlaces;}
  }

  /**
   * isNumber is a method to check whether a string can be converted to a number or not (either an integer
   * or a double)
   *
   * @param s - the given string
   * @return true if the given string can be converted to an integer or a double.
   */
  public static boolean isNumber(String s) {
    if (s == null) {
      return false;
    }
    try {
      double d = Double.parseDouble(s);
    } catch (NumberFormatException e) {
      return false;
    }
    return true;
  }

  /**
   * isInteger is a method to determine whether a given string can be converted to an integer or not
   *
   * @param s - the given string
   * @return true if the given string can be converted to an integer.
   */
  public Boolean isInteger(String s){
    if (s.indexOf(".") == -1){
      return true;
    }
    return false;
  }

  /**
   * isFloat is a method to determine whether a given string can be converted to a double or not
   *
   * @param s - the given string
   * @return true if the given string can be converted to a double.
   */
  public Boolean isFloat(String s){
    if (s.indexOf(".") != -1){
      return true;
    }
    return false;
  }


  /**
   * isValid is a method to check whether a given string can be converted to
   * an integer or a double. Also, to check whether the given string after converting
   * is within the range of minValue and maxValue; and whether a double's decimal places are less
   * than the max decimal places.
   *
   * @param input - the given input, expected as a string
   * @return true if meets above requirements.
   */
  @Override
  public boolean isValid(String input) {
    if (!this.isNumber(input)) return false;
    if (this.isInteger(input)){
      int value = Integer.parseInt(input);
      if (value < this.minValue || value > this.maxValue) return false;
    }
    if (this.isFloat(input)){
      double value = Double.parseDouble(input);
      int numOfDecimals = input.length() - input.indexOf(".") - 1; // "12.34"
      if (value < this.minValue || value > this.maxValue || numOfDecimals > this.maxDecimalPlaces) return false;
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
    if (this == o) return true;
    if (!(o instanceof Number)) return false;
    Number number = (Number) o;
    return Objects.equals(getMinValue(), number.getMinValue()) && Objects.equals(getMaxValue(), number.getMaxValue()) && Objects.equals(getMaxDecimalPlaces(), number.getMaxDecimalPlaces());
  }

  /**
   * hashCode is a method to get the hashCode of a object
   *
   * @return the hashCode value of an object.
   */
  @Override
  public int hashCode() {
    return Objects.hash(getMinValue(), getMaxValue(), getMaxDecimalPlaces());
  }

  /**
   * toString is a method of the representation of current object
   *
   * @return a string with following information about the object.
   */
  @Override
  public String toString() {
    return "Number{" +
        "minValue=" + minValue +
        ", maxValue=" + maxValue +
        ", maxDecimalPlaces=" + maxDecimalPlaces +
        '}';
  }
}