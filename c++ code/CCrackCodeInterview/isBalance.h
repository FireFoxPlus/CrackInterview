#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H

template<typename T>
class isBalanceTree
{
public :
    bool isBalance(bnode<T>* treeNode , int *dep);
};

template<typename T>
bool isBalanceTree<T>::isBalance(bnode<T>* treeNode , int *dep)
{
    if(treeNode == NULL)
    {
        *dep = 0;
        return true;
    }
    int left , right;
    if(isBalance(treeNode->getLeft() , &left) && isBalance(treeNode->getRight() , &right))
    {
        if(left - right >= -1 && left - right <= 1)
        {
            *dep = left > right ? (left + 1) : (right + 1);
            return true;
        }
    }
    return false;
}
