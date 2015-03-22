#include "swapWithoutTmp.h"

void swapWithOutTmp::swapNoTmp(int *val1 , int* val2)
{
    *val1 = *val1 + *val2;
    *val2 = *val1 - *val2;
    *val1 = *val1 - *val2;
}
