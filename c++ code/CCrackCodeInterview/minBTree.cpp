#include "minBTree.h"

bnode<int>* minBTree::getMinBTree(int* vals , int len)
{
    bnode<int> *rs = new bnode<int>();
    if(len == 0)
    {
        delete rs;
        return NULL;
    }
    if(len == 1)
    {
        rs->setValue(*vals);
        return rs;
    }
    int val = vals[(len -1) / 2];
    rs->setValue(val);
    rs->setLeft(getMinBTree(vals , (len - 1) / 2));
    rs->setRight(getMinBTree(vals + (len - 1) / 2 + 1 , len - (len - 1) / 2 - 1));
    return rs;
}
