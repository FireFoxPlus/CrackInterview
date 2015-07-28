#ifndef UTILS_H
#include "utils.h"
#endif // UTILS_H

#ifndef _CHAP_TWO
#define _CHAP_TWO
#endif // _CHAP_TWO

#include <set>
using namespace std;

void removeDup(slist<int> &vals);
snode<int>* getLastKth(slist<int> vals , int k);
void delInOne(snode<int> *delNode);
void splitByx(slist<int> &vals , int x);
slist<int> addViaList(slist<int> add1 , slist<int> add2);
slist<int> addViaList_2(slist<int> add1 , slist<int> add2);
snode<int> *getCirclHead(slist<int> lists);
bool isPlaling(slist<char> word);
