#include <stdlib.h>
template<typename T>
class my2DAlloc
{
public :
    T** alloc2D(int height , int width);
    T** alloc2D_2(int lines , int cols);
};

template<typename T>
T** my2DAlloc<T>::alloc2D(int height , int width)
{
    T **rs = new T*[height];
    for(int i = 0; i < height; i++)
    {
        T *tmp = new T[width];
        rs[i] = tmp;
    }
    return rs;
}

template<typename T>
T** my2DAlloc<T>::alloc2D_2(int lines , int cols)
{
    T head = sizeof(T *) * lines;
    T data = sizeof(T) * lines * cols;

    T** rs = (T** )malloc(sizeof(int) * (head + data));
    int *buf = (int *)(rs + head);
    for(int i = 0; i < lines; i++)
    {
        rs[i] = buf + i * cols;
    }
    return rs;
}
