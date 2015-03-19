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
    int** ptr = ob.alloc2D(3 , 4);
    cout<<endl;
    return 0;
}
