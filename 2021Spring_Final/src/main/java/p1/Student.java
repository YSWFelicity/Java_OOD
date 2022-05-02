package p1;

import java.util.List;

public class Student {

  private String name;
  private String studentID;
  private String academicProgram;
  private List<Course> takenCourses;

  public Student(String name, String studentID, String academicProgram,
      List<Course> takenCourses) {
    this.name = name;
    this.studentID = studentID;
    this.academicProgram = academicProgram;
    this.takenCourses = takenCourses;
  }

  public String getName() {
    return name;
  }

  public String getStudentID() {
    return studentID;
  }

  public String getAcademicProgram() {
    return academicProgram;
  }

  public List<Course> getTakenCourses() {
    return takenCourses;
  }
}




