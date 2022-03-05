package problem2;

/**
 * Represents a concrete class Music, extending its parent class Item
 */
public class Music extends Item{

  /**
   * Constructs an Item, with title, creator, and releasing year
   * @param title   - String, title of the Item
   * @param creator - Creator, creator of the Item
   * @param year    - Integer, releasing year of the Item
   */
  public Music(String title, Creator creator, Integer year) {
    super(title, creator, year);
  }
}
