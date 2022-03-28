package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PhoneTest {

  Phone testPhone;
  Phone testPhone2;
  private Integer expectedSpecifiedLength;

  @BeforeEach
  void setUp() {
  }

  @Test
  void isValid() {
  }

//  @Test
//  void testEquals() {
//    assertTrue(testPhone.equals(testPhone));
//  }

//  @Test
//  void testHashCode() {
//    int hash = Objects.hash(expectedSpecifiedLength);
//    assertEquals(hash, testPhone.hashCode());
//  }


//  @Test
//  void testEquals2() {
//    assertFalse(testPhone.equals(null));
//  }

  @Test
  void testToString() {
    String s3 = "Phone{" +
        "specifiedLength=" + expectedSpecifiedLength +
        '}';
  }
}