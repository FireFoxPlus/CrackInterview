#include "reverse.h"
char *reverseString::reverseStr(char *str , int length)
{
    char *rs = new char[length + 1];
    rs[length] = '\0';
    int ends = length - 1 , start = 0;
    while(start < length)
    {
        rs[start] = str[ends];
        start++;
        ends--;
    }
    return rs;
}
