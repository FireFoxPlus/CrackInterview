#include "lastKLine.h"
#include <stdio.h>
#include <iostream>

using namespace std;

void lastKLine::printKLine(const char *fileName , int k)
{
    FILE *seeker = NULL;
    FILE *printer = NULL;
    char vals[READ_LEN];
    int len;
    seeker = fopen(fileName , "r");
    if(seeker == NULL)
    {
        cout<<"open file error\n";
        return;
    }
    printer = fopen(fileName , "r");
    if(printer == NULL)
    {
        cout<<"open file error\n";
        return;
    }
    for(int i = 0; i < k; i++)
    {
        if(feof(seeker))
            return;
        fgets(vals , READ_LEN , seeker);
    }
    while(!feof(seeker) && !feof(printer))
    {
         fgets(vals , READ_LEN , printer);
         fgets(vals , READ_LEN , seeker);
    }
   // cout<<vals;
    while(!feof(printer))
    {
        fgets(vals , READ_LEN , printer);
        cout<<vals;
    }
    fclose(seeker);
    fclose(printer);
}
