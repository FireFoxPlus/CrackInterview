#ifndef _CHAP_TWO
#include "chap_two.h"
#endif // _CHAP_TWO

bool isPlaling(slist<char> word)
{
    slist<char> help;
    snode<char> *head1 = word.getHead() , *head2;
    while(head1 != NULL)
    {
        help.headInsert(head1->getValue());
        head1 = head1->getNext();
    }
    head1 = word.getHead();
    head2 = help.getHead();
    while(head1 != NULL && head2 != NULL)
    {
        if(head1->getValue() != head2->getValue())
            return false;
        head1 = head1->getNext();
        head2 = head2->getNext();
    }
    return true;
}

snode<int> *getCirclHead(slist<int> lists)
{
    snode<int> *p1 = lists.getHead() ,
                *p2 = lists.getHead() ,
                *p3 = lists.getHead();
    bool start = true;
    while(p1 != p2 || start)
    {
        start = false;
        p1 = p1->getNext()->getNext();
        p2 = p2->getNext();
    }
    while(p1 != p3)
    {
        p1 = p1->getNext();
        p3 = p3->getNext();
    }
    return p1;
}

slist<int> addViaList_2(slist<int> add1 , slist<int> add2)
{
    snode<int> *head1 = add1.getHead() ,
                *head2 = add2.getHead();
    while(head1 != NULL && head1->getValue() == 0)
    {
        head1 = head1->getNext();
        add1.headDel();
    }
    while(head2 != NULL && head2->getValue() == 0)
    {
        head2 = head2->getNext();
        add2.headDel();
    }

    int len1 = add1.getLength() ,
        len2 = add2.getLength();
    slist<int> rs , carry;
    while(len1 < len2)
    {
        rs.tailInsert(head2->getValue());
        head2 = head2->getNext();
        len2--;
    }
    while(len2 < len1)
    {
        rs.tailInsert(head1->getValue());
        head1 = head1->getNext();
        len1--;
    }
    bool finish = true;
    while(head1 != NULL && head2 != NULL)
    {
        int tmp1 = head1->getValue() , tmp2 = head2->getValue();
        rs.tailInsert((tmp1 + tmp2) % 10);
        carry.tailInsert((tmp1 + tmp2) / 10);
        if(tmp1 + tmp2 >= 10)
            finish = false;
        head1 = head1->getNext();
        head2 = head2->getNext();
    }
    if(finish)
        return rs;
    else
    {
        carry.tailInsert(0);
        return addViaList_2(rs , carry);
    }
}

slist<int> addViaList(slist<int> add1 , slist<int> add2)
{
    slist<int> rs , carry;
    snode<int> *head1 = add1.getHead();
    snode<int> *head2 = add2.getHead();
    bool finish = true;
    while(head1 != NULL && head2 != NULL)
    {
        int tmp1 = head1->getValue() , tmp2 = head2->getValue();
        rs.tailInsert((tmp1 + tmp2) % 10);
        carry.tailInsert((tmp1 + tmp2) / 10);
        if(tmp1 + tmp2 >= 10)
            finish = false;
        head1 = head1->getNext();
        head2 = head2->getNext();
    }
    while(head1 != NULL)
    {
        rs.tailInsert(head1->getValue());
        head1 = head1->getNext();
    }
    while(head2 != NULL)
    {
        rs.tailInsert(head2->getValue());
        head2 = head2->getNext();
    }
    if(finish)
        return rs;
    else
    {
        carry.headInsert(0);
        return addViaList(rs , carry);
    }
}

void splitByx(slist<int> &vals , int x)
{
    snode<int> *small  = vals.getHead() , *big = vals.getHead();
    while(big != NULL && small != NULL)
    {
        while(small != NULL && small->getValue() < x)
            small = small->getNext();
        big = small->getNext();
        while(big != NULL && big->getValue() > x)
            big = big->getNext();
        if(big != NULL && small != NULL)
        {
            int tmp = big->getValue();
            big->setValue(small->getValue());
            small->setValue(tmp);
        }
    }
}

//如果节点是最后一个，需要特殊讨论
void delInOne(snode<int> *delNode)
{
    snode<int> *next = delNode->getNext();
    delNode->setValue(next->getValue());
    delNode->setNext(next->getNext());
    delete(next);
}

snode<int>* getLastKth(slist<int> vals , int k)
{
    snode<int>* fir = vals.getHead();
    snode<int> *sec = fir;
    for(int i  = 0; i < k && fir != NULL; i++)
        fir = fir->getNext();
    if(fir == NULL)
        return NULL;
    while(fir != NULL)
    {
        fir = fir->getNext();
        sec = sec->getNext();
    }
    return sec;
}

void removeDup(slist<int> &vals)
{
    snode<int> *head = vals.getHead();
    snode<int> *pre = head;
    set<int> record;
    while(head != NULL)
    {
        if(record.count(head->getValue()) == 0)
        {
            record.insert(head->getValue());
            pre = head;
            head = head->getNext();
        }
        else
        {
            pre->setNext(head->getNext());
            snode<int> *tmp = head;
            head = head->getNext();
            delete(tmp);
        }
    }
}
