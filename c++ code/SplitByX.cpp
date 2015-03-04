#include "SplitByX.h"

void SplitByX::splitByX(slist<int> mlist , int bench)
{
    snode<int> *small = mlist.getHead();
    snode<int> *big = mlist.getHead();
    bool need_change = true;
    while(big != NULL && small != NULL)
    {
        while(big != NULL)
        {
            if(big->getValue() <= bench)
            {
                if(big == small)
                    need_change = false;
                big = big->getNext();
            }
            else
                break;
        }
        while(small != NULL)
        {
            if(small->getValue() >= bench)
            {
                if(big == small)
                    need_change = true;
                small = small->getNext();
            }
            else
                break;
        }
        if(need_change && small && big)
        {
            int change_value = small->getValue();
            small->setValue(big->getValue());
            big->setValue(change_value);
            //mlist.print();
        }
		if(small && big)
		{
			big = big->getNext();
			small = small->getNext();
		}
    }
}
