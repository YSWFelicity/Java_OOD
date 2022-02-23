package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {

  private String expectedName;
  private String expectedPrefix;
  private int expectedNumber;
  private Course testCourse;
  private Course testCourse2;

  @BeforeEach
  void setUp() throws Exception{
    expectedName = "a";
    expectedPrefix = "b";
    expectedNumber = 1;
    testCourse = new Course(expectedName, expectedPrefix, expectedNumber);
  }

  @Test
  void testToString() {
    String expectedString = expectedPrefix + expectedNumber + ": " + expectedName;
    assertEquals(expectedString, testCourse.toString());
  }

  @Test
  void testEquals() {
    assertTrue(testCourse.equals(testCourse));
  }

  @Test
  void testEquals1() {
    testCourse2 = new Course(expectedName, expectedPrefix, expectedNumber);
    assertTrue(testCourse.equals(testCourse2));
  }

  @Test
  void testEquals2() {
    testCourse2 = new Course("c", "s", 2);
    assertFalse(testCourse.equals(testCourse2));
  }

  @Test
  void testEquals3() {
    assertFalse(testCourse.equals(null));
  }

  @Test
  void testEquals4() {
    assertFalse(testCourse.equals(new Course("b", expectedPrefix, expectedNumber)));
  }

  @Test
  void testEquals5() {
    assertFalse(testCourse.equals(new Course(expectedName, "c", expectedNumber)));
  }

  @Test
  void testEquals6() {
    assertFalse(testCourse.equals(new Course(expectedName, expectedPrefix, 1000000)));
  }

  @Test
  void testEquals7() {
    assertFalse(testCourse.equals(expectedName));
  }

  @Test
  void testHashCode() {
    int hash = Objects.hash(expectedName, expectedPrefix, expectedNumber);
    assertEquals(hash, testCourse.hashCode());
  }
}