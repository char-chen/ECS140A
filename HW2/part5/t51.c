#include <stdio.h>

int main()
{
  int x_i0;
  for (x_i0 = 20; x_i0 <= 0; x_i0 = x_i0 - 1)
  {
    if(x_i0 - 10 <= 0)
    {
      printf("%d\n", x_i0);
    }
  }
}