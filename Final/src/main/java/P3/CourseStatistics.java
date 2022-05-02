package P3;


import java.util.Objects;

/**
 * Represents a CourseStatistics object
 */
public class CourseStatistics {
  private Long numberOfStudents;
  private Long numberOfAlignStudents;
  private Double avgForAll;
  private Double avgForAlign;

  /**
   * Constructs a CourseStatistics object
   * @param numberOfStudents - number of students that have taken this course
   * @param numberOfAlignStudents - number of align students that have taken this course
   * @param avgForAll - avg grade for all students
   * @param avgForAlign - avg grade for align students
   */
  public CourseStatistics(Long numberOfStudents, Long numberOfAlignStudents,
      Double avgForAll, Double avgForAlign) {
    this.numberOfStudents = numberOfStudents;
    this.numberOfAlignStudents = numberOfAlignStudents;
    this.avgForAll = avgForAll;
    this.avgForAlign = avgForAlign;
  }

  public Long getNumberOfStudents() {
    return numberOfStudents;
  }

  public Long getNumberOfAlignStudents() {
    return numberOfAlignStudents;
  }

  public Double getAvgForAll() {
    return avgForAll;
  }

  public Double getAvgForAlign() {
    return avgForAlign;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CourseStatistics that = (CourseStatistics) o;
    return Objects.equals(numberOfStudents, that.numberOfStudents)
        && Objects.equals(numberOfAlignStudents, that.numberOfAlignStudents)
        && Objects.equals(avgForAll, that.avgForAll) && Objects.equals(
        avgForAlign, that.avgForAlign);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberOfStudents, numberOfAlignStudents, avgForAll, avgForAlign);
  }

  @Override
  public String toString() {
    return "CourseStatistics{" +
        "numberOfStudents=" + numberOfStudents +
        ", numberOfAlignStudents=" + numberOfAlignStudents +
        ", avgForAll=" + avgForAll +
        ", avgForAlign=" + avgForAlign +
        '}';
  }
}