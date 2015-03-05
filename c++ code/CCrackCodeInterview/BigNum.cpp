#include "BigNum.h"

//2.5给定两个用链表表示的整数，每个节点包含一个数位，这些数位式反向存放的，即个位排在链表首部。编写函数对这两个整数求和
//并以链表的形式返回，假设数据是正向存放的，再做一次
slist<int> *BigNum_2::add_1(snode<int>* num1 , snode<int>* num2)
{
    slist<int>* rsList = new slist<int>();
    int tmp , carry = 0;
    while(num1 != NULL || num2 != NULL)
    {
        if(num1 == NULL)
        {
            tmp = num2->getValue() + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            rsList->tailInsert(tmp);
            num2 = num2->getNext();
        }
        else if(num2 == NULL)
        {
            tmp = num1->getValue() + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            rsList->tailInsert(tmp);
            num1 = num1->getNext();
        }
        else
        {
            tmp = num1->getValue() + num2->getValue() + carry;
            carry = tmp / 10;
            tmp = tmp % 10;
            rsList->tailInsert(tmp);
            num1 = num1->getNext();
            num2 = num2->getNext();
        }
    }
    return rsList;
}

slist<int>* BigNum_2::add_2(slist<int>* num1 , slist<int>* num2)
{
    snode<int>* head1;
    snode<int>* head2;
    bool recurse = false;
    int len = num1->getLength() > num2->getLength() ? num1->getLength() - num2->getLength() : num2->getLength() - num1->getLength();
    for(int i = 0; i < len; i++)
    {
        if(num1->getLength() < num2->getLength())
            num1->headInsert(0);
        else
            num2->headInsert(0);
    }
    head1 = num1->getHead();
    head2 = num2->getHead();
    while(head1 != NULL && head2 != NULL)
    {
        int tmp = head1->getValue() + head2->getValue();
        head1->setValue(tmp % 10);
        head2->setValue(tmp / 10);
        if(tmp / 10 != 0)
            recurse = true;
        head1 = head1->getNext();
        head2 = head2->getNext();
    }
    num2->tailInsert(0);//左移位
    if(recurse)
        add_2(num1 , num2);
    return num1;
}
