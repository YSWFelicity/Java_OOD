package problem2;

import java.util.Objects;

public class Node {
  private CollegeAthlete collegeAthlete;
  private Node nextNode;

  public Node(CollegeAthlete collegeAthlete, Node nextNode) {
    this.collegeAthlete = collegeAthlete;
    this.nextNode = nextNode;
  }

  public CollegeAthlete getCollegeAthlete() {
    return collegeAthlete;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return Objects.equals(collegeAthlete, node.collegeAthlete) && Objects.equals(
        nextNode, node.nextNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(collegeAthlete, nextNode);
  }

  @Override
  public String toString() {
    return "Node{" +
        "collegeAthlete=" + collegeAthlete +
        ", nextNode=" + nextNode +
        '}';
  }
}