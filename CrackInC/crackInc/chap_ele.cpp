#include "chap_ele.h"

bool compare(string str1 , string str2)
{
    sort(str1.begin() , str1.end());
    sort(str2.begin() , str2.end());
    return str1 < str2;
}

void sortWord(vector<string> &words)
{
    sort(words.begin() , words.end() , compare);
}

void mergeSort(int val1[] , int val2[] , int len1 , int len2)
{
    int *help = (int *)malloc(sizeof(int) * (len1 + len2));
    int index = 0 , index1 = 0 , index2 = 0;
    while(index1 < len1 && index2 < len2)
    {
        if(val1[index1] < val2[index2])
            help[index++] = val1[index1++];
        else
            help[index++] = val2[index2++];
    }
    while(index1 < len1)
        help[index++] = val1[index1++];
    while(index2 < len2)
        help[index++] = val2[index2++];
    for(int i = 0; i < index; i++)
        val1[i] = help[i];
}
