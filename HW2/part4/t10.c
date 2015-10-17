#include <stdio.h>
#define __EXPR(_EXPR) ( (_EXPR) <= 0 )

int main()
{
    {
      if __EXPR( 20 )
      {
        printf("%d\n", 2341);
      }
      else if __EXPR( 12 )
      {
        printf("%d\n", 9999);
      }
      else
      {
        printf("%d\n", 8888);
      }
    }
    return 0;
}