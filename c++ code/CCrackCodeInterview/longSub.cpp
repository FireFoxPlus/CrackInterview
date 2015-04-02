#include <iostream>
#include "longSub.h"
#include <cstring>
using namespace std;
void longSub::longSubStr(char* src)
{
    if(src == NULL)
        return;
    int len = strlen(src);
    char **suffix = new char*[len];
    //后缀数组
    for(int i = 0; i < len; i++)
        suffix[i] = src + i;

    for(int i = 0; i < len; i++)
        cout<<suffix[i]<<endl;


    char* starts = NULL;
    int maxs = 0;
    for(int i = 1; i < (len + 1) / 2; i++)
        for(int j = 0; j < len - 1; j++)
        {
            int tmp = 0;
            for(int k = j; k < len - i; k = k + i)
            {
//                if(strlen(suffix[k]) < i ||
//                    strlen(suffix[k + i]) < i)
//                    break;
                if(strncmp(suffix[k] , suffix[k + i] , i))
                {
                    break;
                }
                else
                {
                    tmp++;
                }
            }
            if(tmp > maxs)
            {
                maxs = tmp;
                starts = suffix[j];
            }
        }
    for(int i = 0; i < maxs; i++)
        cout<<starts[i];
}
