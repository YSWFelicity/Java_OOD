package problem2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CatalogTest {

  private Author a;
  private Book book;
  private RecordingArtist b;
  private RecordingArtist c;
  private RecordingArtist d;

  private Catalog testCatalog;
  private Catalog testCatalog2;

  private Set<RecordingArtist> members;
  private Set<RecordingArtist> members2;
  private Band band;
  private Band band2;
  private Music music1;
  private Music music2;
  private Music music3;

  @BeforeEach
  void setUp() throws Exception {
    a = new Author("aaaa", "bbbb");
    book = new Book("newCow", a, 2022);
    b = new RecordingArtist("cccc","dddd");
    c = new RecordingArtist("EEEE","FFFF");
    d = new RecordingArtist("GGGG","HHHH");

    testCatalog = new Catalog();

    members = new HashSet<>();
    members.add(b);
    members.add(c);
    members.add(d);
    members2 = new HashSet<>();
    members2.add(c);
    members2.add(d);

    band = new Band("a",members);
    band2 = new Band("anotherBand", members2);

    music1 = new Music("goodMusic", b, 2020);
    music2 = new Music("badMusic", band, 2020);
    music3 = new Music("badMusic2", band2, 2020);
  }

  @Test
  void search() {
    testCatalog.addItem(book);
    testCatalog.addItem(music1);
    testCatalog.addItem(music2);

    Set<Item> testOutput = testCatalog.search("music");

    Set<Item> expectedOutput = new HashSet<>();
    expectedOutput.add(music1);
    expectedOutput.add(music2);

    assertEquals(testOutput, expectedOutput);
  }

  @Test
  void testSearch() {
    testCatalog.addItem(book);
    testCatalog.addItem(music1);
    testCatalog.addItem(music2);

    Set<Item> testOutput = testCatalog.search(a);

    Set<Item> expectedOutput = new HashSet<>();
    expectedOutput.add(book);

    assertEquals(testOutput, expectedOutput);
  }

  @Test
  void testSearch1() {
    testCatalog.addItem(book);
    testCatalog.addItem(music1);
    testCatalog.addItem(music2);
    testCatalog.addItem(music3);

    Set<Item> testOutput = testCatalog.search(b);

    Set<Item> expectedOutput = new HashSet<>();
    expectedOutput.add(music1);
    expectedOutput.add(music2);

    assertEquals(testOutput, expectedOutput);
  }

  @Test
  void addItem() {
    testCatalog.addItem(book);
    for(Item item : testCatalog.getCollection()){
      assertEquals(book, item);
    }
  }

  @Test
  void getCollection() {
    assertEquals(0,testCatalog.getCollection().size());
  }

  @Test
  void testEquals() {
    assertTrue(testCatalog.equals(testCatalog));
    assertFalse(testCatalog.equals(null));
    assertFalse(testCatalog.equals(testCatalog.getCollection()));
  }

  @Test
  void testEquals2() {
    testCatalog2 = new Catalog();
    assertTrue(testCatalog.equals(testCatalog2));

    testCatalog2.addItem(book);
    assertFalse(testCatalog.equals(testCatalog2));
  }

  @Test
  void testHashCode() {
    testCatalog.addItem(book);
    int hash = Objects.hash(testCatalog.getCollection());
    assertEquals(hash, testCatalog.hashCode());
  }

  @Test
  void testToString() {
    testCatalog.addItem(book);
    String expectedString = "Catalog{" +
        "collection=" + testCatalog.getCollection() +
        '}';
    assertEquals(expectedString, testCatalog.toString());
  }
}