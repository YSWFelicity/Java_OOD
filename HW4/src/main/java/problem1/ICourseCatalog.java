package problem1;

public interface ICourseCatalog {

  /**
   * Adds a Course to the end of the CourseCatalog.
   * @param course
   */
  void append(Course course);

  /**
   *  Adds a Course to the beginning of the CourseCatalog.
   * @param course
   */
  void add(Course course);

  /**
   * Removes a specified course from the CourseCatalog.
   * @param course The course to be moved.
   */
  void remove(Course course) throws CourseNotFoundException;

  /**
   * Checks if the specified course exists in the CourseCatalog.
   * @param course The course to be checked.
   * @return True if the course exists in the CourseCatalog.
   */
  boolean contains(Course course);

  /**
   * Checks if the specified course exists in te CourseCatalog.
   * @param course The course to be checked.
   * @return the index of the specified Course in the CourseCatalog. If it exists. If the Course doesn't exist, returns -1.
   */
  int indexOf(Course course);

  /**
   * Gets the number of Courses in the CourseCatalog.
   * @return the number of Courses in the CourseCatalog.
   */
  int count();

  /**
   * Gets the course at the given index.
   * @param index The index.
   * @return the Course at the given index in the CourseCatalog.
   */
  Course get(int index) throws InvalidIndexException;

  /**
   * checks if the CourseCatalog is empty.
   * @return true if the CourseCatalog is empty.
   */
  boolean isEmpty();

}
