#include <iostream>
#include <vector>
#include <cstring>
#include <time.h>
#include <stdio.h>

#include "my2dAlloc.h"

using namespace std;

int main()
{
    my2DAlloc<int> ob;
    int** p = ob.alloc2D_2(3 , 4);
    int counts = 0;
    for(int i = 0; i < 3; i++)
        for(int j = 0; j < 4; j++)
        {
            p[i][j] = counts;
            counts++;
        }
       for(int i = 0; i < 3; i++)
        for(int j = 0; j < 4; j++)
        {
           cout<<p[i][j];
        }
    return 0;
}
