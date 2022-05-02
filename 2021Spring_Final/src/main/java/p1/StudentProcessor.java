package p1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentProcessor {

  List<Student> studentList = new ArrayList<>();

  public StudentProcessor(List<Student> studentList) {
    this.studentList = studentList;
  }

  public StudentProcessor(Student student1, Student student2) {
    this.studentList.add(student1);
    this.studentList.add(student2);
  }

  /**
   * Method takes in a student and an integer grade, creates a stream of the given student's
   * taken courses, filters the stream to only contain courses taken with a grade less than or equal
   * to the given grade, and then uses the count method to return the long value indicating the
   * number of courses in the filtered stream.
   * @param student - student object whose list of taken courses we are considering
   * @param grade - integer representing the grade cutoff for our filter
   * @return Long - the number of taken courses by the given student with grade less than or equal to
   * given grades
   */

  public static Long mysteryMethod(Student student, Integer grade) {
    return student.getTakenCourses().stream()
      .filter(x -> x.getGrade() <= grade).count();
  }

  /**
   * Method filters studentList by students who have taken the given course and have received a
   * grade equal to or above the given grade on that course.
   * Note: uses helper method courseGradeMeetsThreshold
   * @param courseName
   * @param grade
   * @return List of students who have taken the given course and received at least the given grade
   */
  public List<Student> filterByCourseByGrade(String courseName, Integer grade){
    return this.studentList.stream().filter(x -> courseGradeMeetsThreshold(x, courseName, grade)).collect(
        Collectors.toList());
  }

  /**
   * Helper method that takes in a student object, courseName, and grade. The method looks at the
   * student's courses, finds the course matching courseName (if it exists), and checks that the
   * grade meets the given threshold grade. Returns true if so, returns false if the student has not
   * taken the course or has not meet the grade threshold.
   * @param student - student object
   * @param courseName - name of the course we are checking
   * @param grade - grade threshold
   * @return true if student meets criteria, false otherwise.
   */
  private boolean courseGradeMeetsThreshold(Student student, String courseName, Integer grade) {
    for (Course course : student.getTakenCourses()) {
      if (course.getCourseCode().equals(courseName)) {
        return course.getGrade() >= grade;
      }
    }
    return Boolean.FALSE;
  }
}
