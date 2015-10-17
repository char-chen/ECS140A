#include <stdio.h>
#define __EXPR(_EXPR) ( (_EXPR) <= 0 )

int main()
{
    {
      int x_a0;
      x_a0 = 999;
      printf("%d\n", x_a0 + x_a0);
      if __EXPR( x_a0 )
      {
        printf("%d\n", 1111);
      }
      else
      {
        int x_a1;
        x_a1 = 8888;
        printf("%d\n", x_a1);
        x_a0 = 11;
        x_a1 = x_a1 + 10000;
        x_a0 = x_a0 + 1;
        printf("%d\n", x_a1);
        printf("%d\n", x_a0);
        printf("%d\n", x_a1);
        printf("%d\n", x_a0);
      }
      printf("%d\n", x_a0);
      printf("%d\n", x_a0);
      printf("%d\n", x_a0);
    }
    return 0;
}