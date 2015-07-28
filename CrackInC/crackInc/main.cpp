#include "chap_sevent.h"

class A
{
public :
    virtual void a()
    {

    }
};

class B
{
public :
    virtual void b()
    {

    }
};

class C : public A , public B
{



};



int main()
{
    C c;
    cout<<sizeof(c);

    return 0;
}


