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
      }
      printf("%d\n", x_a0);
      if __EXPR( x_a0 )
      {
        printf("%d\n", 1111);
      }
      else
      {
        printf("%d\n", 2222);
        printf("%d\n", x_a0);
        if __EXPR( 0 - 2 )
        {
          int x_a2;
          x_a2 = 3;
          printf("%d\n", x_a2);
        }
        printf("%d\n", x_a0);
      }
      printf("%d\n", x_a0);
      if __EXPR( x_a0 )
      {
        printf("%d\n", 1111);
      }
      else
      {
        int x_a1;
        x_a1 = 4;
        printf("%d\n", 5);
        printf("%d\n", x_a1);
        if __EXPR( 0 )
        {
          int x_a2;
          x_a2 = 6;
          printf("%d\n", x_a2);
        }
        printf("%d\n", x_a1);
      }
      printf("%d\n", x_a0);
    }
    return 0;
}