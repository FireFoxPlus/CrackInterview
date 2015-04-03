#include "longCombine.h"
#include <map>
#include <algorithm>
#include <iostream>

using namespace std;

bool compareStr(const string &val1 , const string &val2)
{
    return val1.length() > val2.length();
}

bool longCombine::isSubString(string main , string*vals , int len)
{
    bool rs = false;
    for(int i = 0; i < len; i++)
    {
        if(main.find(vals[i]) != string::npos)
        {
            rs = true;
            break;
        }
    }
    return rs;
}

string longCombine::getLongest(string vals[] , int len)
{
    map<string , bool> wordsExsit;
    string rs;
    for(int i = 0; i < len; i++)
        //wordsExsit.insert(map<string , int>::value_type(vals[i] , true));
        wordsExsit.insert(pair<string , bool>(vals[i] , true));
    //数组按长度排序
    sort(vals , vals + len , compareStr);
    for(int i = 0; i < len; i++)
        for(int j = len - 1; j > i; j--)
        {
            if(vals[i].find(vals[j]) == string::npos ||
               vals[i].find(vals[j]) != 0)
                continue;
            else
            {
                int poi = vals[j].length();
                string tmp = vals[i].substr(poi);
                if(isSubString(tmp , vals , len))
                {
                    rs = vals[i];
                    break;
                }
                else
                    continue;
            }
        }
    return rs;
}
