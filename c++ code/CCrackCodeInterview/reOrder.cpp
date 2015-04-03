#include <stdio.h>
#include <cstring>
#include <algorithm>
#include <iostream>
using namespace std;
bool isBefore(int* input , int now , int next , int len)
{
    bool foundNext = false;
    int rs = false;
    for(int i = 0; i < len; i++)
    {
        if(input[i] == now)
        {
            if(foundNext)
                rs = true;
        }
        else if(input[i] == next)
        {
            foundNext = true;
        }
    }
    return rs;
}

void printInOrder(int *input , int len)
{
    int * copys = new int[len];
    memcpy(copys , input , sizeof(int) * len);
    sort(copys , copys + len);
    for(int i = 0; i < len; i++)
    {
        if(copys[i] == input[i])
            cout<<copys[i]<<endl;
        else
        {
            cout<<copys[i]<<" ";
            int tmp = copys[i];
            for(int j = i + 1; j < len; j++)
            {
                if(isBefore(input , tmp , copys[j] , len))
                {
                    cout<<copys[j]<<" ";
                    i++;
                }
                else
                {
                    cout<<endl;
                    break;
                }

            }

        }

    }
}

