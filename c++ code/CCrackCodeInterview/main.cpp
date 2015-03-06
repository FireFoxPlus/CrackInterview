#include <iostream>
#include "minBTree.h"

using namespace std;

int main()
{
    int vals[] = {1 , 2 , 3 , 4 , 5};
    minBTree ob;
    bnode<int> *root = ob.getMinBTree(vals , 5);
    cout<<root->getValue();
    return 0;
}
