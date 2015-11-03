public class MapIterator extends Element {
  public Pair current;
 
  public MapIterator(Pair node) {
    current = node;
  }
  
  @Override
  public void Print() {
    current.Print();
  }
   
  public boolean equal(MapIterator other) {
    if (other.current == null || current == null)
      return other.current == current;
    else
      return this.current.key.Get() == other.current.key.Get();
  }
  
  public void advance() {
    current = current.next;
  }

  public Pair get() {
    return current;
  }
}
