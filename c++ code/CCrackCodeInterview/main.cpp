#include <iostream>
#include "sumPath.h"

using namespace std;

int main()
{
    int a[] = {1 ,2 ,3 , 1 , 2 ,6};
    btree<int> tree(a , 6);
    sumPath ob;
    ob.Bfs(tree.getRoot() , 4);
    return 0;
}
