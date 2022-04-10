package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A class that represents the file generator
 */
public class FileGenerator {
  private static String bracket = "\\[\\[(.+?)]]";
  private String template;
  private List<String> placeholders = new ArrayList<>();

  List<Map<String, String>> infoList;

  public FileGenerator(String csvFilePath, String templateFilepath) throws IOException {
    loadInfo(csvFilePath);
    readTemplate(templateFilepath);
    collectedPlaceHolders();
  }

  private void loadInfo(String csvFilePath) throws IOException {
    CSVProcessor csvProcessor = new CSVProcessor(csvFilePath);
    this.infoList = csvProcessor.collectCSVData(csvFilePath);
  }

  private void readTemplate(String templateFilePath) {
    try {
      Path in = Paths.get(templateFilePath);
      List<String> lines = Files.readAllLines(in);
      StringBuilder sb = new StringBuilder();
      for (String line : lines) {
        sb.append(line);
        sb.append(System.lineSeparator());
      }
      this.template = sb.toString();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void collectedPlaceHolders() {
    Pattern p = Pattern.compile(bracket);
    Matcher m = p.matcher(this.template);
    while (m.find()) {
      String placeholder = m.group();
      placeholders.add(placeholder);
    }
  }

  public void writeAllFiles(String outputDir) throws IOException {
    for (Map<String, String> info : this.infoList) {
      writeOneFile(outputDir, info);
    }
  }

  private void writeOneFile(String outputDir, Map<String, String> info) throws IOException {
    String output = this.template;
    for (String placeholder : this.placeholders) {
      String entryName = placeholder
          .replace("[", "")
          .replace("]", "");
      String actualContent  = info.get(entryName);
      output = output.replace(placeholder, actualContent);
    }

    String firstName = info.get("first_name");
    String lastName = info.get("last_name");

    if (!outputDir.endsWith(File.separator)) {
      outputDir += File.separator;
    }
    String outputFileName = outputDir + firstName + "_" + lastName + ".txt";
    BufferedWriter writer= new BufferedWriter(new FileWriter(outputFileName));
    writer.write(output);
    writer.close();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FileGenerator that = (FileGenerator) o;
    return Objects.equals(template, that.template) && Objects.equals(placeholders,
        that.placeholders) && Objects.equals(infoList, that.infoList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(template, placeholders, infoList);
  }

  @Override
  public String toString() {
    return "FileGenerator{" +
        "template='" + template + '\'' +
        ", placeholders=" + placeholders +
        ", infoList=" + infoList +
        '}';
  }

  //  /**
//   * A method that is used to generate emails.
//   *
//   * @param parser CommandLineParser
//   */
//  public void generateFile(CommandLineParser parser) {
//    if (parser.getEmailCommand()) {
//
//    }
//  }
//
//  /**
//   * A method that is used to generate letters.
//   *
//   * @param parser CommandLineParser
//   * @param list   ArrayList
//   */
//  public void generateLetter(CommandLineParser parser, ArrayList<Person> list) {
//    if (parser.getLetterCommand()) {
//      IMaterialGenerator generator = new LetterGenerator();
//      for (Person person : list) {
//        generator.create(person, parser.getOutputDirAddress(),
//            parser.getLetterTemplateAddress());
//      }
//    }
//  }

}