package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonthlyDonationTest {

  private Float monthlyAmount1;
  private LocalDateTime subscriptionTime1;
  private LocalDateTime subscriptionTime2;
  private LocalDateTime subscriptionTime3;
  private LocalDateTime cancellationTime1;
  private LocalDateTime cancellationTime2;
  private LocalDateTime cancellationTime3;
  private MonthlyDonation testMonthlyDonation;
  private MonthlyDonation testMonthlyDonation2;

  @BeforeEach
  void setUp() throws Exception{
    subscriptionTime1 = LocalDateTime.of(2021,5,19,1,1,1);
    cancellationTime1 = LocalDateTime.of(2021,6,20,1,1,1);
    monthlyAmount1 = 1f;
    testMonthlyDonation = new MonthlyDonation(monthlyAmount1, subscriptionTime1);
  }

  @Test
  void setCancellationTime() throws InvalidCancellationDateException{
    testMonthlyDonation.setCancellationTime(cancellationTime1);
    assertEquals(cancellationTime1, testMonthlyDonation.getCancellationTime());
  }

//  @Test (expected = InvalidCancellationDateException.class)
//  public void setCancellationTime2() throws InvalidCancellationDateException{
//    cancellationTime2 =
//        LocalDateTime.of(2021,4,4,4,4,4);
//    testMonthlyDonation.setCancellationTime(cancellationTime2);
//  }


  @Test
  void setCancellationTime2() {
    cancellationTime2 =
        LocalDateTime.of(2021,4,4,4,4,4);
    InvalidCancellationDateException thrown = Assertions.assertThrows(InvalidCancellationDateException.class, () -> {
      testMonthlyDonation.setCancellationTime(cancellationTime2);
    }, "Invalid Cancellation Date");

    Assertions.assertEquals("Invalid cancellation date is input", thrown.getMessage());
  }

  @Test
  void countYearlyAmount() throws InvalidCancellationDateException{
    assertEquals(8f,testMonthlyDonation.countYearlyAmount(2021),0);
    assertEquals(12f,testMonthlyDonation.countYearlyAmount(2022),0);
    assertEquals(0f,testMonthlyDonation.countYearlyAmount(2020),0);

    testMonthlyDonation.setCancellationTime(cancellationTime1);
    assertEquals(2f,testMonthlyDonation.countYearlyAmount(2021),0);
    assertEquals(0f,testMonthlyDonation.countYearlyAmount(2022),0);
    assertEquals(0f,testMonthlyDonation.countYearlyAmount(2020),0);

    cancellationTime2 =
        LocalDateTime.of(2022,6,20,1,1,1);
    testMonthlyDonation.setCancellationTime(cancellationTime2);
    assertEquals(8f,testMonthlyDonation.countYearlyAmount(2021),0);
    assertEquals(6f,testMonthlyDonation.countYearlyAmount(2022),0);
    assertEquals(0f,testMonthlyDonation.countYearlyAmount(2020),0);

    cancellationTime2 =
        LocalDateTime.of(2022,6,18,1,1,1);
    testMonthlyDonation.setCancellationTime(cancellationTime2);
    assertEquals(8f,testMonthlyDonation.countYearlyAmount(2021),0);
    assertEquals(5f,testMonthlyDonation.countYearlyAmount(2022),0);

    cancellationTime2 =
        LocalDateTime.of(2022,6,19,0,1,1);
    testMonthlyDonation.setCancellationTime(cancellationTime2);
    assertEquals(5f,testMonthlyDonation.countYearlyAmount(2022),0);

    cancellationTime2 =
        LocalDateTime.of(2022,6,19,1,0,1);
    testMonthlyDonation.setCancellationTime(cancellationTime2);
    assertEquals(5f,testMonthlyDonation.countYearlyAmount(2022),0);


    cancellationTime2 =
        LocalDateTime.of(2022,6,19,1,1,0);
    testMonthlyDonation.setCancellationTime(cancellationTime2);
    assertEquals(5f,testMonthlyDonation.countYearlyAmount(2022),0);

    cancellationTime2 =
        LocalDateTime.of(2022,6,19,2,1,1);
    testMonthlyDonation.setCancellationTime(cancellationTime2);
    assertEquals(6f,testMonthlyDonation.countYearlyAmount(2022),0);

    cancellationTime2 =
        LocalDateTime.of(2022,6,19,1,2,1);
    testMonthlyDonation.setCancellationTime(cancellationTime2);
    assertEquals(6f,testMonthlyDonation.countYearlyAmount(2022),0);

    cancellationTime2 =
        LocalDateTime.of(2022,6,19,1,1,2);
    testMonthlyDonation.setCancellationTime(cancellationTime2);
    assertEquals(6f,testMonthlyDonation.countYearlyAmount(2022),0);
  }

  @Test
  void getMonthlyAmount() {
    assertEquals(1f,testMonthlyDonation.getMonthlyAmount(),0);
  }

  @Test
  void getSubscriptionTime() {
    assertEquals(subscriptionTime1,testMonthlyDonation.getSubscriptionTime());
  }

  @Test
  void getCancellationTime() throws InvalidCancellationDateException{
    assertNull(testMonthlyDonation.getCancellationTime());
    testMonthlyDonation.setCancellationTime(cancellationTime1);
    assertEquals(cancellationTime1,testMonthlyDonation.getCancellationTime());
  }

  @Test
  void testEquals() throws InvalidCancellationDateException{
    assertTrue(testMonthlyDonation.equals(testMonthlyDonation));
    assertFalse(testMonthlyDonation.equals(null));
    assertFalse(testMonthlyDonation.equals(subscriptionTime1));
  }

  @Test
  void testEquals2() throws InvalidCancellationDateException{
    testMonthlyDonation2 = new MonthlyDonation(monthlyAmount1, subscriptionTime1);
    assertTrue(testMonthlyDonation.equals(testMonthlyDonation2));

    testMonthlyDonation.setCancellationTime(cancellationTime1);
    testMonthlyDonation2.setCancellationTime(cancellationTime1);

    subscriptionTime1 = LocalDateTime.of(2021,5,19,1,1,2);
    cancellationTime1 = LocalDateTime.of(2021,6,20,1,1,1);
    monthlyAmount1 = 1f;
    testMonthlyDonation2 = new MonthlyDonation(monthlyAmount1, subscriptionTime1);
    assertFalse(testMonthlyDonation.equals(testMonthlyDonation2));

    subscriptionTime1 = LocalDateTime.of(2021,5,19,1,1,1);
    cancellationTime1 = LocalDateTime.of(2021,6,20,1,1,2);
    monthlyAmount1 = 1f;
    testMonthlyDonation2 = new MonthlyDonation(monthlyAmount1, subscriptionTime1);
    assertFalse(testMonthlyDonation.equals(testMonthlyDonation2));

    subscriptionTime1 = LocalDateTime.of(2021,5,19,1,1,1);
    cancellationTime1 = LocalDateTime.of(2021,6,20,1,1,1);
    monthlyAmount1 = 2f;
    testMonthlyDonation2 = new MonthlyDonation(monthlyAmount1, subscriptionTime1);
    assertFalse(testMonthlyDonation.equals(testMonthlyDonation2));

    subscriptionTime1 = LocalDateTime.of(2021,5,19,1,1,2);
    cancellationTime1 = LocalDateTime.of(2021,6,20,1,1,2);
    monthlyAmount1 = 2f;
    testMonthlyDonation2 = new MonthlyDonation(monthlyAmount1, subscriptionTime1);
    assertFalse(testMonthlyDonation.equals(testMonthlyDonation2));
  }

  @Test
  void testHashCode() {
    int hash = Objects.hash(monthlyAmount1, subscriptionTime1, null);
    assertEquals(hash, testMonthlyDonation.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "MonthlyDonation{" +
        "monthlyAmount=" + monthlyAmount1 +
        ", subscriptionTime=" + subscriptionTime1 +
        ", cancellationTime=" + null +
        '}';
    assertEquals(expectedString, testMonthlyDonation.toString());
  }
}