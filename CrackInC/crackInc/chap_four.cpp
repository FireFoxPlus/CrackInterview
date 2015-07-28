#ifndef CHAP_FOUR
#include "chap_four.h"
#endif // CHAP_FOUR

void printPath(vector<bnode<int> *> rs , bnode<int> *root , int target , int nowSum)
{
    rs.push_back(root);
    if(nowSum + root->getValue() == target)
    {
        for(int i = 0; i < rs.size(); i++)
            cout<<rs[i]->getValue()<<" ";
        cout<<endl;
    }
    if(root->getLeft() != NULL)
        printPath(rs , root->getLeft() , target , nowSum + root->getValue());
    if(root->getRight() != NULL)
        printPath(rs , root->getRight() , target , nowSum + root->getValue());
}

void getPathSumToN(btree<int> tree1 , int target)
{
    bnode<int> *root = tree1.getRoot();
    queue<bnode<int> *> que;
    que.push(root);
    while(!que.empty())
    {
        bnode<int> *tmp = que.front();
        que.pop();
        if(tmp->getLeft() != NULL)
            que.push(tmp->getLeft());
        if(tmp->getRight() != NULL)
            que.push(tmp->getRight());

        vector<bnode<int> *> rs;
        printPath(rs , tmp , target , 0);
    }
}
bool isSubTree(bnode<int> *node , bnode<int> *root)
{
    if(node == NULL && root != NULL)
        return false;
    if(root == NULL)
        return true;
    if(node->getValue() != root->getValue())
        return false;
    return isSubTree(node->getLeft() , root->getLeft()) &&
        isSubTree(node->getRight() , root->getRight());
}
bool isSubTree(btree<int> tree1 , btree<int> tree2)
{
    bnode<int> *root1 = tree1.getRoot() , *root2 = tree2.getRoot();
    queue<bnode<int> *> que;
    que.push(root1);
    while(!que.empty())
    {
        bnode<int> *tmp = que.front();
        que.pop();
        if(isSubTree(tmp , root2))
            return true;
        if(tmp->getLeft() != NULL)
            que.push(tmp->getLeft());
        if(tmp->getRight() != NULL)
            que.push(tmp->getRight());
    }
    return false;
}

bool containBothNode(bnode<int> *root , bnode<int> *node1 , bnode<int> *node2)
{
    bool left = false , right = false;
    queue<bnode<int> *> que;
    que.push(root);
    while(!que.empty())
    {
        bnode<int> *tmp = que.front();
        que.pop();
        if(tmp == node1)
            left = true;
        if(tmp == node2)
            right = true;
        if(tmp->getLeft() != NULL)
            que.push(tmp->getLeft());
        if(tmp->getRight() != NULL)
            que.push(tmp->getRight());
    }
    return left && right;
}

bnode<int> *findAncestor(bnode<int> *root , bnode<int> *node1 , bnode<int> *node2)
{
    bool left = false , right = false;
    if(root->getLeft() != NULL)
        left = containBothNode(root->getLeft() , node1 , node2);
    if(root->getRight() != NULL)
        right = containBothNode(root->getRight() , node1 , node2);
    while(left || right)
    {
        if(left)
            root = root->getLeft();
        else
            root = root->getRight();
        if(root->getLeft() != NULL)
            left = containBothNode(root->getLeft() , node1 , node2);
        if(root->getRight() != NULL)
            right = containBothNode(root->getRight() , node1 , node2);
    }
    return root;
}

bnode<int> *nextInSearchTree(bnode<int> *root , bnode<int> *node , bnode<int> **tail)
{
    bnode<int> *leftTmp = NULL , *rightTmp = NULL;
    if(root->getLeft() != NULL)
        leftTmp = nextInSearchTree(root->getLeft() , node , tail);
    if(*tail == node)
    {
        *tail = root;
        return root;
    }
    *tail = root;
    if(root->getRight() != NULL)
        rightTmp = nextInSearchTree(root->getRight() , node , tail);

    return leftTmp ? leftTmp : rightTmp;
}

bool isSearchTree(bnode<int> *root , int lowerBound , int upperBound)
{
    if(root == NULL)
        return true;
    if(root->getValue() > lowerBound && root->getValue() < upperBound)
        return isSearchTree(root->getLeft() , lowerBound , root->getValue()) &&
            isSearchTree(root->getRight() , root->getValue() , upperBound);
    return false;
}

bool isSearchTree(bnode<int> *root)
{
    return isSearchTree(root->getLeft() , INT_MIN , root->getValue()) &&
        isSearchTree(root->getRight() , root->getValue() , INT_MAX);
}

void getLevelList(vector<vector<bnode<int> *> >  &rs , queue<bnode<int> *> que)
{
    if(que.empty())
        return;
    vector<bnode<int> *> tmpRs;
    queue<bnode<int> *> next_que;
    while(!que.empty())
    {
        bnode<int> *tmpNode = que.front();
        tmpRs.push_back(tmpNode);
        que.pop();
        if(tmpNode->getLeft() != NULL)
            next_que.push(tmpNode->getLeft());
        if(tmpNode->getRight() != NULL)
            next_que.push(tmpNode->getRight());
    }
    rs.push_back(tmpRs);
    getLevelList(rs , next_que);
}

void getLevelList(vector<vector<bnode<int> *> >  &rs , bnode<int> *root)
{
    if(root == NULL)
        return;
    queue<bnode<int> *> que;
    que.push(root);
    getLevelList(rs , que);
}

bnode<int>* buildShortSearchTree(int *vals , int lenth)
{
    if(lenth <= 0 || vals == NULL)
        return NULL;
    int mid = (lenth - 1) / 2;
    bnode<int> *root = new bnode<int>(vals[mid]);
    root->setLeft(buildShortSearchTree(vals , mid));
    root->setRight(buildShortSearchTree(vals + mid + 1 , lenth - mid - 1));
    return root;
}

bool hasPath(vector<vector<int> > graph , int wide , int src , int dst)
{
    bool *flag = new bool[wide];
    for(int i = 0; i < wide; i++)
        flag[i] = false;
    queue<int> que;
    for(int i = 0; i < wide; i++)
    {
        if(graph[src][i] != 0)
        {
            que.push(i);
            flag[i] = true;
        }
    }
    while(!que.empty())
    {
        int tmp = que.front();
        que.pop();
        for(int i = 0; i < wide; i++)
        {
            if(graph[tmp][i] != 0 && !flag[i])
            {
                que.push(i);
                flag[i] = true;
            }

        }
    }
    return flag[dst];
}

bool isBalanceBinaryTree(bnode<int> *root , int &dep)
{
    if(root == NULL)
    {
        dep = 0;
        return true;
    }
    int leftDep , rightDep;
    bool leftRs = isBalanceBinaryTree(root->getLeft() , leftDep);
    bool rightRs = isBalanceBinaryTree(root->getRight() , rightDep);
    dep = leftDep > rightDep ? leftDep + 1 :rightDep + 1;
    return leftRs && rightRs && (abs(leftDep - rightDep) <= 1);
}

bool isBalanceBinaryTree(btree<int> tree)
{
    int leftDep , rightDep;
    bool leftRs = isBalanceBinaryTree(tree.getRoot()->getLeft() , leftDep);
    bool rightRs = isBalanceBinaryTree(tree.getRoot()->getRight() , rightDep);
    return leftRs && rightRs && (abs(leftRs - rightRs) <= 1);
}
