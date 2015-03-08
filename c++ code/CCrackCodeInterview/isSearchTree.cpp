#include "isSearchTree.h"
#include <limits>

bool isSearchTree::isSearch(bnode<int> *root , int mins , int maxs)
{
    if(root == NULL)
        return true;
    if(root->getValue() > maxs || root->getValue() < mins)
        return false;
    if(!isSearch(root->getLeft() , mins , root->getValue()) || !isSearch(root->getRight() , root->getValue() , maxs))
        return false;
    return true;
}
