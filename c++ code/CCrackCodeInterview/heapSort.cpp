#include "heapSort.h"
#include <iostream>

using namespace std;

void heapSort::HeapAdjust(int array[],int i,int nLength)
{
    int nChild;
    int nTemp;
    for(;2*i+1<nLength;i=nChild)
    {
        //子结点的位置=2*（父结点位置）+1
        nChild=2*i+1;
        //得到子结点中较大的结点
        if(nChild<nLength-1&&array[nChild+1]>array[nChild])++nChild;
        //如果较大的子结点大于父结点那么把较大的子结点往上移动，替换它的父结点
        if(array[i]<array[nChild])
        {
            nTemp=array[i];
            array[i]=array[nChild];
            array[nChild]=nTemp;
        }
        else break; //否则退出循环
    }
}
//堆排序算法
void heapSort::HeapSort(int array[],int length)
{
    int i;
    //调整序列的前半部分元素，调整完之后第一个元素是序列的最大的元素
    //length/2-1是最后一个非叶节点，此处"/"为整除
    for(i=length/2-1;i>=0;--i)
        HeapAdjust(array,i,length);
    //从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
    for(i=length-1;i>0;--i)
    {
        //把第一个元素和当前的最后一个元素交换，
        //保证当前的最后一个位置的元素都是在现在的这个序列之中最大的
        array[i]=array[0]^array[i];
        array[0]=array[0]^array[i];
        array[i]=array[0]^array[i];
        //不断缩小调整heap的范围，每一次调整完毕保证第一个元素是当前序列的最大值
        HeapAdjust(array,0,i);
    }
}

void heapSort::heapSortS(int *vals , int len)
{
    if(vals == NULL)
        return;

    for(int i = len / 2 + 1; i >= 0; i--)
        heapAdjust(vals , i , len);

    for(int i = len - 1; i > 0; i--)
    {
        vals[i] = vals[i] + vals[0];
        vals[0] = vals[i] - vals[0];
        vals[i] = vals[i] - vals[0];
        heapAdjust(vals , 0 , i - 1);
    }
}

void heapSort::heapAdjust(int* vals , int i , int len)
{
    if(vals == NULL)
        return;
    if(2 * i + 1 > len - 1)
        return;
    int child;
    for(;2 * i  + 1 < len; i = child)
    {
        child = 2 * i + 1;
        if(vals[child] < vals[child + 1])
            child++;
        if(vals[i] < vals[child])
        {
            vals[i] = vals[i] + vals[child];
            vals[child] = vals[i] - vals[child];
            vals[child] = vals[i] - vals[child];
        }
        else
            break;
    }
}
