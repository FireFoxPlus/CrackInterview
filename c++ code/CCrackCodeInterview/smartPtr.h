template<typename T>
class smartPtr
{
public :
    //本智能指针是第一个指向该资源的智能指针
    smartPtr(T *src)
    {
        counts = new int(1);
        *counts = 0;
        val = src;
    }
    //本智能指针指向另外一个智能指针所指向的对象
    smartPtr(smartPtr<T> *src)
    {
        val = src.getSrc();
        counts = src.getCount();
        *counts++;
    }
    ~smartPtr()
    {
        (*counts)--;
        if(counts == 0)
            delete val;
    }
    T *getSrc()
    {
        return val;
    }
    int *getCount()
    {
        return counts;
    }

private :
    T *val;
    int *counts;
};
