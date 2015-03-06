#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H

class sumPath
{
public :
    bool sumPaths(bnode<int> *root , int sum);
    void Bfs(bnode<int> *root , int sum);
};
