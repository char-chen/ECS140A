public class Sequence extends Element {
  Element element;
  Sequence next;
 
  public Sequence() {
  }
   
  public Sequence(Element element, Sequence next) {
    this.element = element;
    this.next = next;
  }
   
  @Override
  public void Print() {
    System.out.print("[");
        
    for (Sequence ptr = this; ptr != null; ptr = ptr.next)
      if (ptr.element != null)
        ptr.element.Print();
    
    System.out.print("]");
  }
  
  //Return first element.
  public Element first() {
    return this.element;
  }

  //Return the rest of the elements.
  public Sequence rest() {
    return this.next;
  }
  
  //Return number of elements.
  public int length() {
    int i = 0;
    
    for (Sequence ptr = this; ptr != null; ptr = ptr.next)
      i++;
    
    return i;
  }
  
  //Add an element to a specific position.
  public void add(Element elem, int pos) {
    Sequence ptr = this, prev = null;
      
    for (int i = 0; i < pos; i++, ptr = ptr.next)
      prev = ptr;

    if (prev == null)
      ptr = new Sequence(elem, this);
    else
      prev.next = new Sequence(elem, ptr);
  }

  //Remove an element at specified psoition
  public void delete(int pos) {
    Sequence ptr = this, prev = null;
    
    for (int i = 0; ptr != null && i < pos; i++, ptr = ptr.next)
      prev = ptr;

    if (ptr != null) {
      if (prev == null)
        ptr = ptr.next;
      else
        prev.next = ptr.next;
    }
  }
 
  //Access element at a particular position. 
  public Element index(int pos) {
    Sequence ptr = this;

    for (int i = 0; i < pos; i++)
      ptr = ptr.next;
  
    return ptr.element;
  }

  //Flatten a sequence.
  public Sequence flatten() {
    Sequence result = new Sequence();
    return result;   
  }
    
  public void copy() {
    Sequence result = new Sequence();
    
    for (SequenceIterator itr = this.begin(); !itr.equal(this.end()); itr.advance())
      result.add(itr.get(), this.length());
  }

  //First element of sequence
  public SequenceIterator begin() {
    return new SequenceIterator(this);
  }

  //One past the end
  public SequenceIterator end() {
    return null;
  }
}
