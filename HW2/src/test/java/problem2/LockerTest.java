package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LockerTest {
  private Recipient expectedRecipient;
  private Recipient wrongRecipient;
  private Mail expectedMail;
  private Mail occupyingMail;
  private Mail oversizeMail;
  private Locker testLocker;
  private Locker testLocker2;

  @BeforeEach
  public void setUp() throws Exception {
    expectedRecipient = new Recipient("Yingshu", "Wang",
        "correct@email.com");
    expectedMail = new Mail(2,2,2,expectedRecipient);
    testLocker = new Locker(3,3,3);
  }

  @Test
  public void testAddMailSuccess() throws  OversizeException, OccupiedException{
    testLocker.addMail(expectedMail);
  }

//  @Test //(expected = OversizeException.class)
//  public void testAddOverWidthMail() throws OversizeException, OccupiedException{
//    oversizeMail = new Mail(4,2,2,expectedRecipient);
//    testLocker.addMail(oversizeMail);
//  }
  @Test
  public void testAddOverWidthMail(){
    oversizeMail = new Mail(4,2,2,expectedRecipient);
    OversizeException thrown = Assertions.assertThrows(OversizeException.class, () -> {
      testLocker.addMail(oversizeMail);
    }, "Oversize Exception Expected");

    Assertions.assertEquals("The mail cannot fit in the locker.", thrown.getMessage());
  }

// @Test(expected = OversizeException.class)
//  public void testAddOverHeightMail() throws OversizeException, OccupiedException{
//    oversizeMail = new Mail(2,4,2,expectedRecipient);
//    testLocker.addMail(oversizeMail);
//  }
  @Test
  public void testAddOverHeightMail(){
    oversizeMail = new Mail(2,4,2,expectedRecipient);
    OversizeException thrown = Assertions.assertThrows(OversizeException.class, () -> {
      testLocker.addMail(oversizeMail);
    }, "Oversize Exception Expected");

    Assertions.assertEquals("The mail cannot fit in the locker.", thrown.getMessage());
  }

//  @Test(expected = OversizeException.class)
//  public void testAddOverDepthMail() throws OversizeException, OccupiedException{
//    oversizeMail = new Mail(2,2,4,expectedRecipient);
//    testLocker.addMail(oversizeMail);
//  }
//
  @Test
  public void testAddOverDepthMail(){
    oversizeMail = new Mail(2,2,4,expectedRecipient);
    OversizeException thrown = Assertions.assertThrows(OversizeException.class, () -> {
      testLocker.addMail(oversizeMail);
    }, "Oversize Exception Expected");

    Assertions.assertEquals("The mail cannot fit in the locker.", thrown.getMessage());
  }
//  @Test(expected = OccupiedException.class)
//  public void testOccupiedLocker() throws OversizeException, OccupiedException{
//    occupyingMail = new Mail(2,2,2,expectedRecipient);
//    testLocker2 = new Locker(3,3,3);
//    testLocker2.addMail(occupyingMail);
//    testLocker2.addMail(expectedMail);
//  }
  @Test
  public void testOccupiedLocker() throws OccupiedException, OversizeException {
    occupyingMail = new Mail(2,2,2,expectedRecipient);
    testLocker2 = new Locker(3,3,3);
    testLocker2.addMail(occupyingMail);
    OccupiedException thrown = Assertions.assertThrows(OccupiedException.class, () ->{
      testLocker2.addMail(expectedMail);
    }, "Occupied Exception expected");

    Assertions.assertEquals("This locker is already occupied.", thrown.getMessage());
  }

  @Test
  public void testPickupMailSuccess() throws OversizeException, OccupiedException,
      EmptyException, WrongRecipientException{
    testLocker.addMail(expectedMail);
    assertEquals(expectedMail,testLocker.pickupMail(expectedRecipient));
    assertNull(testLocker.getMail());
  }

//  @Test(expected = EmptyException.class)
//  public void testNoMailToPick() throws EmptyException, WrongRecipientException{
//    testLocker.pickupMail(expectedRecipient);
//  }
  @Test
  public void testNoMailToPick() throws EmptyException, WrongRecipientException{
    EmptyException thrown = Assertions.assertThrows(EmptyException.class, () ->{
      testLocker.pickupMail(expectedRecipient);
    }, "Empty Exception expected");

    Assertions.assertEquals("There is no mail in this locker", thrown.getMessage());
  }
//
//  @Test(expected = WrongRecipientException.class)
//  public void testWrongRecipient() throws OversizeException, OccupiedException,
//      EmptyException, WrongRecipientException{
//    wrongRecipient = new Recipient("Wrong","Guy","NoEmail");
//    testLocker.addMail(expectedMail);
//    testLocker.pickupMail(wrongRecipient);
//  }
  @Test
  public void testWrongRecipient() throws OversizeException, OccupiedException,
      EmptyException, WrongRecipientException{
    wrongRecipient = new Recipient("Wrong","Guy","NoEmail");
    testLocker.addMail(expectedMail);
    WrongRecipientException thrown = Assertions.assertThrows(WrongRecipientException.class, () ->{
      testLocker.pickupMail(wrongRecipient);
    }, "Wrong Recipient Expected");

    Assertions.assertEquals("This mail does not belong to you.", thrown.getMessage());

  }
  //this.mail.getRecipient().equals(recipient)

  @Test
  public void getMail() {
    assertNull(testLocker.getMail());
  }
}