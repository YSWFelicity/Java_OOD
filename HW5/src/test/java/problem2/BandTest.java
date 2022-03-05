package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BandTest {

  private String expectedName;
  private String expectedName2;
  private Set<RecordingArtist> expectedMembers;
  private Set<RecordingArtist> expectedMembers2;
  private RecordingArtist expectedMember1;
  private RecordingArtist expectedMember2;
  private RecordingArtist expectedMember3;
  private Band testBand;
  private Band testBand2;

  @BeforeEach
  void setUp() {
    expectedName = "Beatles";
    expectedMember1 = new RecordingArtist("a", "b");
    expectedMember2 = new RecordingArtist("c", "d");
    expectedMember3 = new RecordingArtist("c", "d");

    expectedMembers = new HashSet<RecordingArtist>();
    expectedMembers.add(expectedMember1);
    expectedMembers.add(expectedMember2);

    testBand = new Band(expectedName, expectedMembers);
  }

  @Test
  void testGetName() {
    assertEquals(expectedName, testBand.getName());
  }

  @Test
  void testGetName2() {
    assertEquals(expectedMembers, testBand.getMembers());
  }

  @Test
  void testEquals() {
    assertTrue(testBand.equals(testBand));
    assertFalse(testBand.equals(null));
    assertFalse(testBand.equals(expectedName));
  }

  @Test
  void testEquals2() {
    testBand2 = new Band(expectedName, expectedMembers);
    assertTrue(testBand.equals(testBand2));

    expectedName2 = "abc";
    testBand2 = new Band(expectedName2, expectedMembers);
    assertFalse(testBand.equals(testBand2));


    expectedMembers2 = new HashSet<RecordingArtist>();
    expectedMembers.add(expectedMember1);
    expectedMembers.add(expectedMember3);
    testBand2 = new Band(expectedName, expectedMembers2);
    assertFalse(testBand.equals(testBand2));
  }

  @Test
  void testHashCode() {
    int hash = Objects.hash(testBand.getName(),testBand.getMembers());
    assertEquals(hash, testBand.hashCode());
  }

  @Test
  void testToString() {
    String expectedString = "Band{" +
        "name='" + expectedName + '\'' +
        ", members=" + expectedMembers +
        '}';
    assertEquals(expectedString, testBand.toString());
  }
}