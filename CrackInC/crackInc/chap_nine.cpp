#include "chap_nine.h"

bool validPoi(const set<int> &line , const set<int> &col , int nowLine , int nowCol ,
              vector<vector<int> > &board)
{
    //行
    if(!line.empty() && line.count(nowLine) != 0)
        return false;
    //列
    if(!col.empty() && col.count(nowCol) != 0)
        return false;
    //左上
    for(int i = 0; nowLine - i - 1 >=0 && nowCol - i - 1 >= 0; i++)
    {
        if(board[nowLine - i - 1][nowCol - i - 1] != 0)
            return false;
    }

    //右下
    for(int i = 0; nowLine + i + 1 < 8 && nowCol + i + 1 < 8; i++)
    {
        if(board[nowLine + i + 1][nowCol + i + 1] != 0)
            return false;
    }
    //左下
    for(int i = 0; nowLine + i + 1< 8 && nowCol - i - 1 >= 0; i++)
    {
        if(board[nowLine + i + 1][nowCol - i -1] != 0)
            return false;
    }

    //右上
    for(int i = 0; nowLine - i - 1 >= 0 && nowCol + i + 1 < 8; i++)
    {
        if(board[nowLine - 1 - i][nowCol + 1 + i] != 0)
            return false;
    }
    return true;
}

bool eightQue(int line , vector<vector<int> > board , set<int> lines , set<int> cols)
{
    static int counts = 0;

    if(line == 8)
    {
        for(int i = 0; i < board.size(); i++)
        {
            for(int j = 0; j < board[i].size(); j++)
                cout<<board[i][j]<<" ";
            cout<<endl;
        }
        cout<<endl;
        return true;
    }
    for(int i = 0; i < 8; i++)
    {
        if(validPoi(lines , cols , line , i , board))
        {
            lines.insert(line);
            cols.insert(i);
            board[line][i] = 1;
            eightQue(line + 1 , board , lines , cols);
            board[line][i] = 0;
            lines.erase(line);
            cols.erase(i);
        }
    }
}

int eightQue()
{
    vector<vector<int> > board;
    board.resize(8);
    set<int> line , col;
    for(int i = 0; i < 8; i++)
        board[i].resize(8 , 0);
    eightQue(0 , board , line , col);
}

int makeByCoin(int val , int weight)
{
    int next_weight = 0;
    switch(weight)
    {
    case 25 :
        next_weight = 10;
        break;
    case 10 :
        next_weight = 5;
        break;
    case 5 :
        next_weight = 1;
        break;
    case 1 :
        return 1;
    }
    int ways = 0;
    for(int i = 0; i * weight <=     val; i++)
        ways += makeByCoin(val - i * weight , next_weight);
    return ways;
}

void bracketPermutation(string rs , int pre , int after)
{
    if(after < pre || pre < 0 || after < 0)
        return;
    if(pre == 0 && after == 0)
    {
        cout<<rs<<endl;
        return;
    }
    if(after > pre)
    {
        string tmp = rs;
        tmp.append(1 , ')');
        after--;
        bracketPermutation(tmp , pre , after);
        after++;
    }
    string tmp = rs;
    tmp.append(1 , '(');
    pre--;
    bracketPermutation(tmp , pre , after);
}

void bracketPermutation(int n)
{
    string rs;
    bracketPermutation(rs , n , n);
}

void allPermutation(string rs , int index , string src)
{
    if(index >= src.length())
    {
        cout<<rs<<endl;
        return;
    }
    for(int i = 0; i <= rs.length(); i++)
    {
        string tmp = rs;
        tmp.insert(i , 1 , src[index]);
        allPermutation(tmp , index + 1 , src);
    }
}

void allPermutatoin(string str)
{
    cout<<str<<endl;
    while(next_permutation(str.begin() , str.end()))
        cout<<str<<endl;
}

void subSets(int nums , vector<set<int> > &rs)
{
    int sizes = rs.size();
    for(int i = 0; i < sizes; i++)
    {
        set<int> tmp = rs[i];
        tmp.insert(nums);
        rs.push_back(tmp);
    }
}

vector<set<int> > subSets(set<int> in)
{
    vector<set<int> > rs;
    rs.push_back(set<int> ());
    for(set<int>::iterator itr = in.begin(); itr != in.end(); itr++)
        subSets(*itr , rs);
    return rs;
}

int magicIndexWithDup(vector<int> vals , int start , int ends)
{
    if(ends < start)
        return -1;
    int low = 0 , high = vals.size() - 1;
    int mid = low + (high - low) / 2;
    if(vals[mid] == mid)
        return mid;
    int left = magicIndexWithDup(vals , start , min(mid - 1 , vals[mid]));
    if(left != -1)
        return left;
    return magicIndexWithDup(vals , max(mid + 1 , vals[mid]) , ends);
}

int magicIndex(vector<int> vals)
{
    int low = 0 , high = vals.size() - 1;
    int mid = low + (high - low) / 2;
    while(low <= high)
    {
        if(vals[mid] == mid)
            return mid;
        if(vals[mid] > mid)
            high = mid - 1;
        else
            low = mid + 1;
        mid = low + (high - low) / 2;
    }
    return -1;
}

void robotFindPath(point src , point dst , vector<point> path , set<point> hazard)
{
    if(src.x > dst.x || src.y > dst.y)
        return;
    if(src.x == dst.x && src.y + 1 == dst.y)
    {
        path.push_back(src);
        path.push_back(dst);
        for(int i = 0; i < path.size(); i++)
            cout<<"("<<path[i].x<<' '<<path[i].y<<")";
        cout<<endl;
        return;
    }
    if(src.y == dst.y && src.x + 1 == dst.x)
    {
        path.push_back(src);
        path.push_back(dst);
        for(int i = 0; i < path.size(); i++)
            cout<<"("<<path[i].x<<' '<<path[i].y<<")";
        cout<<endl;
        return;
    }
    if(hazard.count(src) == 0)
        path.push_back(src);
    else
        return;
    robotFindPath(point(src.x + 1 , src.y) , dst , path , hazard);
    robotFindPath(point(src.x , src.y + 1) , dst , path , hazard);
}

int robotMove(point src , point dst)
{
    if(src.x > dst.x || src.y > dst.y)
        return 0;
    if(src.x == dst.x && src.y + 1 == dst.y)
        return 1;
    if(src.y == dst.y && src.x + 1 == dst.x)
        return 1;
    return robotMove(point(src.x + 1 , src.y) , point(dst.x , dst.y)) +
        robotMove(point(src.x , src.y + 1) , point(dst.x , dst.y));
}

int climbStairs(int n)
{
    if(n < 0)
        return 0;
    if(n <= 1)
        return 1;
    return climbStairs(n - 1) + climbStairs(n - 2) + climbStairs(n - 3);
}
