import java.io.IOException;
import java.util.ArrayList;
import dataModel.Person;
import service.CSVProcessor;
import service.CommandLineExceptions;
import service.CommandLineParser;
import service.DirCreator;
import service.FileGenerator;

/**
 * Call other methods and execute.
 */
public class Main {

  public static void main(String[] args) {
    FileGenerator fileGenerator = new FileGenerator();
    CommandLineParser parser = null;
    try {
      parser = new CommandLineParser(args);
    } catch (CommandLineExceptions.LackArgumentsException e) {
      e.printStackTrace();
    }
    CSVProcessor csvProcessor = new CSVProcessor();
    DirCreator dirCreator = new DirCreator();

    try {
      dirCreator.createNewOutputDir(parser.getOutputDirAddress());
    } catch (IOException e) {
      e.printStackTrace();
    }
    ArrayList<Person> personInformationList =
        csvProcessor.collectCSVData(parser.getCsvFile());

    fileGenerator.generateEmail(parser, personInformationList);
    fileGenerator.generateLetter(parser, personInformationList);
  }
}