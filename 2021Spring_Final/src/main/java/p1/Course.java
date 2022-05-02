package p1;

import java.time.LocalDate;

public class Course {
  private String courseName;
  private String courseCode;
  private LocalDate yearTaken;
  private Integer grade;

  public Course(String courseName, String courseCode, LocalDate yearTaken, Integer grade) {
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

  public Integer getGrade() {
    return grade;
  }
}
