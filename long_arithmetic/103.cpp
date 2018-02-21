/*
http://acmp.ru/index.asp?main=task&id_task=103
Требуется сложить два целых числа А и В.

Входные данные
Во входном файле INPUT.TXT записано два неотрицательных целых числа, не превышающих 10100, по одному в каждой строке.

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести одно целое число — сумму чисел А и В, без лидирующих нулей.
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
   char sa[105],sb[105];
   fin.getline(sa,104);
   fin.getline(sb,104);
   int lena,lenb;
   lena=strlen(sa); lenb=strlen(sb);
   int max;
   lena>lenb ? max=lena : max=lenb;
   int* a=(int*)malloc((max+1+1)*sizeof(int)); //ans
   int* b=(int*)malloc((max+1+1)*sizeof(int));
   a[0]=lena; b[0]=lenb;
 
   int i,j;
   for (i=0; i<lena; i++)
   {  a[a[0]-i]=(int)sa[i]-48;   }
   for (j=i+1; j<max+2; a[j++]=0);
 
   for (i=0; i<lenb; i++)
   {  b[b[0]-i]=(int)sb[i]-48;   }
   for (j=i+1; j<max+2; b[j++]=0);
 
   a[0]=max;
   int r=0;
 
   for (i=1; i<=a[0]; i++)
   {
      a[i]=a[i]+b[i]+r;
      if (a[i]>9)
      {
         a[i]-=10;
         r=1;
      }
      else r=0;
   }
   if (r==1)
   {
      a[0]++;
      a[a[0]]=1;
   }
   for (i=a[0]; i>0; fout<<a[i--]);

   fin.close();
   fout.close();

   return 0;
}