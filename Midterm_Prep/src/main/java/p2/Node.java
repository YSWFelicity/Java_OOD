package p2;

import java.util.Objects;

public class Node {

  private final LoanApplication application;
  private Node nextNode;


  public Node(LoanApplication application, Node nextNode) {
    this.application = application;
    this.nextNode = nextNode;
  }

  public LoanApplication getApplication() {
    return application;
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
    return Objects.equals(application, node.application) && Objects.equals(
        nextNode, node.nextNode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(application, nextNode);
  }
}
