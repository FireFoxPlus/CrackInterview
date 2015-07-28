#ifndef CHAP_NINE_H
#define CHAP_NINE_H

#include <vector>
#include <set>
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

typedef struct _point
{
    int x;
    int y;
    _point(int _x , int _y)
    {
        x = _x;
        y = _y;
    }
    bool operator <(const _point other) const
    {
        if(x < other.x || y < other.y)
            return true;
        return false;
    }
}point;

int climbStairs(int n);
int robotMove(point src , point dst);
void robotFindPath(point src , point dst , vector<point> path , set<point> hazard);
int magicIndex(vector<int> vals);
int magicIndexWithDup(vector<int> vals , int start , int ends);
vector<set<int> > subSets(set<int> in);
void allPermutatoin(string str);
void allPermutation(string rs , int index , string src);
void bracketPermutation(int n);
int makeByCoin(int val , int weight);
int eightQue();
#endif // CHAP_NINE_H
