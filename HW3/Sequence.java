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
    System.out.print("[ ");
        
    for (Sequence ptr = this; ptr != null; ptr = ptr.next, System.out.print(" "))
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
      
    for (int i = 0; ptr != null && i < pos; i++, ptr = ptr.next)
      prev = ptr;

    if (prev == null) {
      if (ptr.element != null)
        this.next = new Sequence(this.element, this.next);
        
      this.element = elem;
    }
    else
      prev.next = new Sequence(elem, ptr);
  }

  //Remove an element at specified psoition
  public void delete(int pos) {
    Sequence ptr = this, prev = null;
    
    for (int i = 0; ptr != null && i < pos; i++, ptr = ptr.next)
      prev = ptr;

    if (ptr != null) {
      if (prev == null) {
        this.element = this.next.element;
        this.next = this.next.next;
      }
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
    
    for (Sequence itr = this; itr != null; itr = itr.next)
      result.add(itr.element, result.length());
      
    return result;   
  }
   
  //Perform a deepy copy of Sequence object 
  public Sequence copy() {
    Sequence result = new Sequence();
    
    for (Sequence itr = this; itr != null; itr = itr.next)
      result.add(itr.element, result.length());
    
    return result;
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
