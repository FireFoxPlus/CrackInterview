#include <iostream>
#include "isSearchTree.h"

using namespace std;

int main()
{

    int a[] = {5 , 3 , 7 , 2 , 3 , 6 , 4};
    btree<int> tree(a , 7);
    isSearchTree ob;
    if(ob.isSearch(tree.getRoot() , INT_MIN , INT_MAX))
        cout<<"true";
    else
        cout<<"false";


    return 0;
}
