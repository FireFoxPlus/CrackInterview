#include <iostream>
#include "sumPath.h"

using namespace std;

int main()
{
    int a[] = {1 , 2 , 3 , 1 , 5 , 6 , 7 , -1 , 9 , 10 , 11};
    btree<int> tree(a , 11);
    sumPath ob;
    slist<int> paths;
    ob.Bfs(tree.getRoot() , 3);
    return 0;
}
