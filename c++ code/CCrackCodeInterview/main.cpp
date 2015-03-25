#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>
#include <algorithm>
#include "getShortSeq.h"
using namespace std;

int main( void )
{
    int vals[] = {1,2 ,4 , 5 ,3};
    getShortSeq ob;
    ob.getSeq(vals , 5);
    return 0;
}
