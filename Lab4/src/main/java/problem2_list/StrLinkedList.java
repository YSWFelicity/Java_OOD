package problem2_list;

public class StrLinkedList implements ListOfStrings{

  private Node listHead;

  public StrLinkedList(Node listHead) {
    this.listHead = listHead;
  }

  public StrLinkedList() {
    this.listHead = null;
  }

  @Override
  public Boolean isEmpty() {
    return (this.listHead==null);
  }

  @Override
  public Integer size() {
    if(isEmpty())
      return 0;
    else {
      int counter = 0;
      Node currentNode = this.listHead;
      while (currentNode.getPointerToNextElem() != null) {
        counter++;
        currentNode = currentNode.getPointerToNextElem();
      }
      return counter;
    }
  }

  @Override
  public Boolean contains(String element) {
    if(!isEmpty()){
      Node currentNode = this.listHead;
      while (currentNode.getPointerToNextElem() != null) {
        if (currentNode.getElement().equals(element))
          return true;
      }
    }
    return false;
  }

  @Override
  public Boolean containsAll(String[] elements) {
    return null;
  }

  @Override
  public ListOfStrings filterLargerThan(Integer largerThanBound) {
    StrLinkedList filteredList = new StrLinkedList();
    if(!isEmpty()){
      Node currentNode = this.listHead;
      while (currentNode.getPointerToNextElem() != null) {
        if (currentNode.getElement().length() > largerThanBound){
          filteredList.add(currentNode);
        }
      }
    }
    return filteredList;
  }

  private StrLinkedList add(Node nodeToAdd){
    if(this.isEmpty())
      return new StrLinkedList(nodeToAdd);
    else{
      Node newNode = new Node(nodeToAdd.getElement(), this.listHead);
      return new StrLinkedList(newNode);
    }
  }

  @Override
  public Boolean hasDuplicates() {
    return null;
  }

  @Override
  public ListOfStrings removeDuplicates() {
    return null;
  }
}
