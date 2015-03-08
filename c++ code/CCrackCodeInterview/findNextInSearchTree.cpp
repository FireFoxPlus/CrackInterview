#include "findNextInSearchTree.h"

bnode<int>* findNextInSearchTree::findFirstLeftFather(bnode<int> * node)
{
    //数据结构中添加father指针，此处不再实现
    return NULL;
}

bnode<int>* findNextInSearchTree::findLeftMost(bnode<int> *node)
{
    if(node == NULL)
        return NULL;
    if(node->getLeft() != NULL)
        return findLeftMost(node->getLeft());
    else
        return node;
}

bnode<int>* findNextInSearchTree::findNext(bnode<int>* node)
{
    if(node->getRight() != NULL)
        return findLeftMost(node->getRight());
    if(findFirstLeftFather(node) != NULL)
        return findFirstLeftFather(node);
    else
        return NULL;
}
