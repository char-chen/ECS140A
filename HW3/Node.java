public class Node {
  public Element data;
  public Node next;
  
  public Node(Element data, Node node) {
    this.data = data;
    next = node;
  }
}
