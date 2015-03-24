#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>
#include <algorithm>
#include "TreeToList.h"
using namespace std;
int FindSubString( char* pch )
{
    int   count  = 0;
    char  * p1   = pch;
    while ( *p1 != '\0' )
    {
        if ( *p1 == p1[1] - 1 )
        {
            p1++;
            count++;
        }else  {
            break;
        }
    }
    int count2 = count;
    while ( *p1 != '\0' )
    {
        if ( *p1 == p1[1] + 1 )
        {
            p1++;
            count2--;
        }else  {
            break;
        }
    }
    if ( count2 == 0 )
        return(count);
    return(0);
}
void ModifyString( char* pText )
{
    char  * p1   = pText;
    char  * p2   = p1;
    while ( *p1 != '\0' )
    {
        int count = FindSubString( p1 );
        if ( count > 0 )
        {
            *p2++ = *p1;
            sprintf( p2, "%i", count );
            while ( *p2 != '\0' )
            {
                p2++;
            }
            p1 += count + count + 1;
        }else  {
            *p2++ = *p1++;
        }
    }
}
int main( void )
{
//    char text[32] = "XYBCDCBABABA";
//    ModifyString( text );
//    printf( text );
    TreeNode a(4);
    TreeNode b(2);
    TreeNode c(5);
    TreeNode d(1);
    TreeNode e(3);

    a.setLeft(&b);
    a.setRight(&c);
    b.setLeft(&d);
    b.setRight(&e);
    buildList(&a);
    cout<<(d.getRight()->getRight()->getRight()->getValue());
    return 0;
}
