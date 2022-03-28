package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IValidatorTest {
  Password testPassword;
  private Integer expectedMinLength;
  private Integer expectedMaxLength;
  private Integer expectedMinLowercase;
  private Integer expectedMinUppercase;
  private Integer expectedMinDigits;

  Phone testPhone;
  private Integer expectedSpecifiedLength;

  FreeText testFreeText;
  private Integer expectedLines;
  private Integer expectedNumberOfCharactersPerLine;

  RadioButton testRadioButton;
  CheckBox testCheckBox;
  Number testNumber;
  Number testNumber1;

  @BeforeEach
  void setUp() {
    testRadioButton = new RadioButton();
    testNumber = new Number(10.0, 1000.0, 2);
    testNumber1 = new Number(20.0, 1000.0, -5);
    testCheckBox = new CheckBox();
    testPassword = new Password(10, 0, 0, 0, 5);
    testPhone = new Phone(9);
    testFreeText = new FreeText();

  }

  @Test
  void getMinValue() {
    assertEquals(10.0, testNumber.getMinValue(), 0.01);
  }

  @Test
  void getMaxValue() {
    assertEquals(1000.0, testNumber.getMaxValue(), 0.01);
  }

  @Test
  void getMaxDecimalPlaces() {
    assertEquals(2, testNumber.getMaxDecimalPlaces());
    assertEquals(0, testNumber1.getMaxDecimalPlaces());
  }

  @Test
  void setMinValue() {
    testNumber.setMinValue(20.0);
    assertEquals(20.0, testNumber.getMinValue(), 0.01);
  }

  @Test
  void setMaxValue() {
    testNumber.setMaxValue(150.0);
    assertEquals(150.0, testNumber.getMaxValue(), 0.01);
  }

  @Test
  void setMaxDecimalPlaces() {
    testNumber.setMaxDecimalPlaces(4);
    assertEquals(4, testNumber.getMaxDecimalPlaces());
    testNumber.setMaxDecimalPlaces(-2);
    assertEquals(0, testNumber.getMaxDecimalPlaces());

  }

  @Test
  void isNumber() {
    assertFalse(testNumber.isNumber("kfha"));
    assertFalse(testNumber.isNumber(null));
    assertTrue(testNumber.isNumber("12"));
    assertTrue(testNumber.isNumber("12.34"));
    assertTrue(testNumber.isNumber("-200.45"));
  }

  @Test
  void isValidCheckBoxClass() {
    assertTrue(testCheckBox.isValid(null));
    assertFalse(testCheckBox.isValid(true));
  }



  @Test
  void isValidRadioButtonClass() {
    assertTrue(testRadioButton.isValid(true));
    assertTrue(testRadioButton.isValid(false));
    assertFalse(testRadioButton.isValid(null));
  }

  @Test
  void isValidNumberClass() {
    assertFalse(testNumber.isValid("adhka"));
    assertTrue(testNumber.isValid("14"));
    assertTrue(testNumber.isValid("12.35"));
    assertFalse(testNumber.isValid("12.34080"));
    assertFalse(testNumber.isValid("3"));
    assertFalse(testNumber.isValid("11111"));
    assertFalse(testNumber.isValid("-10.25"));
    assertFalse(testNumber.isValid("11111.56"));
  }

  @Test
  void isValidFreeText() {
//    assertFalse(testFreeText.isValid("0"));
  }

  @Test
  void testEqualsSameObjects() {
    assertEquals(testNumber, testNumber);
  }

  @Test
  void testEqualsNullObjects() {
    assertNotEquals(null, testNumber);
  }

  @Test
  void testEqualsSameFieldsInGeneral() {
    Number testNumber1 = new Number(10.0, 1000.0, 2);
    assertEquals(testNumber, testNumber1);
  }

  @Test
  void testEqualsDiffFieldsInGeneral() {
    Number testNumber1 = new Number(12.0, 1200.0, 3);
    assertNotEquals(testNumber, testNumber1);
  }

  @Test
  void testEqualsDiffMaxValue() {
    Number testNumber1 = new Number(10.0, 105.0, 2);
    assertNotEquals(testNumber, testNumber1);
  }

  @Test
  void testEqualsDiffMaxDecimalPlaces() {
    Number testNumber1 = new Number(10.0, 1000.0, 4);
    assertNotEquals(testNumber, testNumber1);
  }

  @Test
  void testHashCode1() {
    assertEquals(testNumber.hashCode(), testNumber.hashCode());
  }

  @Test
  void testHashCode2() {
    assertEquals(testPassword.hashCode(), testPassword.hashCode());
  }

  @Test
  void testHashCode3() {
    assertEquals(testPhone.hashCode(), testPhone.hashCode());
  }

  @Test
  void testHashCode4() {
    assertEquals(testFreeText.hashCode(), testFreeText.hashCode());
  }


  @Test
  void testToString1() {
    String s1 = "Number{" +
        "minValue=" + testNumber.getMinValue() +
        ", maxValue=" + testNumber.getMaxValue() +
        ", maxDecimalPlaces=" + testNumber.getMaxDecimalPlaces() +
        '}';
    assertEquals(s1, testNumber.toString());
  }

  @Test
  void testToString2() {
    String s2 = "Password{" +
        "minLength=" + expectedMinLength +
        ", maxLength=" + expectedMaxLength +
        ", minLowercase=" + expectedMinLowercase +
        ", minUppercase=" + expectedMinUppercase +
        ", minDigits=" + expectedMinDigits +
        '}';
  }

  @Test
  void testToString3() {
    String s3 = "Phone{" +
        "specifiedLength=" + expectedSpecifiedLength +
        '}';
  }

  @Test
  void testToString4() {
    String s4 = "FreeText{" +
        "lines=" + expectedLines +
        ", numberOfCharactersPerLine=" + expectedSpecifiedLength +
        '}';
  }
}