package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VehiclesTest {
  private Vehicles TestVehicles;

  @BeforeEach
  void setUp() throws Exception {
    TestVehicles = new Vehicles(200,true,true,12);
  }

  @Test
  void invalidPrice() throws IllegalPriceException {
    Vehicles vehiclesInvalid = new Vehicles(1, false, false, 11);
  }

  @Test
  void getMaxOccupancy() {
    assertEquals(8, TestVehicles.getMaxOccupancy());
  }

  @Test
  void getPrice() {
    assertEquals(200.0, TestVehicles.getPrice());
  }

  @Test
  void isLicense() {
    assertTrue(TestVehicles.isLicense()); //Questions
  }

  @Test
  void isAllowDiff() {
    assertTrue(TestVehicles.isAllowDiff());
  }

  @Test
  void isAvailable() throws IllegalPriceException, IllegalBookException {
    TestVehicles = new Vehicles(200,true,true,0);
    assertTrue(TestVehicles.bookVehicle(10, 0, "Seattle", "Seattle", true));
  }

  @Test
  void getNumBookDays() {
    assertEquals(12, TestVehicles.getNumBookDays());
  }

  @Test
  void setMaxOccupancy() {
    TestVehicles.setMaxOccupancy(8);
    assertEquals(8, TestVehicles.getMaxOccupancy());
  }

  @Test
  void invalidBookVehicle() throws IllegalBookException {
    IllegalBookException thrown = Assertions.assertThrows(IllegalBookException.class, () -> {
      TestVehicles.bookVehicle(12, -1, "Seattle", "Seattle",false);
    }, "Invalid Booking");

    Assertions.assertEquals("Invalid book exception", thrown.getMessage());
  }

}