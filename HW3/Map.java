public class Map extends Element {
  Pair head;
 
  public Map() {
  }

  @Override
  public void Print() {
    System.out.print("[ ");
        
    for (Pair ptr = head; ptr != null; ptr = ptr.next, System.out.print(" "))
      ptr.Print();
     
    System.out.print("]");
  }
  
  //Add an element to a specific position.
  public void add(Pair inval) {
    Pair ptr = head, prev = null;
      
    for (ptr = head; ptr != null && inval.key.Get() >= ptr.key.Get(); ptr = ptr.next)
      prev = ptr;

    if (prev == null)
      head = new Pair(inval.key, inval.value, head);
    else
      prev.next = new Pair(inval.key, inval.value, ptr);
  }

  public MapIterator find(MyChar key) {
    MapIterator itr;
    
    for (itr = begin(); !itr.equal(end()) && itr.current.key.Get() != key.Get(); itr.advance()); 
    
    return itr;
  }

  //First element of sequence
  public MapIterator begin() {
    return new MapIterator(head);
  }

  //One past the end
  public MapIterator end() {
    return new MapIterator(null);
  }
}
