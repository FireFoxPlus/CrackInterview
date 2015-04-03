#include "numInMin.h"
#include <iostream>
using namespace std;
bool isBigger(int val1 , int val2)
{
    return val1 > val2;
}

bool isSmaller(int val1 , int val2)
{
    return val1 < val2;
}

void numInMid::rebuild(int *vals , int preI , int len , bool (*compare)(int val1 , int val2))
{
    if(vals == NULL)
        return;
    int child;
    for(; preI * 2 + 1 < len; preI = child)
    {
        child = preI * 2 + 1;
        if(child < len - 1 && vals[child] < vals[child + 1])
            child++;
        if(compare(vals[preI] , vals[child]))
        {
            vals[preI] = vals[preI] + vals[child];
            vals[child] = vals[preI] - vals[child];
            vals[preI] = vals[preI] - vals[child];
        }
        else
            break;
    }
}

void numInMid::heapAjust(int *vals , int len , bool (*compare)(int val1 , int val2))
{
    if(vals == NULL)
        return;
    for(int i = len / 2 + 1; i >= 0; i--)
        rebuild(vals , i , len , compare);
}

int numInMid::getMidNum(int* vals , int len)
{
    if(vals == NULL)
        return -1;
    int midRs = vals[0];
    int *maxHeap = new int[len];
    int maxIndex = 0;
    int *minHeap = new int[len];
    int minIndex = 0;
    //小于midRs以大根堆组织，大于midRs以小根堆组织
    for(int i = 0; i < len; i++)
    {
        if(vals[i] <= midRs)
        {
            minHeap[minIndex] = vals[i];
            minIndex++;
            heapAjust(minHeap , minIndex , isSmaller);
            for(int i = 0; i < minIndex; i++)
                cout<<minHeap[i];
            cout<<endl;
        }
        else
        {
            maxHeap[maxIndex] = vals[i];
            maxIndex++;
            heapAjust(maxHeap , maxIndex , isBigger);
            for(int i = 0; i < maxIndex; i++)
                cout<<maxHeap[i];
            cout<<endl;

        }
        if(maxIndex - minIndex == 2)
        {
            midRs = maxHeap[0];
            minHeap[minIndex] = midRs;
            minIndex++;
            heapAjust(minHeap , minIndex , isSmaller);
             for(int i = 0; i < minIndex; i++)
                cout<<minHeap[i];
            cout<<endl;


            maxHeap[0] = maxHeap[0] + maxHeap[maxIndex - 1];
            maxHeap[maxIndex - 1] = maxHeap[0] - maxHeap[maxIndex - 1];
            maxHeap[0] = maxHeap[0] - maxHeap[maxIndex - 1];
            maxIndex--;
            heapAjust(maxHeap , maxIndex , isBigger);
              for(int i = 0; i < maxIndex; i++)
                cout<<maxHeap[i];
            cout<<endl;
        }
        else if(minIndex - maxIndex == 2)
        {
            midRs = minHeap[0];
            maxHeap[maxIndex] = midRs;
            maxIndex++;
            heapAjust(maxHeap , maxIndex , isBigger);



            minHeap[0] = minHeap[0] + minHeap[minIndex - 1];
            minHeap[minIndex - 1] = minHeap[0] - minHeap[minIndex - 1];
            minHeap[0] = minHeap[0] - minHeap[minIndex - 1];
            minIndex--;
            heapAjust(minHeap , minIndex , isSmaller);
             for(int i = 0; i < minIndex; i++)
                cout<<minHeap[i];
            cout<<endl;
        }
    }
    return midRs;
}
