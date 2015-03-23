#include "guessColor.h"
#include <string>
void guessColor::guessResult(string given , string guess)
{
    if(given.size() != 4 || guess.size() != 4)
        return;
    int right = 0 , fakeRight = 0;
    for(int i = 0; i < 4; i++)
    {
        if(given[i] == guess[i])
            right++;
    }
    sort(&given[0] , &given[4]);
    sort(&guess[0] , &guess[4]);
    for(int i = 0; i < 4; i++)
    {
        if(given[i] == guess[i])
            fakeRight++;
    }
    fakeRight -= right;
    cout<<"right:"<<right<<endl;
    cout<<"fakeRight"<<fakeRight<<endl;
}
