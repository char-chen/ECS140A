public class Sequence extends Element {
  private Node head;
  private int count;
  
  public Sequence() {
    head = null;
    count = 0;
  }

  @Override
  public void Print() {
    System.out.print("[ ");
    
    for (SequenceIterator itr = this.begin(); !itr.equal(this.end()); itr.advance())
      itr.get().Print();

    System.out.print(
  }

  public Element first() {
    return head.data;
  }

  public Sequence rest() {
    
    return
  }
  
  public int length() {
    return count;
  }
  
  public void add(Element elem, int pos) {
    Node ptr = head, prev = null;
      
    for (int i = 0; i < pos; i++, ptr = ptr.next)
      prev = ptr;

    if (prev == null)
      head = new Node(elem, head);
    else
      prev.next = new Node(elem, ptr);
   
    count++;    
  }

  public void delete(int pos) {
    Node ptr = head, prev = null;
    
    for (int i = 0; ptr != null && i < pos; i++, ptr = ptr.next)
      prev = ptr;

    if (ptr != null) {
      if (prev == null)
        head = ptr.next;
      else
        prev.next = ptr.next;
    }
    
    count--;
  }
  
  public Element index(int pos) {
    Node ptr = head;

    for (int i = 0, i < pos; i++)
      ptr = ptr.next;
  
    return ptr.data;
  }

  public Sequence flatten() {
    Sequence result = new Sequence(); 
  }
    
  public void copy() {
    //deep
    //Sequence s1 = new Sequence()
    //s1.add(new SEquence().add(2));
    // s1.Print()
  }

  public SequenceIterator begin() {
    return new SequenceIterator(head);
  }

  public SequenceIterator end() {
    return null;
  }
}
