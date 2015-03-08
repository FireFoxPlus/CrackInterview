#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H

class sumPath
{
public :
    void sumPaths(bnode<int> *root , int sum , int target , slist<int> &paths);
    void Bfs(bnode<int> *root , int sum);
};
