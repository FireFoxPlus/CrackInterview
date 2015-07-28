#ifndef CHAP_THREE
#include "chap_three.h"
#endif // CHAP_THREE

void hanoi(stack<int> src , stack<int> dst , stack<int> help , int n)
{
    if(n == 1)
    {
        dst.push(src.top());
        src.pop();
    }
    hanoi(src , help , dst , n - 1);
    dst.push(src.top());
    src.pop();
    hanoi(help , dst , src , n - 1);
}

void sortStack(stack<int> &vals)
{
    stack<int> help;
    while(!vals.empty())
    {
        int tmp = vals.top();
        vals.pop();
        if(help.empty())
            help.push(tmp);
        else
        {
            while(!help.empty() && help.top() < tmp)
            {
                int pops = help.top();
                help.pop();
                vals.push(pops);
            }
            help.push(tmp);
        }
    }
    while(!help.empty())
    {
        vals.push(help.top());
        help.pop();
    }
}
