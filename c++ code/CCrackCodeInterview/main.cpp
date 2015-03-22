#include <iostream>
#include <vector>
#include <cstring>
#include <time.h>
#include <stdio.h>

#include "swapWithoutTmp.h"

using namespace std;

int main()
{
    int a = 1 , b = 2;
    swapWithOutTmp ob;
    ob.swapNoTmp(&a , &b);
    cout<<a<<endl<<"b"<<endl;
    return 0;
}
