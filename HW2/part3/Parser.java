import java.util.Stack;
import java.util.ArrayList;

public class Parser {

  private Token tok;
  private Scan scanner;
  private Stack<ArrayList<Token>> symbolTable;
   
  private void scan() {
    tok = scanner.scan();
  }

  Parser(Scan scanner) {
    this.scanner = scanner;
    symbolTable = new Stack<ArrayList<Token>>();
    scan();
    program();
    if( tok.kind != TK.EOF )
      parse_error("junk after logical end of program");
  }

  private void program() {
    block();
  }

  private void block(){
    symbolTable.push(new ArrayList<Token>());
    declaration_list();
    statement_list();
    symbolTable.pop();
  }

  private void declaration_list() {
    while(is(TK.DECLARE))
      declaration();
  }

  private void declaration() {
    mustbe(TK.DECLARE);
    
    do {
      scan();
      mustbe(TK.ID);
      Token prev = tok;
      scan();
      
      if (contains(prev, 0, false))
        System.err.println("redeclaration of variable " + prev.string);
      else
        symbolTable.peek().add(prev);
     
    } while(is(TK.COMMA));
  }
  
  public boolean contains(Token t, int scope, boolean done)
  {
    if(scope == -1) 
      scope = symbolTable.size() - 1;
    
    for (int i = symbolTable.size() - 1 - scope; i >= 0; i--)
    {
      for(Token var : symbolTable.elementAt(i))
        if(t.string.equals(var.string))
          return true;
      
      if(!done)
        break;
    }
    
    return false;
  }
  
  private void statement_list() {
    while (statement());
  }
  
  private boolean statement() {
    if (is(TK.ID) || is(TK.TILDE))
      assignment();
    else if(is(TK.PRINT))
      print();
    else if(is(TK.DO))
      DO();
    else if(is(TK.IF))
      IF();
    else
      return false;
    
    return true;
  }
  
  private void print() {
    scan(); 
    expr(); 
  } 
  
  private void assignment() {
    ref_id();
    mustbe(TK.ASSIGN);
    scan();
    expr();
  }
  
  private void ref_id() {
    int scope = 0;
    boolean isTilde = is(TK.TILDE);
     
    if (isTilde)
    {
      scan();
    
      if (is(TK.NUM)) {
        scope = Integer.parseInt(tok.string);
        scan();
      }
      else
        scope = -1;
    }
    
    Token prev = tok;
    mustbe(TK.ID);
    scan();
     
    if (!contains(prev, scope, !isTilde)) {
      if (isTilde)
        System.err.println("no such variable ~" + (scope == -1 ? "" : scope) + prev.string + " on line " + prev.lineNumber);
      else {
        System.err.println(prev.string + " is an undeclared variable on line " + prev.lineNumber);
        System.exit(1);
      }
    }
  }

  private void DO() {
    scan();
    guarded_command();
    mustbe(TK.ENDDO);
    scan();
  }
  
  private void IF() {
    scan();
    guarded_command();
    
    while (is(TK.ELSEIF)) {
      scan();
      guarded_command();
    }
    
    if (is(TK.ELSE)) {
      scan();
      block();
    }

    mustbe(TK.ENDIF);
    scan();
  }
  
  private void guarded_command() {
    expr();
    mustbe(TK.THEN);
    scan();
    block();
  }

  private void expr() {
    term();
    
    while (addop())
      term();
  }

  private void term() {
    factor();
    
    while (multop())
      factor();
  }
  
  private void factor() {
    if (is(TK.LPAREN)) {
      scan();
      expr();
      mustbe(TK.RPAREN);
      scan();
    }
    else if ((is(TK.TILDE)) || is(TK.ID))
      ref_id();
    else {
      mustbe(TK.NUM);
      scan();
    }
  }
   
  private boolean addop() {
    if (is(TK.PLUS) || is(TK.MINUS)) {
      scan();
      return true;
    }
    
    return false; 
  }

  private boolean multop() {
    if (is(TK.TIMES) || is(TK.DIVIDE)) {
      scan();
      return true;
    }

    return false;
  }
    
  // is current token what we want?
  private boolean is(TK tk) {
    return tk == tok.kind;
  }

  // ensure current token is tk and skip over it.
  private void mustbe(TK tk) {
    if( tok.kind != tk ) {
      System.err.println( "mustbe: want " + tk + ", got " + tok);
      parse_error( "missing token (mustbe)" );
    }
  }

  private void parse_error(String msg) {
    System.err.println( "can't parse: line " + tok.lineNumber + " " + msg );
    System.exit(1);
  }
}
