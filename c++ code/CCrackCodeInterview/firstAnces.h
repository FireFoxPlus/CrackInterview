#include "utils.h"
template<typename T>
class firstAnces
{
public :
    bnode<T> *findAnce(bnode<T>* root , bnode<T>* chil1 , bnode<T>* chil2);
    bool hasNode(bnode<T> *root , bnode<T> * target);
};

 template<typename T>
 bnode<T> *firstAnces<T>::findAnce(bnode<T>* root , bnode<T>* chil1 , bnode<T>* chil2)
 {
    if(root == NULL)
        return NULL;
    if(hasNode(root , chil1) && hasNode(root , chil2))
    {
        if(hasNode(root->getLeft() , chil1) && hasNode(root->getLeft() , chil2))
            return findAnce(root->getLeft() , chil1 , chil2);
        else if(hasNode(root->getRight() , chil1) && hasNode(root->getRight() , chil2))
            return findAnce(root->getRight() , chil1 , chil2);
        else
            return root;
    }
 }

 template<typename T>
 bool firstAnces<T>::hasNode(bnode<T> *root , bnode<T> *target)
 {
    if(root == NULL)
        return false;
    if(root == target)
        return true;
    return hasNode(root->getLeft() , target) || hasNode(root->getRight() , target);
 }
