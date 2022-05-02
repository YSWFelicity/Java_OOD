package P3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Represents a CourseRecommender Class
 */
public class CourseRecommender {
  private List<Student> students;
  private List<Student> alignStudents;
  private Map<String, CourseStatistics> info;
  private static final String CS5001 = "CS 5001";
  private static final String CS5002 = "CS 5002";
  private static final String CS5004 = "CS 5004";
  private static final String CS5008 = "CS 5008";
  private static final Double ZERO = 0.0;
  private static final Long ZERO_LONG = 0L;
  private static final Double ZERO_DOUBLE = 0.0;
  private static final String CODE = "0000";
  private static final Float GRADE = 3.8f;

  /**
   * Constructs a CourseRecommender object
   * @param students - a list of Students
   * @param alignStudents - a list of Align Studetns
   * @param info - the map
   */
  public CourseRecommender(List<Student> students, List<Student> alignStudents, Map<String, CourseStatistics> info) {
    this.students = students;
    this.alignStudents = alignStudents;
    this.info = info;
  }

  /**
   * Constructs a CourseRecommender object
   * @param students - a list of students
   */
  public CourseRecommender(List<Student> students) {
    this.students = students;
    this.alignStudents = filterOutAlignStudents(students);
    this.info = computeCollegeCourseStatistics(students);

  }

  /**
   * Helper method which takes a list of all students and create a Map, where key is the course name, and values
   * is the CourseStatistics
   * @param students
   * @return
   */
  private Map<String, CourseStatistics> computeCollegeCourseStatistics(List<Student> students){
    Map<String, CourseStatistics> res = new HashMap<>();
    for(Student student: students){
      List<Course> taken = student.getTakenCourses();
      for(Course course: taken){
        String name = course.getCourseName();
        Long studentNum = calculateStudentNum(students, name);
        Long alignNum = calculateAlignNum(students, name);
        Double avgForAll = calculateAvgAll(students, name);
        Double avgForAlign = calculateAvgAlign(students, name);
        if(!res.containsKey(name)){
          CourseStatistics cs = new CourseStatistics(studentNum, alignNum,avgForAll, avgForAlign);
          res.put(name, cs);
        }
      }
    }
    return res;
  }

  /**
   * Helper method to count the students who have taken this course
   * @param students - a list of students
   * @param name - course name
   * @return number of students who have taken this course
   */
  private Long calculateStudentNum(List<Student> students, String name){
    return students.stream().filter(x -> haveTake(x, name)).collect(Collectors.counting());
  }

  /**
   * Helper method to count the align students who have taken this course
   * @param students - a list of students
   * @param name - the name of the course
   * @return number of align students
   */
  private Long calculateAlignNum(List<Student> students, String name){
    return students.stream().filter(x -> takeCourses(x)).filter(x -> haveTake(x, name)).collect(Collectors.counting());
  }

  /**
   * Helper method to calculate the avg grade for the course
   * @param students - a list of students
   * @param name - the course name;
   * @return avg grade
   */
  private Double calculateAvgAll(List<Student> students, String name){
    Long studentNum = calculateStudentNum(students, name);
    List<Student> filter = students.stream().filter(x -> haveTake(x, name)).collect(Collectors.toList());
    Double totalGrade = ZERO;
    for(Student student: filter){
      for(Course course: student.getTakenCourses()){
        if(course.getCourseName().equals(name)){
          totalGrade += course.getGrade();
        }
      }
    }
    return totalGrade/studentNum;

  }

  /**
   * Helper method to calculate the avg grade for the coursen for align students
   * @param students - a list of students
   * @param name - the course name;
   * @return avg grade
   */
  private Double calculateAvgAlign(List<Student> students, String name){
    List<Student> alignStudent = students.stream().filter(x -> takeCourses(x)).collect(Collectors.toList());
    Long alignNum = calculateAlignNum(students, name);
    Double totalGrade = ZERO;
    for(Student student: alignStudent){
      for(Course course: student.getTakenCourses()){
        if(course.getCourseName().equals(name)){
          totalGrade += course.getGrade();
        }
      }
    }
    return totalGrade/alignNum;
  }

  /**
   * Helper method to determine if a student has taken this course
   * @param student - the student we are looking at
   * @param name - the name of the course
   * @return boolean
   */
  private boolean haveTake(Student student, String name){
    return student.getTakenCourses().contains(name);
  }

  /**
   * Helper method to get Align students list
   * @param students - all students
   * @return a list of align students
   */
  private List<Student> filterOutAlignStudents(List<Student> students){
    return students.stream().filter(x -> takeCourses(x)).collect(Collectors.toList());

  }

  /**
   * Helper method to determine if a student is an align student
   * @param student - the student we are looking at
   * @return boolean
   */
  private Boolean takeCourses(Student student){
    return student.getTakenCourses().contains(CS5001) &&
        student.getTakenCourses().contains(CS5002) &&
        student.getTakenCourses().contains(CS5004) &&
        student.getTakenCourses().contains(CS5008);

  }

  /**
   * Recommend 3 courses a student should consider taking
   * first course: taken by most students in the college, if taken, take the next one
   * second course: highest avg grade
   * third course: taken by least stdents in the college
   * @param student - the student we are recommending
   * @return a list of 3 courses
   */
  public List<Course> recommendCourses(Student student){
    List<Course> res = new ArrayList<>();
    Course first = getFirst(student);
    Course second = getSecond(student);
    Course third = getThird(student);
    res.add(first);
    res.add(second);
    res.add(third);
    return res;

  }

  /**
   * Helper method to find the first course
   * @param student - the student we are looking at
   * @return course
   */
  private Course getFirst(Student student){
    Long number = 0L;
    Course res = null;
    for(String courseName: this.info.keySet()){
      Long freq = this.info.get(courseName).getNumberOfStudents();
      if(freq > number){
        if(!student.getTakenCourses().contains(courseName)){
          number = freq;
          res = new Course(courseName, CODE, LocalDate.of(2021, 2, 2), GRADE);
        }
      }
    }
    return res;
  }

  /**
   * Helper method to find the second course
   * @param student - the student we are looking at
   * @return course
   */
  private Course getSecond(Student student){
    Double grade = ZERO_DOUBLE;
    Course res = null;
    for(String courseName: this.info.keySet()){
      Double freq = this.info.get(courseName).getAvgForAll();
      if(freq > grade){
        if(!student.getTakenCourses().contains(courseName)){
          grade = freq;
          res = new Course(courseName, CODE, LocalDate.of(2021, 2, 2), GRADE);
        }
      }
    }
    return res;
  }

  /**
   * Helper method to find the third course
   * @param student - the student we are looking at
   * @return course
   */
  private Course getThird(Student student){
    Long number = ZERO_LONG;
    Course res = null;
    for(String courseName: this.info.keySet()){
      Long freq = this.info.get(courseName).getNumberOfStudents();
      if(freq < number){
        if(!student.getTakenCourses().contains(courseName)){
          number = freq;
          res = new Course(courseName, CODE, LocalDate.of(2021, 2, 2), GRADE);
        }
      }
    }
    return res;
  }
}