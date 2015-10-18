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
    System.out.println("#include <stdio.h>");
    System.out.print("#define __EXPR(_EXPR) ( (_EXPR) <= 0 )\n\n");
    System.out.print("int main()\n{");
    block();
    indent();
    System.out.print("return 0;\n}");
  }

  private void block(){
    indent();
    System.out.print("{");
    symbolTable.push(new ArrayList<Token>());
    declaration_list();
    statement_list();
    symbolTable.pop();
    indent();
    System.out.print("}");
  }

  private void declaration_list() {
    while(is(TK.DECLARE))
      declaration();
  }

  private void declaration() {
    mustbe(TK.DECLARE);
    indent();
    System.out.print("int"); 
    boolean isPrinted = false;
    
    do {
      scan();
      Token prev = tok;
      mustbe(TK.ID);
      scan();
         
      if (isDeclared(prev, 0, false) != -1)
        System.err.println("redeclaration of variable " + prev.string);
      else {
        symbolTable.peek().add(prev);
        if (isPrinted)
          System.out.print(",");
        else
          isPrinted = true;
      
        System.out.print(" x_" + prev.string + (symbolTable.size() - 1));
      } 
    } while(is(TK.COMMA));
    
    System.out.print(";");
  }
  
  private int isDeclared(Token t, int scope, boolean done)
  {
    if(scope == -1) 
      scope = symbolTable.size() - 1;
    
    for (int i = symbolTable.size() - scope - 1; i >= 0; i--) {
      for(Token var : symbolTable.elementAt(i))
        if(t.string.equals(var.string))
          return i;
      
      if(!done)
        break;
    }
    
    return -1;
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
    indent();
    System.out.print("printf(\"%d\\n\", ");
    expr();
    System.out.print(");");
  } 
  
  private void assignment() {
    indent();  
    ref_id();
    mustbe(TK.ASSIGN);
    scan();
    System.out.print(" = ");
    expr();
    System.out.print(";");
  }
  
  private void ref_id() {
    int scope = 0;
    boolean isDec = is(TK.TILDE);
     
    if (isDec)
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
    
    int found = isDeclared(prev, scope, !isDec);
      
    if (found == -1) {
      if (isDec)
        System.err.println("no such variable ~" + (scope == -1 ? "" : scope) + prev.string + " on line " + prev.lineNumber);
      else
        System.err.println(prev.string + " is an undeclared variable on line " + prev.lineNumber);
        
      System.exit(1);
    }
    else
      System.out.print("x_" + prev.string + found);
  }

  private void DO() {
    scan();
    indent();
    System.out.print("while");
    guarded_command();
    mustbe(TK.ENDDO);
    scan();
  }
  
  private void IF() {
    scan();
    indent();
    System.out.print("if");
    guarded_command();
    
    while (is(TK.ELSEIF)) {
      scan();
      indent();
      System.out.print("else if");
      guarded_command();
    }
    
    if (is(TK.ELSE)) {
      indent();
      System.out.print("else");
      scan();
      block();
    }

    mustbe(TK.ENDIF);
    scan();
  }
  
  private void guarded_command() {
    System.out.print(" __EXPR( ");
    expr();
    System.out.print(" )");
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
      System.out.print("(");
      expr();
      mustbe(TK.RPAREN);
      scan();
      System.out.print(")");
    }
    else if ((is(TK.TILDE)) || is(TK.ID))
      ref_id();
    else {
      Token prev = tok;
      mustbe(TK.NUM);
      scan();
      System.out.print(prev.string);
    }
  }
   
  private boolean addop() {
    if (is(TK.PLUS) || is(TK.MINUS)) {
      System.out.print(" " + tok.string + " ");
      scan();
      return true;
    }
    
    return false; 
  }

  private boolean multop() {
    if (is(TK.TIMES) || is(TK.DIVIDE)) {
      System.out.print(" " + tok.string + " ");
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

  private void indent() {
    System.out.println();
    for (int i = 0; i < symbolTable.size() + 2; i++)
      System.out.print("  ");
  }  
}