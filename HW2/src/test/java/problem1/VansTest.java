package problem1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VansTest {
  Vans vans;

  @BeforeEach
  void setUp() throws Exception {
    vans = new Vans(70, 9);
  }
  @Test
  void invalidPrice() throws IllegalPriceException {
    IllegalPriceException thrown = Assertions.assertThrows(IllegalPriceException.class, () -> {
      Trucks invalidPriceTrucks = new Trucks(-4,7);
    }, "Invalid price");

    Assertions.assertEquals("Invalid price exception", thrown.getMessage());

  }

  @Test
  void getMaxOccupancy() {
    assertEquals(8,vans.getMaxOccupancy());
  }

  @Test
  void getPrice() {
    assertEquals(70.0, vans.getPrice());
  }

  @Test
  void isLicense() {
    assertTrue(vans.equals(vans));
  }

  @Test
  void isAllowDiff() {
    assertTrue(vans.equals(vans));
  }

  @Test
  void getNumBookDays() {
    assertEquals(9, vans.getNumBookDays());
  }

  @Test
  void setMaxOccupancy() {
    vans.setMaxOccupancy(8);
    assertEquals(8,vans.getMaxOccupancy());
  }

  ////  @Test
////  void bookVehicles() throws IllegalBookException {
////    Cars.bookVehicle(7, 5, "Seattle", "Seattle", true);
////    assertEquals("True", "True", "LA", Cars.getMaxOccupancy());
////  }
//
//
  @Test
  void InvalidNumPassengers1() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      vans.bookVehicle(9, -1, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void InvalidNumPassengers2() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      vans.bookVehicle(9, 9, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

  @Test
  void InvalidNumPassengers3() {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      vans.bookVehicle(9, 0, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }
}