#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H

template<typename T>
class createDepList
{
public :
    slist<slist<bnode<T> *> > createLists(btree<T> tree);
    void createLists_2(bnode<T> *root , int dep , slist<slist<bnode<T> *> > &rs);

};

//广度优先
template<typename T>
slist<slist<bnode<T> *> > createDepList<T>::createLists(btree<T> tree)
{
    slist<slist<bnode<T> *> > rs;
    snode<slist<bnode<T> *> > *rsHead;
    snode<bnode<T> *> *curHead;
    bnode<T> *root = tree.getRoot();
    if(root == NULL)
        return rs;
    slist<bnode<T> *> current;
    current.tailInsert(root);
    rs.tailInsert(current);
    rsHead = rs.getHead();
    curHead = current.getHead();
    while(rsHead != NULL)
    {
        slist<bnode<T> *> tmp;
        while(curHead != NULL)
        {
            if(curHead->getValue()->getLeft() != NULL)
                tmp.tailInsert(curHead->getValue()->getLeft());
            if(curHead->getValue()->getRight() != NULL)
                tmp.tailInsert(curHead->getValue()->getRight());
            curHead = curHead->getNext();
        }
        if(tmp.getLength() != 0)
            rs.tailInsert(tmp);
        rsHead = rsHead->getNext();
        curHead = tmp.getHead();
    }
}

//dep初始传入1，即假设根的root为1
template<typename T>
void createDepList<T>::createLists_2(bnode<T> *root , int dep , slist<slist<bnode<T> *> > &rs)
{
    if(root == NULL)
        return;
    if(rs.getLength() >= dep)
    {
        snode<slist<bnode<T> *> > *head = rs.getHead();
        for(int i = 0; i < dep - 1; i++)
            head = head->getNext();
        head->getValue().tailInsert(root);
    }
    else
    {
        slist<bnode<T> *> tmp;
        tmp.tailInsert(root);
        rs.tailInsert(tmp);
    }
    if(root->getLeft() != NULL)
        createLists_2(root->getLeft() , dep + 1, rs);
    if(root->getRight() != NULL)
        createLists_2(root->getRight() , dep + 1, rs);
}
