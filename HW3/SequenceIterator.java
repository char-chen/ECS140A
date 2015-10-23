public class SequenceIterator extends Element {
  public Node current;
 
  public SequenceIterator(Node node) {
    current = node;
  }
   
  public boolean equal(SequenceIterator other) {
    return this.current == other.current; 
  }
  
  public SequenceIterator advance() {
    current = current.next;
    return this;
  }

  public Element get() {
    return current.data;
  }
}
