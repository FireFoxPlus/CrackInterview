#include <iostream>
#include <vector>
#include "allString.h"
#include <cstring>
#include <time.h>
#include <stdio.h>
using namespace std;

int main()
{
    time_t rawtime;
    char a = getchar();
    while((a = getchar()) != '#')
    {
        time(&rawtime);
        cout<<rawtime<<endl;
    }

    return 0;
}
