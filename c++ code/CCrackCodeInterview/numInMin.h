class numInMid
{
public :
    int getMidNum(int *vals , int len);
    void heapAjust(int *vals , int len , bool (*compare)(int val1 , int val2) , bool (*compare2)(int val1 , int val2));
    void rebuild(int *vals , int preI , int len , bool (*compare)(int val1 , int val2) , bool (*compare2)(int val1 , int val2));
};
