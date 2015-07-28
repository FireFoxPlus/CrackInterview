#ifndef _CHAP_ONE
#include "chap_one.h"
#endif
bool isRoateString(string str1 , string str2)
{
    str1 += str1;
    if(str1.find(str2) != string::npos)
        return true;
    return false;
}

void clearRowCol(int *vals , int wide , int height)
{
    set<int> rows , cols;
    typedef int (*row)[wide];
    row prow = (row)vals;
    for(int i = 0; i < height; i++)
    {
        int *eachRow = (int *)(prow[i]);
        for(int j = 0; j < wide; j++)
        {
            if(eachRow[j] == 0)
            {
                rows.insert(i);
                cols.insert(j);
            }
        }
    }
    for(int i = 0; i < height; i++)
    {
        int *eachRow = (int *)(prow[i]);
        for(int j = 0; j < wide; j++)
        {
            if(rows.count(i) != 0 || cols.count(j) != 0)
                eachRow[j] = 0;
        }
    }
}

void rotatePic(vector<vector<int> > &pic , int n)
{
    for(int i = 0; i < n / 2; i++)
    {
        for(int j = i; j < n - 1 - i; j++)
        {
            //上到右
            int tmp = pic[j][n - 1 - i];
            pic[j][n - 1 - i] = pic[i][j];
            //右到下
            int tmp1 = pic[n - 1 - i][n - 1 - j];
            pic[n - 1 - i][n - 1 - j] = tmp;
            //下到左
            tmp = pic[n - 1 - j][i];
            pic[n - 1 - j][i] = tmp1;
            //左到上
            pic[i][j] = tmp;
        }
    }
}

string squString(string str)
{
    string rs;
    char pre = -1;
    char char_count;
    for(int i = 0; i < str.length(); i++)
    {
        if(str[i] != pre)
        {
            if(i != 0)
               rs.append(1 , char_count);
            rs.append(1 , str[i]);
            char_count = '1';
            pre = str[i];
        }
        else
            char_count++;
    }
    rs.append(1 , char_count);

    if(rs.length() > str.length())
        return str;
    else
        return rs;
}

string replaceBlank(string str)
{
    int blanks = 0;
    for(int i = 0; i < str.length(); i++)
        if(str[i] == ' ')
            blanks++;
    int length = str.length() + blanks * 2;
    char *rs = new char[length];
    length--;
    int inputLength = str.length() - 1;
    while(length >= 0)
    {
        if(str[inputLength] != ' ')
        {
            rs[length] = str[inputLength];
            length--;
            inputLength--;
        }
        else
        {
            rs[length] = '0';
            length--;
            rs[length] = '2';
            length--;
            rs[length] = '%';
            length--;
            inputLength--;
        }
    }
    return string(rs , str.length() + blanks * 2);
}

bool equalAfterSort(string str1 , string str2)
{
    sort(str1.begin() , str1.end());
    sort(str2.begin() , str2.end());
    return str1 == str2;
}

void m_reverse(string &str)
{
    int start = 0 , ends = str.length() - 1;
    while(start < ends)
    {
        char tmp = str[ends];
        str[ends] = str[start];
        str[start] = tmp;
        start++;
        ends--;
    }
}

bool isUinque(string str)
{
    set<char> record;
    for(int i = 0; i < str.length(); i++)
    {
        if(record.count(str[i]) == 0)
            record.insert(str[i]);
        else
            return false;
    }
    return true;
}

