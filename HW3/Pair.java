public class Pair {
  public MyChar key;
  public Element value;
  public Pair next;
  
  public Pair(MyChar key, Element value, Pair next) {
    this.key = key;
    this.value = value;
    this.next = next;
  }

  public Pair(MyChar key, Element value) {
    this.key = key;
    this.value = value;
  }

  public void Print() {
    System.out.print("(");
    key.Print();
    System.out.print(" ");
    value.Print();
    System.out.print(")");
  }
}
