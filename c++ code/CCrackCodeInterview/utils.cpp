#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H

#include <time.h>
#include <stdlib.h>

int nDigits(int val)
{
    int rs = 0;
    while(val > 0)
    {
        rs++;
        val /= 10;
    }
    return rs;
}

int arrayToInt(char *rs)
{
    int int_rs = 0;
    while(*rs != '\0')
    {
        int_rs = int_rs * 10 + *rs - '0';
        rs++;
    }
    return int_rs;
}

//val1大于val2返回true
bool small(int val1 , int val2)
{
    return val1 > val2 ? true : false;
}


void mswap(int *val1 , int * val2)
{
    int tmp = *val1;
    *val1 = *val2;
    *val2 = tmp;
}

int getRandom(int range)
{
    srand((int)time(NULL));
    int rs = rand();
    return rs % range;
}

int mmin(int val1 , int val2)
{
    return val1 < val2 ? val1 : val2;
}

void midTour(TreeNode* root , TreeNode** tailList)
{
    if(root->getLeft() != NULL)
        midTour(root->getLeft() , tailList);
    root->setLeft(*tailList);
    if(*tailList != NULL)
        (*tailList)->setRight(root);
    *tailList = root;

    if(root->getRight() != NULL)
        midTour(root->getRight() , tailList);
    return;
}

void buildList(TreeNode* root)
{
    if(root == NULL)
        return;
    TreeNode* tail = NULL;
    if(root->getLeft() != NULL)
        midTour(root->getLeft() , &tail);
    root->setLeft(tail);
    tail->setRight(root);
    tail = root;
    if(root->getRight() != NULL)
        midTour(root->getRight() , &tail);
}
