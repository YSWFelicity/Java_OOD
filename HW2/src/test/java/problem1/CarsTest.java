package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {
  Cars Cars;
  Cars Cars2;

  @BeforeEach
  void setUp() throws Exception {
    Cars = new Cars(50,7);
  }

  @Test
  void invalidPrice() throws IllegalPriceException {
    IllegalPriceException thrown = Assertions.assertThrows(IllegalPriceException.class, () -> {
      Cars invalidPriceCars = new Cars(-5,7);
    }, "Invalid price");

    Assertions.assertEquals("Invalid price exception", thrown.getMessage());

  }

  @Test
  void getMaxOccupancy() {
    assertEquals(5,Cars.getMaxOccupancy());
  }

  @Test
  void getPrice() {
    assertEquals(50.0, Cars.getPrice());
  }

  @Test
  void isLicense() {
    assertTrue(Cars.equals(Cars));
  }

  @Test
  void isAllowDiff() {
    assertTrue(Cars.equals(Cars));
  }

  @Test
  void isAvailable() throws IllegalPriceException, IllegalBookException {
    Cars = new Cars(50,0);
    Cars.bookVehicle(1, 1, "Seattle", "Seattle", false);
  }

  @Test
  void getNumBookDays() {
    assertEquals(7, Cars.getNumBookDays());
  }

  @Test
  void setMaxOccupancy() {
    Cars.setMaxOccupancy(5);
    assertEquals(5,Cars.getMaxOccupancy());
  }

  @Test
  void InvalidNumPassengers1() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      Cars.bookVehicle(7, -1, "Seattle", "LA",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void InvalidNumPassengers2() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      Cars.bookVehicle(7, 6, "Seattle", "LA",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void InvalidNumPassengers3() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      Cars.bookVehicle(7, 0, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void equalsReflexivity() {
    assertTrue(Cars.equals(Cars));
  }

  @Test
  void equalsReflexivity2() throws IllegalPriceException {
    Cars2 = new Cars(40, 3);
    assertFalse(Cars.equals(Cars2));
  }

  @Test
  void equalsNull() {
    assertFalse(Cars.equals(null));
  }

  @Test
  void equalsDifferentDataTypes() {
    assertFalse(Cars.equals(Cars.getPrice()));
  }

  @Test
  void equalsSameField() throws IllegalPriceException {
    Cars2 = new Cars(50, 7);
    assertTrue(Cars.equals(Cars2));
  }

  @Test
  void equalsNotSameMaxOccupancy() throws IllegalPriceException {
    Cars2 = new Cars(50, 7);
    Cars.maxOccupancy = 3;
    assertFalse(Cars.equals(Cars2));
  }

  @Test
  void testHashcode() {
    int hash = Objects.hash(Cars.getMaxOccupancy(), Cars.getPrice(),
        Cars.isLicense(), Cars.isAllowDiff(), Cars.getNumBookDays());
    assertEquals(hash, Cars.hashCode());
  }


  @Test
  void testToString() {
    String expectedString = "Vehicles{" +
        "maxOccupancy=" + Cars.getMaxOccupancy() +
        ", price=" + Cars.getPrice() +
        ", license=" + Cars.isLicense() +
        ", allowDiff=" + Cars.isAllowDiff() +
        ", numBookDays=" + Cars.getNumBookDays() +
        '}';
    assertEquals(expectedString, Cars.toString());
  }
}