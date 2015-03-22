#include <iostream>
#include <vector>
#include <cstring>
#include <stdio.h>
#include <algorithm>

using namespace std;


bool compare(string val1 , string val2)
{
    int tmp1 = 0 , tmp2 = 0;
    for(int i = 0; i < val1.size(); i++)
    {
        if(val1[i] >= '0' && val1[i] <= '9')
            tmp1 = tmp1 * 10 + val1[i];
        else break;
    }
    for(int i = 0; i < val2.size(); i++)
    {
        if(val2[i] >= '0' && val2[i] <= '9')
            tmp2 = tmp2 * 10 + val2[i];
        else break;
    }
    return tmp1 < tmp2;
}


using namespace std;

int main()
{
    string ab[] = {"23124df" , "23vf" , "789df" , "797df" , "898sdf" , "234df"};
    sort(ab , ab + 6 , compare);
    for(int i = 0; i < 6; i++)
        cout<<ab[i]<<endl;
    return 0;
}
