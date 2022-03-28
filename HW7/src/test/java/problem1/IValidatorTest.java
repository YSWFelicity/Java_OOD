package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IValidatorTest {
  RadioButton testRadioButton;
  CheckBox testCheckBox;
  Number testNumber;
  Number testNumber1;

  Password testPassword;
  Password testPassword1;
  Phone testPhone;
  Phone testPhone1;
  FreeText testFreeText;
  FreeText testFreeText2;

  @BeforeEach
  void setUp() {
    testRadioButton = new RadioButton();
    testNumber = new Number(10.0, 1000.0, 2);
    testNumber1 = new Number(20.0, 1000.0, -5);
    testCheckBox = new CheckBox();

    testPassword = new Password(5, 10, 1, 1, 1);
    testPassword1 = new Password(4, 10, 1, 1, 1);
    testPhone = new Phone(9);
    testPhone1 = new Phone(8);
    testFreeText = new FreeText(2, 3);
    testFreeText2 = new FreeText(1, 3);
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
  void isValidPhoneClass() {
    assertFalse(testPhone.isValid("12345678"));
    assertFalse(testPhone.isValid("9"));
    assertTrue(testPhone.isValid("123456789"));
    assertFalse(testPhone.isValid("abc"));
    assertFalse(testPhone.isValid("abc123"));
  }

  @Test
  void isValidPasswordClass() {
    assertFalse(testPassword.isValid(" "));
    assertFalse(testPassword.isValid("12345"));
    assertTrue(testPassword.isValid("Abc123"));
    assertFalse(testPassword.isValid("abc123"));
    assertFalse(testPassword.isValid("abc 123"));
    assertFalse(testPassword.isValid("ABC123"));
    assertFalse(testPassword.isValid("ABC 123"));
    assertFalse(testPassword.isValid("abcdefg"));
    assertFalse(testPassword.isValid("ABCDEFG"));
    assertFalse(testPassword.isValid("######"));
    assertFalse(testPassword.isValid("Ab1"));
    assertFalse(testPassword.isValid("Ab1 "));
  }

  @Test
  void isValidFreeTextClass() {
    assertFalse(testFreeText.isValid("abcdefg"));
    assertTrue(testFreeText.isValid("12345"));
  }

  @Test
  void testEqualsSameObjects() {
    assertEquals(testNumber, testNumber);
    assertEquals(testPassword, testPassword);
    assertEquals(testPhone, testPhone);
    assertEquals(testFreeText, testFreeText);
  }

  @Test
  void testEqualsNullObjects() {
    assertNotEquals(null, testNumber);
    assertNotEquals(null, testPassword);
    assertNotEquals(null, testPhone);
    assertNotEquals(null, testFreeText);
  }

  @Test
  void testEqualsSameFieldsInGeneral() {
    Number testNumber1 = new Number(10.0, 1000.0, 2);
    assertEquals(testNumber, testNumber1);
    Password testPassword1 = new Password(5, 10, 1, 1, 1);
    assertEquals(testPassword, testPassword1);
    Phone testPhone1 = new Phone(9);
    assertEquals(testPhone, testPhone1);
    FreeText testFreeText1 = new FreeText(2, 3);
    assertEquals(testFreeText, testFreeText1);
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
    Password testPassword1 = new Password(5, 12, 1, 1, 1);
    assertNotEquals(testPassword, testPassword1);
  }

  @Test
  void testEqualsDiffMaxDecimalPlaces() {
    Number testNumber1 = new Number(10.0, 1000.0, 4);
    assertNotEquals(testNumber, testNumber1);
  }

  @Test
  void testHashCode() {
    assertEquals(testNumber.hashCode(), testNumber.hashCode());
  }

  @Test
  void testHashCode2() {
    assertEquals(testPassword.hashCode(),testPassword.hashCode());
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
  void testToString() {
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
        "minLength=" + testPassword +
        ", maxLength=" + testPassword +
        ", minLowercase=" + testPassword +
        ", minUppercase=" + testPassword +
        ", minDigits=" + testPassword +
        '}';
  }

  @Test
  void testToString3() {
    String s3 = "Phone{" +
        "specifiedLength=" + testPhone +
        '}';
  }

  @Test
  void testToString4() {
    String s4 = "FreeText{" +
        "lines=" + testFreeText +
        ", numberOfCharactersPerLine=" + testFreeText +
        '}';
  }
}