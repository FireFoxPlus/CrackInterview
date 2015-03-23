#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>
#include <algorithm>
#include "getShortSeq.h"
using namespace std;

int main()
{
    int vals[] = {1 , 2 , 4 , 7 , 10 , 11 , 7 , 12 , 6 , 7 , 16 , 18 , 19};
    getShortSeq ob;
    ob.getSeq(vals , 13);
    return 0;
}
