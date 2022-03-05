package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecordingArtistTest {

  private String expectedFirstName;
  private String expectedLastName;
  private RecordingArtist testRecordingArtist;

  @BeforeEach
  void setUp() throws Exception {
    expectedFirstName = "Felicity";
    expectedLastName = "Wang";
    testRecordingArtist = new RecordingArtist(expectedFirstName, expectedLastName);
  }

  @Test
  void getName() {
    String expectedName = expectedFirstName + " " + expectedLastName;
    assertEquals(expectedName, testRecordingArtist.getName());
  }

  @Test
  void getMembers() {
    assertNull(testRecordingArtist.getMembers());
  }
}