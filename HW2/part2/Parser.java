/* *** This file is given as part of the programming assignment. *** */

public class Parser {


    // tok is global to all these parsing methods;
    // scan just calls the scanner's scan method and saves the result in tok.
    private Token tok; // the current token
    private void scan() {
      tok = scanner.scan();
    }

    private Scan scanner;
    Parser(Scan scanner) {
	    this.scanner = scanner;
	    scan();
	    program();
	    if( tok.kind != TK.EOF )
	      parse_error("junk after logical end of program");
    }

    private void program() {
	    block();
    }

    private void block(){
	    declaration_list();
	    statement_list();
    }

    private void declaration_list() {
	  // below checks whether tok is in first set of declaration.
	  // here, that's easy since there's only one token kind in the set.
	  // in other places, though, there might be more.
	  // so, you might want to write a general function to handle that.
	    while( is(TK.DECLARE) ) {
	      declaration();
	    }
    }

    private void declaration() {
	    mustbe(TK.DECLARE);
	    mustbe(TK.ID);
	    while( is(TK.COMMA) ) {
	      scan();
	      mustbe(TK.ID);
	    }
    }

    private void statement_list() {
      while (statement());
    }
    
    private boolean statement() {
      if (is(TK.ID) || is(TK.TILDE))
        assignment();
      else if(is(TK.PRINT)) // !
        print();
      else if(is(TK.DO)) // <
        DO();
      else if(is(TK.IF)) // [
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
      expr();
    }
    
    private void ref_id() {
      if (is(TK.TILDE))
      {
        scan();
      
        if (is(TK.NUM))
          scan();
      }

      mustbe(TK.ID);
    }

    private void DO() {
      scan();
      guarded_command();
    }
    
    private void IF() {
      scan();
      guarded_command();
    }
    
    private void guarded_command() {
      expr();
      mustbe(TK.THEN);
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
        expr();
        mustbe(TK.RPAREN);
      }
      else if (is(TK.ID))
        ref_id();
      else
        mustbe(TK.NUM);    
    }
     
    private boolean addop() {
      if (is(TK.PLUS) || is(TK.MINUS))
        return true;
      
      return false; 
    }

    private boolean multop() {
      if (is(TK.TIMES) || is(TK.DIVIDE))
        return true;
  
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
      
	    scan();
    }

    private void parse_error(String msg) {
	    System.err.println( "can't parse: line " + tok.lineNumber + " " + msg );
	    System.exit(1);
    }
}
