#include "isSearchTree.h"

bool isSearchTree::isSearch(bnode<int> *root)
{
    if(root == NULL)
        return true;
    if(isSearch(root->getLeft()) && isSearch(root->getRight()))
    {
        if(root->getRight() == NULL && root->getLeft() != NULL)
            return root->getLeft()->getValue() < root->getValue();
        if(root->getLeft() == NULL && root->getRight() != NULL)
            return root->getRight()->getValue() > root->getValue();
        if(root->getLeft() == NULL && root->getRight() == NULL)
            return true;
        if(root->getLeft() != NULL && root->getRight() != NULL)
            return root->getLeft()->getValue() < root->getValue() && root->getRight()->getValue() > root->getValue();
    }
}
