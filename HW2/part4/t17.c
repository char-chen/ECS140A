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
          