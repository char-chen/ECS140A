#include <stdio.h>
#define __EXPR(_EXPR) ( (_EXPR) <= 0 )

int main()
{
    {
      int x_a0;
      x_a0 = 999;
      printf("%d\n", x_a0 + x_a0);
      if __EXPR( x_a0 - 9 )
      {
        printf("%d\n", 1111);
      }
      else if __EXPR( x_a0 - 99 )
      {
        printf("%d\n", 2222);
      }
      else if __EXPR( x_a0 - 999 )
      {
        printf("%d\n", 3333);
      }
      else
      {
        printf("%d\n", 4444);
      }
      x_a0 = 99;
      if __EXPR( x_a0 - 9 )
      {
        printf("%d\n", 1111);
      }
      else if __EXPR( x_a0 - 99 )
      {
        printf("%d\n", 2222);
      }
      else if __EXPR( x_a0 - 999 )
      {
        printf("%d\n", 3333);
      }
      else
      {
        printf("%d\n", 4444);
      }
      x_a0 = 8888;
      if __EXPR( x_a0 - 9 )
      {
        printf("%d\n", 1111);
      }
      else if __EXPR( x_a0 - 99 )
      {
        printf("%d\n", 2222);
      }
      else if __EXPR( x_a0 - 999 )
      {
        printf("%d\n", 3333);
      }
      else
      {
        printf("%d\n", 4444);
      }
      x_a0 = 7777;
      if __EXPR( x_a0 - 9 )
      {
        printf("%d\n", 1111);
      }
      else if __EXPR( x_a0 - 99 )
      {
        printf("%d\n", 2222);
      }
      else if __EXPR( x_a0 - 999 )
      {
        printf("%d\n", 3333);
      }
      printf("%d\n", x_a0);
    }
    return 0;
}