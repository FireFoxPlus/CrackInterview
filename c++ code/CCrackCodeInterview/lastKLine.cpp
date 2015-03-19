#include "lastKLine.h"

void lastKLine::printKLine(const char *fileName)
{
    FILE *printFile = NULL;
    printFile = fopen(fileName , "r");
    if(printFile == NULL)
    {
        cout<<"open file error\n";
        return;
    }

}
