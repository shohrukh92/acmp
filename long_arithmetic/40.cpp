/*
http://acmp.ru/index.asp?main=task&id_task=40
Необходимо вычислить значение 2^n.

Входные данные
В единственной строке входного файла INPUT.TXT записано натуральное число n (0 < n < 1000).

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести значение 2^n.
*/

#include <iostream>
#include <fstream>
#include <stdlib.h>
 
using namespace std;
 
int main()
{
   ifstream fin("input.txt");
   ofstream fout("output.txt");
   int n,i,j;
   fin>>n;
 
   int len;
   len=0.30102995*n+1;
 
   int* mas=(int*)malloc((len+10)*sizeof(int));
   mas[0]=1; //curr.len
   mas[1]=1;
   int r; //remainder
   for (i=1; i<=n; i++)
   {
      r=0;
      for (j=1; j<=mas[0]; j++)
      {
         mas[j]=mas[j]*2+r; //***
         if (mas[j]>9)
         {
            r=1;
            mas[j]-=10;
         }
         else r=0;
      }
      if (r==1)
      {
         mas[0]++;
         mas[mas[0]]=1;
      }
   }
 
   for (i=mas[0]; i>0; i--)
   {
      fout<<mas[i];
   }
   fin.close();
   fout.close();
   return 0;
}