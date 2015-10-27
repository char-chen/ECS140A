public class SequenceIterator extends Element {
  public Sequence current;
 
  public SequenceIterator(Sequence node) {
    current = node;
  }
  
  @Override
  public void Print() {
    current.Print();
  }
   
  public boolean equal(SequenceIterator other) {
    return this == other;
  }
  
  public void advance() {
    if (current != null)
      current = current.next;
  }

  public Element get() {
    if (current != null)
      return current.element;

    return null;
  }
}
