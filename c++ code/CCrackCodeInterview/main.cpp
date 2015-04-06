#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>
#include "numInMin.h"

using namespace std;

int main(void)
{
    int val[] = {1 , 2 , 3 , 4 , 5 , 6 , 7 ,8 ,9 ,10};
    numInMid ob;
    int mid = ob.getMidNum(val , 10);
    cout<<mid;


}


//
//class FreeList
//{
//private :
//    int freeBlock;//一共有多少内存块
//    char **blocks;//内存块指针
//    int *inUse;
//    HANDLE countMutex;
//public :
//    FreeList(int nBlocks , int sizes);//构造函数
//    char *NeedBlock();//分配内存块
//    void release(char *addr);//释放内存块
//    int findFirst();//找到第一块可用
//    ~FreeList()
//    {
//        delete [] inUse;
//        for(int i = 0; i < freeBlock; i++)
//            delete [] blocks[i];
//    }
//
//};
//
//int FreeList::findFirst()
//{
//    int rs = -1;
//    for(int i = 0; i < freeBlock; i++)
//        if(inUse == 0)
//            rs = i;
//    return rs;
//}
//void FreeList::release(char *addr)
//{
//    for(int i = 0; i < freeBlock; i++)
//        if(blocks[i] == addr)
//        {
//            WaitForSingleObject(countMutex , INFINITE);
//            inUse[i] == 0;
//            freeBlock++;
//            ReleaseMutex(countMutex);
//        }
//}
//
//char* FreeList::NeedBlock()
//{
//    char *rs = NULL;
//    WaitForSingleObject(countMutex , INFINITE);
//    if(freeBlock > 0)
//    {
//        int tmp = findFirst();
//        if(tmp == -1)
//            return NULL;
//        else
//        {
//            rs = blocks[tmp];
//            inUse[tmp] = 1;
//            freeBlock--;
//        }
//    }
//    ReleaseMutex(countMutex);
//    return rs;
//}
//
//FreeList::FreeList(int n , int sizes)
//{
//    freeBlock = n;
//    BlockMutex = (HANDLE *)malloc(sizeof(HANDLE) * n);
//    countMutex = CreateMutex(NULL , false , L"MUTEX_ONLY_ONE_ALLOWED");
//    if(countMutex == NULL)
//        return;
//    inUse = (int *)malloc(sizeof(int) * n);
//    memset(inUse , 0 , sizeof(int) * n);
//    //成功后再分配
//    blocks = (char**)malloc(sizeof(char *) * n);
//    for(int i = 0; i < n; i++)
//    {
//        blocks[i] = (char*)malloc(sizeof(char) * sizes);
//        if(blocks[i] == NULL)
//            return;
//    }
//}

