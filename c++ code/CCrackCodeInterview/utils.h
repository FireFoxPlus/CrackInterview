#define UTILS_H
#include "TreeToList.h"
#include <iostream>
#include <cstring>
using namespace std;

bool small(int val1 , int val2);
void mswap(int *val1 , int *val2);
int getRandom(int range);
int arrayToInt(char *rs);
int nDigits(int val);
int mmin(int val1 , int val2);
void buildList(TreeNode* root);
void midTour(TreeNode* root , TreeNode** tailList);

//单链表节点
template<typename T>
class snode
{
public :
    snode()
    {
        next = NULL;
    }
    void setValue(const T &tvalue)
    {
        value = tvalue;
    }
    void setNext(snode<T> *tnext)
    {
        next = tnext;
    }
    snode<T>* getNext()
    {
        return next;
    }
    T getValue()
    {
        return value;
    }
private :
    T value;
    snode<T> *next;
};
//单链表
template<typename T>
class slist
{
public :
    slist()
    {
        length = 0;
        head =  NULL;
        tail = NULL;
    }
    //返回链表头指针
    snode<T> * getHead()
    {
        return head;
    }
    //返回链表尾指针
    snode<T> * getTail()
    {
        return tail;
    }
    //返回链表长度
    int getLength()
    {
        return length;
    }
    //新加节点，尾插法
    void tailInsert(T value)
    {
        snode<T> *temp = new(snode<T>);
        temp->setValue(value);
        if(length == 0)
        {
            head = temp;
            tail = temp;
            head->setNext(NULL);
            length++;
        }
        else
        {
            tail->setNext(temp);
            tail = temp;
            length++;
        }
    }
    //新增节点，头插法
    void headInsert(T value)
    {
        snode<T> * temp = new(snode<T>);
        temp->setValue(value);
        if(length == 0)
        {
            head = temp;
            tail = temp;
            length++;
        }
        else
        {
            temp->setNext(head);
            head = temp;
            length++;
        }
    }
    //删除节点，从尾部
    T tailDel()
    {
        if(length == 0)
        {
            cout<<"链表为空"<<endl;
            //return -1;
        }

        snode<T> *iter = head;
        if(length == 1)
        {
            T temp = tail->getValue();
            delete(tail);
            tail = head = NULL;
            length--;
            return temp;
        }

        while(iter != NULL)
        {
            if(iter->getNext() != tail)
                iter = iter->getNext();
            else
                break;
        }
        T temp = tail->getValue();
        iter->setNext(NULL);
        delete(tail);
        tail = iter;
        length--;
        return temp;
}
//删除节点，从头部
    T& headDel()
    {
        if(length == 0)
        {
            cout<<"链表为空"<<endl;
            //return -1;
        }
        snode<T> *temp = head;
        T rs = temp->getValue();
        head = head->getNext();
        delete(temp);
        length--;
        return rs;
    }

    snode<T>* listReverse();

    //打印链表
    void print()
    {
        if(head == NULL)
            return;
        snode<T>* tmp = head;
        while(tmp != tail && tmp != NULL)
        {
            cout<<tmp->getValue()<<' ';
            tmp = tmp->getNext();
        }
        if(tmp != NULL)
            cout<<tmp->getValue()<<endl;
    }

private :
    int length;
    snode<T> *head;
    snode<T> *tail;
};

template<typename T>
snode<T>* slist<T>::listReverse()
{
    snode<T> *pre , *next , *next_next;
    pre = head;
    next = head->getNext();
    next_next = next->getNext();
    while(next != NULL)
    {
        if(pre == head)
        {
            tail = pre;
            pre->setNext(NULL);
        }
        if(next != NULL)
            next->setNext(pre);

        pre = next;
        next = next_next;
        if(next_next != NULL)
            next_next = next_next->getNext();
    }
    head = pre;
    return pre;
}
//栈:单链表实现
template<typename T>
class mstack
{
public :
   const T top()
   {
        return storage.getHead()->getValue();
    }
    int getLength()
    {
        return storage.getLength();
    }
    T pop()
    {
        T rs = storage.headDel();
        return rs;
    }
    void push(T tvalue)
    {
        storage.headInsert(tvalue);
    }
    slist<T> getStorage()
    {
        return storage;
    }
    void print()
    {
        storage.print();
    }

private :
    slist<T> storage;
};

//队列，队首入队，队尾出队
template<typename T>
class mqueue
{
public :
    int getLength()
    {
        return storage.getLength();
    }
    void addQueue(T tvalue)
    {
        storage.headInsert(tvalue);
    }
    T deQueue()
    {
        T rs = storage.tailDel();
        return rs;
    }
    slist<T> getStorage()
    {
        return storage;
    }
    void print()
    {
        storage.print();
    }
private :
    slist<T> storage;
};
//树
//二叉树
template<typename T>
class bnode
{
//二叉树节点
public :
    bnode()
    {
        left = NULL;
        right = NULL;
    }
    bnode<T>* getRight()
    {
        return right;
    }
    bnode<T> *getLeft()
    {
        return left;
    }
    void setLeft(bnode<T> *tleft)
    {
        left = tleft;
    }
    void setRight(bnode<T> *tright)
    {
        right = tright;
    }
    T getValue()
    {
        return value;
    }
    void setValue(T tvalue)
    {
        value = tvalue;
    }
private :
    T value;
    bnode<T> *left;
    bnode<T> *right;
};

template<typename T>
class btree
{
public :
    btree()
    {
        root = NULL;
    }
    //层次构造满二叉树
    btree(T *values , int length)
    {
        root = NULL;
        int counts = 0;
        if(values == NULL || length == 0)
            return;

        mqueue< bnode<T>* > que;
        root = new(bnode<T>);
        root->setValue(values[counts]);
        root->setLeft(NULL);
        root->setRight(NULL);
        que.addQueue(root);
        counts++;
        bnode<T> *father = NULL;

        while(que.getLength() != 0 && counts < length)
        {
            bnode<T> * temp = new(bnode<T>);
            temp->setValue(values[counts]);
            temp->setLeft(NULL);
            temp->setRight(NULL);

            if(counts == 1)
                father = que.deQueue();

            if(father->getLeft() == NULL)
            {
                father->setLeft(temp);
                counts++;
                que.addQueue(temp);
                continue;
            }
            else if(father->getRight() == NULL)
            {
                father->setRight(temp);
                counts++;
                que.addQueue(temp);
                father = que.deQueue();
            }
        }
    }
    bnode<T>* getRoot()
    {
        return root;
    }
private :
    bnode<T> *root;
};

//默认支持100位的大整数
class BigNum
{
public :
    BigNum()
    {
        num = new char[100];
        memset(num , '0' , sizeof(char) * 100);
        overFlow = false;
    }
    explicit BigNum(int m)
    {
        num = new char[m];
        memset(num , '0' , sizeof(char) * m);
        length = m;
        overFlow = false;
    }
    bool getOverFlow()
    {
        return overFlow;
    }
    BigNum& operator+(int m)
    {
        int carry = 0;
        int counts = 0;

        while(m != 0 || carry == 1)
        {
            int thisPoi = m % 10;
            m = m / 10;
            num[counts] += thisPoi + carry;
            carry = 0;

            if(num[counts] > '9')
            {
                carry = 1;
                num[counts] -= 10;
            }

            counts++;
            if(counts > length)
            {
                overFlow = true;
                break;
            }
        }
        return *this;
    }
    int getWide(int m)
    {
        int rs = 1;
        while(m /= 10)
            rs++;
        return rs;
    }

    void print()
    {
        bool flage = false;
        int counts = length - 1;
        while(counts >= 0)
        {
            if(num[counts] > '0')
                flage = true;
            if(num[counts] == '0' && flage)
            {
                cout<<0;
                counts--;
            }
            else if(num[counts] != '0')
                cout<<num[counts--];
            else counts--;
        }
        cout<<' ';
    }
private :
    char *num;
    int length;
    bool overFlow;
};
