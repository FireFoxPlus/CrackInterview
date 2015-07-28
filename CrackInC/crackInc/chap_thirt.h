#ifndef _CHAP_THIRT_H
#define _CHAP_THIRT_H

#include <stdlib.h>
#include <iostream>
using namespace std;
void *alignMalloc(size_t alloc_size , int align);
void alignFree(void *p);
int ** my2DAlloc(int m , int n);
int ** my2DAlloc_2(int m , int n);


#endif // _CHAP_THIRT_H
