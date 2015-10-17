#include <stdio.h>
#define __EXPR(_EXPR) ( (_EXPR) <= 0 )

int main()
{
    {
      int x_bbbb0;
      x_bbbb0 = 23;
      if __EXPR( x_bbbb0 )
      {
        printf("%d\n", x_bbbb0);
      }
      else
      {
        int x_k1;
        x_k1 = 999;
        printf("%d\n", x_k1 + x_k1);
        if __EXPR( x_k1 )
        {
          printf("%d\n", 1111);
        }
        else
        {
          int x_bbbb2;
          x_bbbb2 = 8888;
          x_bbbb0 = 44;
          printf("%d\n", x_bbbb2);
          x_bbbb0 = 11;
          x_bbbb2 = x_bbbb2 + 10000;
          while __EXPR( x_bbbb0 - 22 )
          {
            int x_bbbb3;
            x_bbbb3 = 77;
            printf("%d\n", x_bbbb0);
            printf("%d\n", x_bbbb3);
            x_bbbb0 = x_bbbb0 + 1;
            printf("%d\n", x_k1);
          }
          x_k1 = x_k1 + 1;
          x_bbbb0 = x_bbbb0 + 100;
          printf("%d\n", x_bbbb2);
          printf("%d\n", x_bbbb0);
          printf("%d\n", x_bbbb0);
          printf("%d\n", 