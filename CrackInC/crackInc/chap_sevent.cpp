#include "chap_sevent.h"



int getSign(int val1 , int val2)
{
    if((val1 -  val2) >> 31)
        return 0;
    else
        return 1;
}

int getBigger(int val1 , int val2)
{
    int sign = getSign(val1 , val2);
    return val1 * sign + val2 * (sign ^ 0x0001);
}

int countFive(int n)
{
    int rs = 0;
    while(n % 5 == 0)
    {
        rs++;
        n /= 5;
    }
    return rs;
}

int tailZero(int n)
{
    int rs = 0;
    for(int i = 1; i <= n; i++)
        rs += countFive(i);
    return rs;
}
