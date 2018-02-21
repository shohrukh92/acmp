/*
http://acmp.ru/index.asp?main=task&id_task=474
Бесконечная последовательность битов, предложенная Кеане, равна 001001110001001110110110001… и формируется следующим алгоритмом: вначале записывается 0, потом 001, далее 001001110, то есть, для получения следующего члена, предыдущий записывается дважды, а справа приписывается его отрицание. Элементы этого ряда являются начальными подпоследовательностями Кеане.
Требуется написать программу, которая по заданному n определит N-й бит этой последовательности.

Входные данные
Входной файл INPUT.TXT содержит число N (N ≤ 10200).

Выходные данные
В выходной файл OUTPUT.TXT должен содержать найденный бит.
*/

#include <fstream>
#include <string.h>
using namespace std;
const int N=421;

ifstream in("INPUT.TXT");
ofstream out("OUTPUT.TXT");

char *div(char *s,int length,char *t,int *mod)
{
    int ind=0,curnum=0,indt=0;
    t[0]='0';
    t[1]=0;
    if ((s[0]-'0')<3)
    {
        if (length==1)
        {
            *mod=s[0]-'0';
            return t;
        }
        else
        {
            curnum=(s[0]-'0')*10+s[1]-'0';;
            ind=1;
        }
    }
    else
        curnum=s[0]-'0';
    for(;;)
    {
        t[indt++]=(curnum)/3+'0';
        ind++;
        if (ind==length)
            break;
        curnum=(curnum%3)*10+s[ind]-'0';
    }
    t[indt]=0;
    *mod=curnum%3;
    return t;
}

char *to3(char *s)
{
    char *t=new char[N],*tmp=new char[N];;
    int l=0,mod;
    while(s[0]!='0')
    {
        div(s,strlen(s),tmp,&mod);
        strcpy(s,tmp);
        t[l++]=mod+'0';
    }
    t[l]=0;
    strrev(t);
    strcpy(s,t);
    delete[] tmp;
    delete[] t;
    return t;
}
char *dec(char *s)
{
    int ost;
    int tmp;
    char t[N];
    if (s[strlen(s)-1]=='0')
    {
        s[strlen(s)-1]='9';
        s[strlen(s)-2]--;
    }
    else
    {
        s[strlen(s)-1]--;
        return s;
    }
    for (int i=strlen(s)-2;i>=0;i--)
    {
        tmp=s[i]-'0';
        if (tmp<0)
        {
            s[i-1]--;
            s[i]='9';
        }
    }
    int j=0;
    while(s[j++]=='0')
        ;
    j--;
    strcpy(t,s+j);
    strcpy(s,t);
    return s;
}
int main()
{
    char s[N];
    int var=0;
    in>>s;
    dec(s);
    to3(s);
    int len=strlen(s);
    for (int i=0;i<len;i++)
    {
        if (s[i]=='2')
            var^=1;
    }
    out<<var;

    return 0;
}