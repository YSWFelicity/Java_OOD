package P3;

import java.time.LocalDate;
import java.util.Objects;

/*
Class Course contains information about a course (course name and course code),
as well as information about which year has a student
taken the course, and which grade have they gotten.
*/
public class Course {

  private String courseName;
  private String courseCode;
  private LocalDate yearTaken;
  private Float grade;

  public Course(String courseName, String courseCode, LocalDate yearTaken, Float grade) {
    this.courseName = courseName;
    this.courseCode = courseCode;
    this.yearTaken = yearTaken;
    this.grade = grade;
  }

  public String getCourseName() {
    return courseName;
  }

  public String getCourseCode() {
    return courseCode;
  }

  public LocalDate getYearTaken() {
    return yearTaken;
  }

  public Float getGrade() {
    return grade;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Course course = (Course) o;
    return Objects.equals(courseName, course.courseName) && Objects.equals(
        courseCode, course.courseCode) && Objects.equals(yearTaken, course.yearTaken)
        && Objects.equals(grade, course.grade);
  }

  @Override
  public int hashCode() {
    return Objects.hash(courseName, courseCode, yearTaken, grade);
  }

  @Override
  public String toString() {
    return "Course{" +
        "courseName='" + courseName + '\'' +
        ", courseCode='" + courseCode + '\'' +
        ", yearTaken=" + yearTaken +
        ", grade=" + grade +
        '}';
  }
}
