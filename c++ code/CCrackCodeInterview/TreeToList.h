#include <iostream>
using namespace std;
class TreeNode
{
public :
    void setLeft(TreeNode* setVal)
    {
        left = setVal;
    }

    void setRight(TreeNode* setVal)
    {
        right = setVal;
    }

    TreeNode* getLeft()
    {
        return left;
    }

    TreeNode* getRight()
    {
        return right;
    }

    TreeNode(int setVal)
    {
        value = setVal;
        left = NULL;
        right = NULL;
    }

    int getValue()
    {
        return value;
    }

    friend void buildList(TreeNode* root);
    friend void midTour(TreeNode* root , TreeNode** tailList);
private :
    int value;
    TreeNode* left;
    TreeNode* right;
};
