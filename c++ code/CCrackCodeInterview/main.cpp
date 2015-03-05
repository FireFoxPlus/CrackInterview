#include <iostream>
#include "cycleText.h"

using namespace std;

int main()
{
    slist<int> num1;
    slist<int> num2;
    slist<int> *rs;
    cycleText<int> ob;
    num1.tailInsert(4);
    num1.tailInsert(0);
    num1.tailInsert(0);
    num1.tailInsert(4);
    if(ob.isCycle(num1))
        cout<<"true"<<endl;
    else
        cout<<"false"<<endl;
    return 0;
}
