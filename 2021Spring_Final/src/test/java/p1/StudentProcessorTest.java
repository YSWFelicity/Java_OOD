package p1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentProcessorTest {

  private StudentProcessor testStudentProcessor;
  private StudentProcessor testStudentProcessor2;
  private List<Student> studentList = new ArrayList<>();
  private LocalDate date = LocalDate.of(2020, 3, 12);
  private Course course1 = new Course("math", "123", date, 78);
  private Course course2 = new Course("cs101", "101", date, 92);
  private Course course3 = new Course("Algorithms", "5800", date, 85);
  private Course designCourse1 = new Course("design", "100", date, 92);
  private Course designCourse2 = new Course("design", "100", date, 82);
  private List<Course> courseList = new ArrayList<>();
  private Student student1;
  private Student student2;
  private Student student3;

  @BeforeEach
  void setUp() {
    courseList.add(course1);
    courseList.add(course2);
    courseList.add(course3);
    student1 = new Student("Jane", "A562RT23", "MSCS", courseList);
    studentList.add(student1);
    testStudentProcessor = new StudentProcessor(studentList);
  }

  @Test
  void mysteryMethod() {
    Integer testGradeThreshold1 = 80;
    Integer testGradeThreshold2 = 90;
    Long expectedCount1 = 1l;
    Long expectedCount2 = 2l;
    assertEquals(expectedCount1, testStudentProcessor.mysteryMethod(student1, testGradeThreshold1));
    assertEquals(expectedCount2, testStudentProcessor.mysteryMethod(student1, testGradeThreshold2));
  }

  @Test
  void filterByCourseByGrade() {
    List<Course> student2Courses = new ArrayList<>();
    student2Courses.add(course1);
    student2Courses.add(designCourse1);
    List<Course> student3Courses = new ArrayList<>();
    student3Courses.add(course3);
    student3Courses.add(designCourse2);
    student2 = new Student("matt", "1356345765", "MSCS", student2Courses);
    student3 = new Student("Harry", "78tyugjh", "MSCS", student3Courses);
    List<Student> expectedList1 = new ArrayList<>();
    expectedList1.add(student2);
    expectedList1.add(student3);
//    assertTrue(testStudentProcessor.courseGradeMeetsThreshold(student3, "design", 80));
    assertEquals(expectedList1, testStudentProcessor.filterByCourseByGrade("design", 80));
    List<Student> expectedList2 = new ArrayList<>();
    expectedList2.add(student2);
    assertEquals(expectedList2, testStudentProcessor.filterByCourseByGrade("design", 90));
  }
}