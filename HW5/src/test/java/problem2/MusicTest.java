package problem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MusicTest {

  private String expectedTitle;
  private Creator expectedCreator;
  private Integer expectedYear;
  private Music testMusic;

  @BeforeEach
  void setUp() throws Exception {
    expectedTitle = "goodBook";
    expectedCreator = new RecordingArtist("good", "author");
    expectedYear = 2021;
    testMusic = new Music(expectedTitle, expectedCreator, expectedYear);
  }

  @Test
  void testGetTitle() {
    assertEquals(expectedTitle, testMusic.getTitle());
  }
}