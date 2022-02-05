package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RecipientTest {

  private String expectedFirstName;
  private String expectedLastName;
  private String expectedEmailAddress;
  private Recipient testRecipient;

  @BeforeEach
  public void setUp() throws Exception {
    expectedFirstName = "Yingshu";
    expectedLastName = "Wang";
    expectedEmailAddress = "ysw@neu.edu";
    testRecipient = new Recipient(expectedFirstName, expectedLastName, expectedEmailAddress);
  }

  @Test
  public void getFirstName() {
    assertEquals(expectedFirstName, testRecipient.getFirstName());
  }

  @Test
  public void getLastName() {
    assertEquals(expectedLastName, testRecipient.getLastName());
  }

  @Test
  public void getEmailAddress() {
    assertEquals(expectedEmailAddress, testRecipient.getEmailAddress());
  }
}