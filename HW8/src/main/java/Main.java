import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import service.CSVProcessor;
import service.CommandLineExceptions;
import service.CommandLineParser;
import service.FileGenerator;

/**
 * Call other methods and execute.
 */
public class Main {

  public static void main(String[] args) {
    try {
      CommandLineParser parser= new CommandLineParser(args);
      String csvFile = parser.getCsvFile();
      Boolean emailCommand = parser.getEmailCommand();
      Boolean letterCommand = parser.getLetterCommand();
      String emailTemplatePath = parser.getEmailTemplateAddress();
      String letterTemplatePath = parser.getLetterTemplateAddress();
      String outputDir = parser.getOutputDirAddress();
      if (emailCommand && !emailTemplatePath.equals("")) {
        FileGenerator fileGenerator = new FileGenerator(csvFile, emailTemplatePath);
        fileGenerator.writeAllFiles(outputDir);
      }
      if (letterCommand && !letterTemplatePath.equals("")) {
        FileGenerator fileGenerator = new FileGenerator(csvFile, emailTemplatePath);
        fileGenerator.writeAllFiles(outputDir);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
//    CommandLineParser parser = null;
//    try {
//      parser = new CommandLineParser(args);
//    } catch (CommandLineExceptions.LackArgumentsException e) {
//      e.printStackTrace();
//    }
//    CSVProcessor csvProcessor = new CSVProcessor();


//    ArrayList<Person> personInformationList =
//        csvProcessor.collectCSVData(parser.getCsvFile());
//
//    fileGenerator.generateEmail(parser, personInformationList);
//    fileGenerator.generateLetter(parser, personInformationList);
  }
}