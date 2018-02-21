/*
http://acmp.ru/index.asp?main=task&id_task=144
Даны два целых неотрицательных числа A и B. Требуется найти их произведение.

Входные данные
Во входном файле INPUT.TXT записаны целые неотрицательные числа A и B по одному в строке (A < 10100, B ≤ 10000).

Выходные данные
В выходной файл OUTPUT.TXT выведите единственное число без лидирующих нулей: A*B.
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
   char sa[105];
   fin.getline(sa,104);
 
   int* a=(int*)malloc((strlen(sa)+6)*sizeof(int));
   a[0]=strlen(sa);
   int i;
   for (i=0; i<a[0]; i++)
   {  a[a[0]-i]=(int)sa[i]-48;   }
 
   int b;
   fin>>b;
 
   int t,r=0;
   for (i=1; i<=a[0]; i++)
   {
      t=a[i]*b+r;
      a[i]=t%10;
      r=t/10;
 
   }
   while (r)
   {
      a[i]=r%10;
 
      r/=10;
      i++;
      a[0]++;
   }

   if (b==0) fout<<0; else
   for (i=a[0]; i>0; fout<<a[i--]);

   fin.close();
   fout.close();

   return 0;
}