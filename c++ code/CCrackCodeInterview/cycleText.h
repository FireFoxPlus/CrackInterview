#include "utils.h"
template<typename T>
class cycleText
{
public :
    bool isCycle(slist<T> lists);
};

template<typename T>
bool cycleText<T>::isCycle(slist<T> lists)
{
    slist<T> help;
    snode<T> *itr = lists.getHead();
    if(itr == NULL)
        return true;
    while(itr != NULL)
    {
        help.headInsert(itr->getValue());
        itr = itr->getNext();
    }
    itr = lists.getHead();
    snode<T>* tmp = help.getHead();
    while(tmp != NULL)
    {
        if(tmp->getValue() != itr->getValue())
            return false;
        tmp = tmp->getNext();
        itr = itr->getNext();
    }
    return true;
}
