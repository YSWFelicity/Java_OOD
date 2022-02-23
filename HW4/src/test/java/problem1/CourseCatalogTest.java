package problem1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseCatalogTest {

  private String expectedName;
  private String expectedPrefix;
  private int expectedNumber;
  private Course expectedCourse;
  private Course expectedCourse2;
  private Course expectedCourse3;
  private CourseCatalog testCourseCatalog;
  private CourseCatalog testCourseCatalog2;

  @BeforeEach
  void setUp() throws Exception{
    expectedName = "a";
    expectedPrefix = "b";
    expectedNumber = 1;
    expectedCourse = new Course(expectedName,expectedPrefix,expectedNumber);
    expectedCourse2 = new Course("c","d",10000);
    testCourseCatalog = new CourseCatalog();
    testCourseCatalog2 = new CourseCatalog();
  }

  @Test
  void append() throws InvalidIndexException{
    testCourseCatalog.append(expectedCourse);
    assertTrue(testCourseCatalog.contains(expectedCourse));
    assertEquals(1,testCourseCatalog.count());
    testCourseCatalog.append(expectedCourse2);
    assertTrue(testCourseCatalog.contains(expectedCourse2));
    assertEquals(2,testCourseCatalog.count());
  }

  @Test
  void add() throws InvalidIndexException {
    testCourseCatalog.add(expectedCourse2);
    testCourseCatalog.add(expectedCourse);
    assertTrue(testCourseCatalog.contains(expectedCourse));
    assertEquals(expectedCourse, testCourseCatalog.get(0));
  }

  @Test
  void remove() throws CourseNotFoundException{
    testCourseCatalog.append(expectedCourse);
    testCourseCatalog.remove(expectedCourse);
    assertFalse(testCourseCatalog.contains(expectedCourse));
    assertEquals(0,testCourseCatalog.count());
  }

//  @Test(expected = CourseNotFoundException.class)
//  public void remove2() throws CourseNotFoundException{
//    testCourseCatalog.append(expectedCourse);
//    expectedCourse3 = new Course("d", expectedPrefix,expectedNumber);
//    testCourseCatalog.remove(expectedCourse3);
//  }


  @Test
  void remove2() {
    testCourseCatalog.append(expectedCourse);
    expectedCourse3 = new Course("d", expectedPrefix,expectedNumber);
    CourseNotFoundException thrown = Assertions.assertThrows(CourseNotFoundException.class, () -> {
      testCourseCatalog.remove(expectedCourse3);
    }, "Cannot remove the test");

    Assertions.assertEquals("No such course is found.", thrown.getMessage());
  }

  @Test
  void remove3() throws CourseNotFoundException{
    testCourseCatalog.append(expectedCourse);
    expectedCourse3 = new Course("d", expectedPrefix,expectedNumber);
    testCourseCatalog.append(expectedCourse3);
    testCourseCatalog.remove(expectedCourse3);
    assertFalse(testCourseCatalog.contains(expectedCourse3));
    assertEquals(1,testCourseCatalog.count());
  }

  @Test
  void contains() {
    assertFalse(testCourseCatalog.contains(expectedCourse));
    testCourseCatalog.append(expectedCourse);
    assertTrue(testCourseCatalog.contains(expectedCourse));
  }

  @Test
  void indexOf() {
    testCourseCatalog.append(expectedCourse);
    expectedCourse3 = new Course("d", expectedPrefix,expectedNumber);
    assertEquals(0,testCourseCatalog.indexOf(expectedCourse));
    assertEquals(-1,testCourseCatalog.indexOf(expectedCourse3));
  }

  @Test
  void count() {
    testCourseCatalog.append(expectedCourse);
    assertEquals(1, testCourseCatalog.count());
  }

  @Test
  void get() throws InvalidIndexException{
    testCourseCatalog.append(expectedCourse);
    assertEquals(expectedCourse,testCourseCatalog.get(0));
  }


//  @Test(expected = InvalidIndexException.class)
//  public void get2() throws InvalidIndexException{
//    testCourseCatalog.append(expectedCourse);
//    assertEquals(expectedCourse,testCourseCatalog.get(-1));
//  }
//


  @Test
  void get2() {
    testCourseCatalog.append(expectedCourse);
    InvalidIndexException thrown = Assertions.assertThrows(InvalidIndexException.class, () -> {
      assertEquals(expectedCourse,testCourseCatalog.get(-1));
    }, "Invalid Index");

    Assertions.assertEquals("Invalid index is input", thrown.getMessage());
  }

  //  @Test(expected = InvalidIndexException.class)
//  public void get3() throws InvalidIndexException{
//    testCourseCatalog.append(expectedCourse);
//    assertEquals(expectedCourse,testCourseCatalog.get(1));
//  }


  @Test
  void get3() {
    testCourseCatalog.append(expectedCourse);
    InvalidIndexException thrown = Assertions.assertThrows(InvalidIndexException.class, () -> {
      assertEquals(expectedCourse,testCourseCatalog.get(1));
    }, "Invalid Index");

    Assertions.assertEquals("Invalid index is input", thrown.getMessage());
  }

  @Test
  void isEmpty() {
    assertTrue(testCourseCatalog.isEmpty());
    testCourseCatalog.append(expectedCourse);
    assertFalse(testCourseCatalog.isEmpty());
  }

  @Test
  void testEquals() {
    assertTrue(testCourseCatalog.equals(testCourseCatalog));
  }

  @Test
  void testEquals2() {
    testCourseCatalog.append(expectedCourse);
    testCourseCatalog2.append(expectedCourse);
    assertTrue(testCourseCatalog.equals(testCourseCatalog2));
  }

  @Test
  void testEquals3() {
    testCourseCatalog2.append(expectedCourse);
    assertFalse(testCourseCatalog.equals(testCourseCatalog2));
  }

  @Test
  void testEquals4() {
    assertFalse(testCourseCatalog.equals(null));
  }

  @Test
  void testEquals5() {
    testCourseCatalog.append(expectedCourse);
    testCourseCatalog2.append(expectedCourse2);
    assertFalse(testCourseCatalog.equals(testCourseCatalog2));
  }

  @Test
  void testEquals6() {
    assertFalse(testCourseCatalog.equals(expectedCourse));
  }

  @Test
  void testHashCode() {
    testCourseCatalog.append(expectedCourse);
    Course[] a =  new Course[1];
    a[0] = expectedCourse;
    int result = Objects.hash(1);
    result = 31 * result + Arrays.hashCode(a);
    assertEquals(result, testCourseCatalog.hashCode());
  }

  @Test
  void testToString() {
    testCourseCatalog.append(expectedCourse);
    Course[] a =  new Course[1];
    a[0] = expectedCourse;
    String expectedString = "CourseCatalog{"
        + "courses="
        + Arrays.toString(a)
        + ", totalNum="
        + 1
        + '}';
    assertEquals(expectedString, testCourseCatalog.toString());
  }
}