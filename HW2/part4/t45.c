#include <stdio.h>
#define __EXPR(_EXPR) ( (_EXPR) <= 0 )

int main()
{
    {
      int x_a0;
      x_a0 = 23;
      if __EXPR( x_a0 )
      {
        printf("%d\n", x_a0);
      }
      else
      {
        int x_a1;
        x_a1 = 999;
        printf("%d\n", x_a1 + x_a1);
        if __EXPR( x_a1 )
        {
          printf("%d\n", 1111);
        }
        else
        {
          int x_a2;
          x_a2 = 8888;
          x_a0 = 44;
          printf("%d\n", x_a2);
          x_a0 = 11;
          x_a2 = x_a2 + 10000;
          x_a1 = x_a1 + 1;
          x_a0 = x_a0 + 100;
          printf("%d\n", x_a2);
          printf("%d\n", x_a0);
          printf("%d\n", x_a0);
          printf("%d\n", x_a2);
          printf("%d\n", x_a1);
        }
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