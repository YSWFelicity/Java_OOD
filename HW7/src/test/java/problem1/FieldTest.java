package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FieldTest {

  Field<String> field1;
  Field<String> field2;
  Number number;
  Phone phone;
  String fieldOneValue = "15";


  @BeforeEach
  void setUp() {
    number = new Number(1d, 10d, 10);
    phone = new Phone(10);
    field1 = new Field<String>("tip", true, number);
    field1.setValue(fieldOneValue);
    field2 = new Field<String>("phone number", false, phone);
    field2.setValue("6518155208");
  }

  @Test
  void testSameObjectEquals() {
    assertEquals(field1, field1);
  }

  @Test
  void testNullObject() {
    assertNotEquals(null, field1);
  }

  @Test
  void testDiffObject() {
    assertNotEquals(field2, field1);
  }

  @Test
  void testDifferentObject() {
    assertNotEquals(field1, field2);
  }

  @Test
  void testSameAttributeEquals() {
    Field<String> fieldSameAs1 = new Field<>("tip", true, number);
    fieldSameAs1.setValue(fieldOneValue);
    assertEquals(field1, fieldSameAs1);
  }

  @Test
  void testDifferentAttributeEquals() {
    Field<String> fieldDiff = new Field<>("dollar", true, number);
    fieldDiff.setValue("20");
    assertNotEquals(field1, fieldDiff);
  }

  @Test
  void testHashCode() {
    Field<String> fieldSameAs1 = new Field<>("tip", true, number);
    fieldSameAs1.setValue(fieldOneValue);
    assertEquals(fieldSameAs1.hashCode(), field1.hashCode());
  }

  @Test
  void testToString() {
    assertEquals("Field{label='tip', value=15, "
        + "required=true, validator=Number{minValue=1.0, "
        + "maxValue=10.0, maxDecimalPlaces=10}}", field1.toString());
  }

  @Test
  void getLabel() {
    assertEquals("tip", field1.getLabel());
  }

  @Test
  void getValue() {
    assertEquals("15", field1.getValue());
  }

  @Test
  void isRequired() {
    assertTrue(field1.isRequired());
  }

  @Test
  void getValidator() {
    assertInstanceOf(Phone.class, field2.getValidator());
  }

  private void assertInstanceOf(Class<Phone> phoneClass, IValidator<String> validator) {
  }

  @Test
  void updateValue() throws InvalidInputException {
    //could update
    field2.updateValue("1234567890");
    assertEquals("1234567890", field2.getValue());

    //not valid
    Phone phone2 = new Phone(5);
    assertThrows(InvalidInputException.class, ()-> field2.updateValue("1234567"));

  }

  @Test
  void isFilled() {
    assertTrue(field2.isFilled());//field is required and meets the requiremnet
    assertFalse(field1.isFilled()); //exceed maxValue

    //value is null
    Field<String> fieldNew = new Field<>("tip", true, number);
    assertFalse(fieldNew.isFilled());
  }
}