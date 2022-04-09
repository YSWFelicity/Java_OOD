package service;

import java.io.File;
import java.io.IOException;

/**
 * A class that represents creating new out put director.
 */
public class DirCreator {

  /**
   * Creating new out put director
   *
   * @param outputPath, String
   */
  public void createNewOutputDir(String outputPath) throws IOException {
    File dir = new File(outputPath);
    if (!dir.exists()) {
      dir.createNewFile();
    }
  }

}