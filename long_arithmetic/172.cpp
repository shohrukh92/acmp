/*
http://acmp.ru/index.asp?main=task&id_task=172
Заданы два числа: N и K. Необходимо найти остаток от деления N на K.

Входные данные
Входной файл INPUT.TXT содержит два целых числа: N и K (1 ≤ N ≤ 10100, 1 ≤ K ≤ 109).

Выходные данные
В выходной файл OUTPUT.TXT выведите остаток от деления N на K.
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
   { a[a[0]-i]=(int)sa[i]-48; } //***
 
   long long b; fin>>b;
   long long r=0;
   for (i=a[0]; i>=1; i--)
   {
      r=r*10+a[i];
      a[i]=r/b;
      r=r%b;
   }
   fout<<r; //remainder
   fin.close();
   fout.close();
   return 0;
}