#include <stdio.h>

int main()
    {
      int x_a0;
      x_a0 = 1;
      printf("%d\n", x_a0);
      if(0 - 1 <= 0)
      {
        int x_a1;
        x_a1 = 2;
        printf("%d\n", x_a1);
        if(0 - 1 <= 0)
        {
          int x_a2;
          x_a2 = 3;
          printf("%d\n", x_a2);
          if(0 - 1 <= 0)
          {
            int x_a3;
            x_a3 = 4;
            printf("%d\n", x_a3);
          }
          printf("%d\n", x_a2);
        }
        printf("%d\n", x_a1);
      }
      printf("%d\n", x_a0);
    }