package problem2;

import java.util.Objects;
import java.util.Set;

/**
 * Represents a concrete class Band, extending its parent class Group
 */
public class Band extends Group{

  private String name;
  private Set<RecordingArtist> members;
  /**
   * Constructs a Band, with name and a collection of members
   * @param name    - String, name of the group
   * @param members - Set of Person, collection of members
   */
  public Band(String name, Set<RecordingArtist> members) {
    this.name = name;
    this.members = members;
  }

  /**
   * {@inheritDoc}
   * Overrides getName(), returns a new string with Name;
   * @return String
   */
  @Override
  public String getName() {
    return this.name;
  }

  /**
   * {@inheritDoc}
   * Overrides getMembers()
   */
  @Override
  public Set<RecordingArtist> getMembers() {
    return this.members;
  }

  /**
   * {@inheritDoc} indicates whether some other object passed as an argument is "equal to" the
   * current instance
   *
   * @param o - an object to compare
   * @return boolean
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Band band = (Band) o;
    return Objects.equals(name, band.name) && Objects.equals(members,
        band.members);
  }

  /**
   * {@inheritDoc} returns an integer representation of the object memory address
   *
   * @return int
   */
  @Override
  public int hashCode() {
    return Objects.hash(name, members);
  }

  /**
   * {@inheritDoc} returns an String representation of the object
   *
   * @return String
   */
  @Override
  public String toString() {
    return "Band{" +
        "name='" + name + '\'' +
        ", members=" + members +
        '}';
  }
}
