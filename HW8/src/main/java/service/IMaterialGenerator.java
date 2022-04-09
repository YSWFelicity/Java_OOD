package service;

import dataModel.Person;

/**
 * An interface that represents a common template.
 */
public interface IMaterialGenerator {

  /**
   * Create a common template
   *
   * @param person          - Person, person
   * @param outputDirectory - String, pathDriver
   * @param templatePath    - String, templatePath
   */
  void create(Person person, String outputDirectory, String templatePath);

}