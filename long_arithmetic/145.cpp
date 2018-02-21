/*
http://acmp.ru/index.asp?main=task&id_task=145
Даны два целых числа A и B. Требуется найти их целую часть от их частного.

Входные данные
Во входном файле INPUT.TXT записаны целые числа A и B по одному в строке (0 ≤ A ≤ 10^100, 0 < B ≤ 10000).

Выходные данные
В выходной файл OUTPUT.TXT выведите единственное число без лидирующих нулей: A div B.
*/

#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <string.h>
using namespace std;
 
int main()
{
   ifstream fin("input.txt");
   ofstream fout("output.txt");
   char sa[102];
   fin>>sa;
   int* a=(int*)malloc((strlen(sa)+1)*sizeof(int));
   a[0]=strlen(sa);
   int i;
   for (i=0; i<a[0]; i++)
   { a[a[0]-i]=(int)sa[i]-48; }
 
   long long b; fin>>b;
   long long r=0;
   for (i=a[0]; i>0; i--)
   {
      r=r*10+a[i];
      a[i]=r/b;
      r=r%b;
   }
 
   while (a[0]>1 && a[a[0]]==0)
   { a[0]--; }
 
   for (i=a[0]; i>0; fout<<a[i--]);

   fin.close();
   fout.close();

   return 0;
}