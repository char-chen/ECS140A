public class Token {
  public TK kind;
  public String string;
  public int lineNumber;
  
  public Token(TK kind, String string, int lineNumber) {
	  this.kind = kind;
	  this.string = string;
	  this.lineNumber = lineNumber;
  }
  
  public String toString() {
	  return "Token(" + kind.toString() + " " + string + " " + lineNumber + ")";
  }
}
