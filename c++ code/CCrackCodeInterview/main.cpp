#include <iostream>
#include "BigNum.h"

using namespace std;

int main()
{
    slist<int> num1;
    slist<int> num2;
    slist<int> *rs;
    BigNum_2 ob;
    num1.tailInsert(4);
    num1.tailInsert(0);
    num1.tailInsert(0);
    num1.tailInsert(0);
    num2.tailInsert(2);
    num2.tailInsert(1);
    num2.tailInsert(5);
    rs = ob.add_2(&num1 , &num2);
    rs->print();

    return 0;
}
