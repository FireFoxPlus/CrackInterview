#include "utils.h"
template<typename T>
class cycleHead
{
public :
    snode<T>* getCycleHead(slist<T> lists);
};

template<typename T>
snode<T>* cycleHead<T>::getCycleHead(slist<T> lists)
{
    snode<T>* fast = lists.getHead();
    snode<T>* slow = lists.getHead();
    snode<T>* rs = lists.getHead();
    if(lists.getLength() == 0)
        return NULL;
    while(fast != NULL && slow != NULL)
    {
        fast = fast->getNext()->getNext();
        slow = slow->getNext();
        if(fast == slow)
            break;
    }
    while(fast != rs)
    {
        fast = fast->getNext();
        rs = rs->getNext();
    }
    return rs;
}
