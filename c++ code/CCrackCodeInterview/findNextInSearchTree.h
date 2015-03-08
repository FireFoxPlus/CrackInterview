#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H

class findNextInSearchTree
{
public :
    bnode<int> *findNext(bnode<int> *node);
    bnode<int> *findLeftMost(bnode<int> *node);
    bnode<int> *findFirstLeftFather(bnode<int> * node);
};
