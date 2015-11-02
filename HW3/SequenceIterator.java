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
    return this.current == other.current;
  }
  
  public void advance() {
    current = current.next;
  }

  public Element get() {
    return current.element;
  }
}
