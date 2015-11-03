public class Matrix extends Sequence {
  
  public Sequence matrix;
  public int r; //row size
  public int c; //column size
    
  public Matrix(int rowsize, int colsize) {
    r = rowsize;
    c = colsize;
    Sequence rtr, ctr; 
    int i, j;
    
    for (i = 0, rtr = matrix = new Sequence(); i < r; i++, rtr = rtr.next = new Sequence()) {
      rtr.element = new Sequence(new MyInteger());
      
      for (j = 1, ctr = (Sequence)rtr.element; j < c; j++, ctr = ctr.next)
        ctr.add(new MyInteger(), j);
    }
  }
  
  //Set the value of an element 
  public void Set(int rowsize, int colsize, int value) {
    ((MyInteger)(((Sequence)(matrix.index(rowsize))).index(colsize))).Set(value);
  }
  
  //Get the value of an element
  public int Get(int rowsize, int colsize) {
    return ((MyInteger)(((Sequence)(matrix.index(rowsize))).index(colsize))).Get();
  }
  
  // return the sum of two matrices: mat & this
  public Matrix Sum(Matrix mat) {
    Matrix sum = new Matrix(r, c);
	
    for (int i = 0; i < r; i++)
      for (int j = 0; j < c; j++)
        sum.Set(i, j, this.Get(i, j) + mat.Get(i, j));
    
    return sum;
  }
  
  // return the product of two matrices: mat & this
  public Matrix Product(Matrix mat) {
    int summy = 0;
    
    if (c == mat.r) {
      Matrix product = new Matrix(r, mat.c);
    
      for (int i = 0; i < r; i++) {
        for (int j =0; j < mat.c; j++) {
	        for(int q = 0; q < mat.r; q++)
            summy = summy + this.Get(i, q) * mat.Get(q, j);
        
          product.Set(i,j, summy);
          summy = 0;
        }
      }
      return product;
    }
    
    System.out.println("Matrix dimensions incompatible for Product");
    System.exit(1); 
    return null;     
  }
  
  @Override 
  // print the elements of matrix
  public void Print() {
    for (Sequence rtr = matrix; rtr.element != null; rtr = rtr.next, System.out.println())
      ((Sequence)(rtr.element)).Print();
  }
}
