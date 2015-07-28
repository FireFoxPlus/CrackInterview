#ifndef CHAP_FOUR
#define CHAP_FOUR
#endif // CHAP_FOUR

#include <limits.h>
#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H

#include <vector>
#include <cmath>
#include <queue>
using namespace std;

bool isBalanceBinaryTree(btree<int> tree);
bool hasPath(vector<vector<int> > graph , int wide , int src , int dst);
bnode<int>* buildShortSearchTree(int *vals , int length);
void getLevelList(vector<vector<bnode<int> *> > &rs, bnode<int> *rootW);
bool isSearchTree(bnode<int> *root);
bnode<int> *nextInSearchTree(bnode<int> *root , bnode<int> *node , bnode<int> **tail);
bnode<int> *findAncestor(bnode<int> *root , bnode<int> *node1 , bnode<int> *node2);
bool isSubTree(btree<int> tree1 , btree<int> tree2);
void getPathSumToN(btree<int> tree1 , int target);
