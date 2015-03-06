#include "sumPath.h"

 bool sumPath::sumPaths(bnode<int>* root , int sum)
 {
    if(root ==  NULL)
        return false;
    if(root->getValue() == sum)
    {
        cout<<root->getValue()<<' ';
        return true;
    }
    if(root->getValue() > sum)
        return false;
    if(root->getValue() < sum)
    {
        if(sumPaths(root->getLeft() , sum - root->getValue()) || sumPaths(root->getRight() , sum - root->getValue()))
        {
            cout<<root->getValue()<<' ';
            return true;
        }
    }
 }

void sumPath::Bfs(bnode<int> *root , int sum)
{
    mqueue<bnode<int> *> que;
    if(root == NULL)
        return;
    que.addQueue(root);
    while(que.getLength() != 0)
    {
        bnode<int> *tmp = que.deQueue();
        if(sumPaths(tmp , sum))
            cout<<endl;
        if(tmp->getLeft() != NULL)
            que.addQueue(tmp->getLeft());
        if(tmp->getRight() != NULL)
            que.addQueue(tmp->getRight());
    }
}

