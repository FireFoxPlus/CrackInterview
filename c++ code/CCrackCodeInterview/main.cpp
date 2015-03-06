#include <iostream>
#include "isSearchTree.h"

using namespace std;

int main()
{
    int a[] = {4 , 2 , 6 , 1 , 3 , 8 , 7};
    btree<int> ob(a , 7);
    isSearchTree oo;
    if(oo.isSearch(ob.getRoot()))
        cout<<"true";
    else
        cout<<"false";
}
