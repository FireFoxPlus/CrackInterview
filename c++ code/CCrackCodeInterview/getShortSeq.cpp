#include "getShortSeq.h"
#include <iostream>
using namespace std;
void getShortSeq::getSeq(int vals[] , int len)
{
    if(vals[0] > vals[len - 1])
    {
        cout<<"left :" <<0<<"right :"<<len - 1;
        return;
    }
    int leftIndex  = 0 , rightIndex = len - 1;
    for(int i = 1; i < len; i++)
    {
        if(vals[i] < vals[i - 1])
        {
            leftIndex = i - 1;
            break;
        }
        leftIndex++;
    }
    for(int i = len - 2; i >= 0; i--)
    {
        if(vals[i] > vals[i + 1])
        {
            rightIndex = i + 1;
            break;
        }
        rightIndex--;
    }
    if(leftIndex == len - 1 && rightIndex == 0)
    {
        cout<<"already Sorted!"<<endl;
        return;
    }
    int minMid = vals[leftIndex + 1], maxMid = vals[rightIndex - 1];
    for(int i = leftIndex; i <= rightIndex; i++)
    {
        if(vals[i] < minMid)
            minMid = vals[i];
        if(vals[i] > maxMid)
            maxMid = vals[i];
    }
    for(int i = leftIndex; i >=0; i--)
    {
        if(vals[i] < minMid)
        {
            leftIndex = i + 1;
            break;
        }
    }
    for(int i = rightIndex; i < len; i++)
    {
        if(vals[i] > maxMid)
        {
            rightIndex = i - 1;
            break;
        }

    }
    cout<<"left:"<<leftIndex<<endl<<"right:"<<rightIndex<<endl;
}
