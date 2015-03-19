#include "alloc.h"
#include <stddef.h>

void* alloc::alignAlloc(int len , int align)
{
    int offset = align - 1;
    void *rs_origin = (void *)new char(len + offset + sizeof(void *));
    void **rs_chanegd = (void **)(((size_t)rs_origin + offset) & ~(align - 1));
    rs_chanegd[-1] = rs_origin;
    return rs_chanegd;
}

void free(void *p)
{
    void *q = ((void**)p)[-1];
    free(q);
}
