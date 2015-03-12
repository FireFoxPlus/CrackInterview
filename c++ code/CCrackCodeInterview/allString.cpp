#include <iostream>
#include <cstring>
#include "allString.h"

using namespace std;
void allString::swaps(char *poi1 , char * poi2)
{
    char tmp = *poi1;
    *poi1 = *poi2;
    *poi2 = tmp;
}

void allString::getAllString(char *str , int start)
{
    if(*(str + start) == '\0')
    {
        cout<<str<<endl;
        return;
    }
    for(int i = 0; i < strlen(str + start); i++)
    {
        swaps(str + start , str + i + start);
        getAllString(str , start + 1);
        swaps(str + start , str + i + start);
    }
}
