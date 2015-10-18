#include <stdio.h>

int main()
    {
      int x_a0, x_b0, x_another0, x_i0, x_k0, x_s0;
      x_a0 = 44;
      x_b0 = 0 - x_a0;
      x_a0 = 888 - 999;
      x_another0 = x_a0 - 999;
      printf("%d\n", x_a0);
      printf("%d\n", x_b0);
      printf("%d\n", x_another0);
      printf("%d\n", 3 + 2 * 4);
      printf("%d\n", (8 - 7 - 6));
      printf("%d\n", (8 - (7 - 6)));
      printf("%d\n", ((8 - 7) - 6));
      x_i0 = 1;
      while(x_i0 - 10 <= 0)
      {
        printf("%d\n", x_i0);
        x_i0 = x_i0 + 1;
      }
      x_s0 = 0;
      x_k0 = 10;
      while(0 - x_k0 <= 0)
      {
        printf("%d\n", x_k0);
        x_s0 = x_s0 + x_k0;
        x_k0 = x_k0 - 1;
      }
      printf("%d\n", x_k0);
      printf("%d\n", x_s0);
    }