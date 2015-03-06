#include <iostream>
#include "isSubTree.h"

using namespace std;

int main()
{
    int a[] = {1 ,2 ,3 ,4 ,5 ,6};
    int b[] = {2 , 4 , 5};
    btree<int> tree1(a , 6);
    btree<int> tree2(b , 3);
    isSubTree<int> oo;
    if(oo.isSubs(tree1.getRoot() , tree2.getRoot()))
        cout<<"true";
    else
        cout<<"false";
    return 0;
}
