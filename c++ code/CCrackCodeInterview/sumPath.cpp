#include "sumPath.h"

void sumPath::sumPaths(bnode<int>* root , int sum , int target , slist<int> &paths)
 {
    if(root ==  NULL)
        return;
    paths.tailInsert(root->getValue());
    if(sum + root->getValue() == target)
    {
        paths.print();
        cout<<endl;
    }

    //paths.tailInsert(root->getValue());
    sumPaths(root->getLeft() , sum + root->getValue() , target , paths);
    sumPaths(root->getRight() , sum + root->getValue() , target , paths);

    paths.tailDel();
    return;
 }

void sumPath::Bfs(bnode<int> *root , int sum)
{
    slist<int> path;
    mqueue<bnode<int> *> que;
    if(root == NULL)
        return;
    que.addQueue(root);
    while(que.getLength() != 0)
    {
        bnode<int> *tmp = que.deQueue();
        sumPaths(tmp , 0 , sum , path);
//        if(sumPaths(tmp , 0 , sum , path))
//            cout<<endl;
        if(tmp->getLeft() != NULL)
            que.addQueue(tmp->getLeft());
        if(tmp->getRight() != NULL)
            que.addQueue(tmp->getRight());
    }
}

