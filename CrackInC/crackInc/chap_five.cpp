#ifndef _CHAP_FIVE_H
#include "chap_five.h"
#endif // _CHAP_FIVE_H

int switchBits(int num)
{
    return ((num & 0xaaaa) >> 1) | ((num & 0x5555) << 1);
}

int changLeastBit(int num1 , int num2)
{
    int rs = num1 ^ num2;
    int counts = 0;
    while(rs != 0)
    {
        counts++;
        rs = rs & (rs - 1);
    }
    return counts;
}

int getBigger(int num)
{
    int mask = 0x0001 , allOnes = 0xffff;
    int rightOne;
    for(rightOne = 0; rightOne < 32; rightOne++)
    {
        int tmp = mask << rightOne;
        if((tmp &  num) != 0)
            break;
    }

    int countOnes = 0 , rightZero;
    for(rightZero = rightOne + 1; rightZero < 32; rightZero++)
    {
        int tmp = mask << rightZero;
        if((tmp & num) == 0)
            break;
        countOnes++;
    }
    //翻转置1
    num &= allOnes << (rightZero + 1);
    num |= mask << rightZero;
    num |= (mask << countOnes) - 1;
    return num;
}

void printViaBinary(double num)
{
    vector<int> rs;
    set<double> fraction;
    num *= 2;
    while(abs(num - 1) > 1e-9)
    {
        if(num > 1)
            rs.push_back(1);
        else if(abs(num - 1) < 1e-9)
            rs.push_back(1);
        else
            rs.push_back(0);
        fraction.insert(num);
        num *= 2;
        if(fraction.count(num) != 0)
        {
            cout<<"ERROR"<<endl;
            return;
        }
    }
    rs.push_back(1);
    for(int i = 0; i < rs.size(); i++)
        cout<<rs[i]<<" ";
}

int bitInsert(int num1 , int num2 , int start , int ends)
{
    int allOnes = 0xffff;
    int left = allOnes << start;
    int right = (0x0001 << ends) - 1;
    int mask = left | right;
    return num1 & mask | (num2 << ends);
}
