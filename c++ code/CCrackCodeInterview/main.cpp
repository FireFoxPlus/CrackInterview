#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>
#include <algorithm>
#include "guessColor.h"
using namespace std;

int main()
{
    string given = "RGBY" , guess = "GGRR";
    guessColor ob;
    ob.guessResult(given , guess);
    return 0;
}
