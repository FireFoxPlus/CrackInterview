#include <iostream>
#include "sumPath.h"
#include <vector>

using namespace std;
class Solution {
public:
	/**
	 *	奇数位上都是奇数或者偶数位上都是偶数
	 *	输入：数组arr，长度大于2
	 *	将arr调整成奇数位上都是奇数或者偶数位上都是偶数
	 */
	int getFirstUnFormedNum(vector<int> arr, int len) {
        int mins = arr[0], maxs = 0;
        for(int i = 0; i < len; i++)
        {
            if(arr[i] < mins)
                mins = arr[i];
            maxs += arr[i];
        }
        int i;
        for(i = mins; i <= maxs; i++)
        {
            bool rs = canMake(arr , len , i);
            if(!rs)
                return i;
        }
        if(i == maxs)
            return maxs + 1;
    }
    bool canMake(vector<int>& arr , int len , int target)
    {
        bool rs = false;
        vector<int>::iterator itr;
        for(itr = arr.begin(); itr != arr.end();)
        {
            if(target == *itr)
                return true;
            int tmp = *itr;

            if(target - *itr > 0)
            {
                itr = arr.erase(itr);
                rs = canMake(arr , len - 1 , target - tmp);
                itr = arr.insert(itr , tmp);
                if(rs == true)
                    return rs;
            }
            ++itr;
        }
        return rs;
    }
};


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
