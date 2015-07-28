#include "chap_thirt.h"
int ** my2DAlloc_2(int m , int n)
{
    size_t size_alloc = m * (sizeof(int *)) + m * n * sizeof(int);
    int **rs = (int **)malloc(size_alloc);

    if(rs == NULL)
        return NULL;

    int *buf = (int *)(rs + m);
    for(int i = 0; i < m; i++)
        rs[i] = buf + i * n;
    return rs;
}

int ** my2DAlloc(int m , int n)
{
    int **rs = (int**)malloc(sizeof(int *) * m);
    for(int i = 0; i < m; i++)
        *(rs + i) = (int *)malloc(sizeof(int) * n);
    return rs;
}

void *alignMalloc(size_t alloc_size , int align)
{
    void * origin = malloc(sizeof(char) * (alloc_size  + align - 1 + sizeof(void *)));
    if(origin == NULL)
        return NULL;
    void **rs = (void **)(((size_t)origin + align - 1 + sizeof(void *)) & ~(align - 1));
    rs[-1] = origin;
    return rs;
}

void alignFree(char *p)
{
    char *origin = (char *)p[-1];
    free(origin);
}

