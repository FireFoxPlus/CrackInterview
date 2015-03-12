#include <iostream>
#include "sumPath.h"
#include <vector>

using namespace std;

int main()
{
    Solution ob;
    vector<int> aa;
    aa.push_back(3);
    aa.push_back(2);
    aa.push_back(4);
    cout<<ob.getFirstUnFormedNum(aa , 3);
    return 0;
}
