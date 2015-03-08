#include <iostream>
#include "createDepList.h"

using namespace std;

int main()
{
    int a[] = {1 , 2 , 3 , 4 , 5 , 6 , 7};
    btree<int> tree(a , 7);
    createDepList<int> ob;
    slist<slist<bnode<int> *> > rs;
    ob.createLists_2(tree.getRoot() , 1 , rs);
    cout<<rs.getLength();

    return 0;
}
