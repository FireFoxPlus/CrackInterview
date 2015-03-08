#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H
template<typename T>
class isSubTree
{
public :
    //root2是否是root1的子树
    bool isSub(bnode<T> *root1 , bnode<T> *root2);
    bool isSubs(bnode<T> *root1 , bnode<T> *root2);
};

template<typename T>
bool isSubTree<T>::isSub(bnode<T> *root1 , bnode<T> *root2)
{
    if(root1 == NULL && root2 == NULL)
        return true;
    if(root1 == NULL && root2 != NULL)
        return false;
    if(root1 != NULL && root2 == NULL)
        return false;
    if(root1->getValue() != root2->getValue())
        return false;
    return isSub(root1->getLeft() , root2->getLeft()) && isSub(root1->getRight() , root2->getRight());
}

template<typename T>
bool isSubTree<T>::isSubs(bnode<T> *root1 , bnode<T> *root2)
{
    mqueue<bnode<T> *> que;
    que.addQueue(root1);
    while(que.getLength() != 0)
    {
        bnode<T> *tmp = que.deQueue();
        if(isSub(tmp , root2))
            return true;
        if(tmp->getLeft() != NULL)
            que.addQueue(tmp->getLeft());
        if(tmp->getRight() != NULL)
            que.addQueue(tmp->getRight());
    }
    return false;
}
