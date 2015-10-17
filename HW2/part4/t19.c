#include <stdio.h>
#define __EXPR(_EXPR) ( (_EXPR) <= 0 )

int main()
{
    {
      int x_i0, x_k0;
      x_i0 = 25;
      while __EXPR( 10 - x_i0 )
      {
        if __EXPR( 20 - x_i0 )
        {
          x_k0 = 20 - x_i0;
          while __EXPR( x_k0 )
          {
            printf("%d\n", x_k0);
            x_k0 = x_k0 + 1;
          }
        }
        else if __EXPR( 15 - x_i0 )
        {
          x_k0 = 15 - x_i0;
          while __EXPR( x_k0 )
          {
            int x_long3;
            x_long3 = 10 * x_k0;
            printf("%d\n", x_long3);
            x_k0 = x_k0 + 1;
          }
        }
        else
        {
          x_k0 = 10 - x_i0;
          while __EXPR( x_k0 )
          {
            printf("%d\n", x_k0);
            x_k0 = x_k0 + 1;
          }
        }
        x_i0 = x_i0 - 1;
      }
      printf("%d\n", x_i0);
    }
    return 0;
}