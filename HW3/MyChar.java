public class MyChar extends Element {
  private char c;
  
  public MyChar() {
    c = '0';
  }
  
  public MyChar(char c) {
    this.c = c;
  }
    
  public char Get() { 
    return c;
  }
  
  public void Set(char val){ 
    c = val;
  }
  
  @Override
  public void Print() {
    System.out.print("'" + c + "'");
  }
}
