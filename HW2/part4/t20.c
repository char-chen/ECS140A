#include <stdio.h>

int main()
    {
      int x_i0, x_k0;
      int x_s0, x_t0;
      int x_x0;
      x_i0 = 25;
      x_s0 = 11;
      printf("%d\n", x_s0);
      while(10 - x_i0 <= 0)
      {
        if(20 - x_i0 <= 0)
        {
          x_k0 = 20 - x_i0;
          while(x_k0 <= 0)
          {
            printf("%d\n", x_k0);
            x_k0 = x_k0 + 1;
          }
        }
        else if(15 - x_i0 <= 0)
        {
          x_k0 = 15 - x_i0;
          while(x_k0 <= 0)
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
          while(x_k0 <= 0)
          {
            printf("%d\n", x_k0);
            x_k0 = x_k0 + 1;
          }
        }
        x_i0 = x_i0 - 1;
      }
      printf("%d\n", x_i0);
    }