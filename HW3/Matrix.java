public class Matrix extends Sequence {
  
  public MyInteger[][] matrix;
  public int row;
  public int column;
  
  public Matrix(int rowsize, int colsize) {
    matrix = new MyInteger[rowsize][colsize];
    row = rowsize;
    column = colsize;
  }
 
  //Set the value of an element 
  public void Set(int rowsize, int colsize, int value) {
    matrix[rowsize][colsize].Set(value);
  }
  
  //Get the value of an element
  public int Get(int rowsize, int colsize) {
    return matrix[rowsize][colsize].Get(value);
  }
  
  // return the sum of two matrices: mat & this
  public Matrix Sum(Matrix mat) {
    for (int i = 0; i < row; i++)
      for (int j = 0; j < column; j++)
        matrix.Set(i, j, matrix.Get(i, j) + mat.Get(i, j));
  }
  
  // return the product of two matrices: mat & this
  public Matrix Product(Matrix mat) {
    
  }
  
  @Override 
  // print the elements of matrix
  public void Print() {
    for (int i = 0; i < row; i++, System.out.println())
      for (int j = 0; j < column; j++)
        System.out.println(matrix.Get(i, j) + " ");
  }
}
