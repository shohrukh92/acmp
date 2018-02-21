/*
http://acmp.ru/index.asp?main=task&id_task=197
Требуется заполнить змейкой квадратную матрицу так, как показано на рисунке справа: заполнение происходит с единицы из левого верхнего угла и заканчивается в правом нижнем числом N2, где N – порядок матрицы.

Входные данные
Во входном файле INPUT.TXT задано натуральное число N – размер квадратной матрицы (N ≤ 100).

Выходные данные
В выходной файл OUTPUT.TXT выведите матрицу, заполненную числами от 1 до N2 змейкой, при этом между числами может быть любое количество пробелов.
*/
#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <iomanip>
using namespace std;
 
int main()
{
   ifstream fin("INPUT.txt");
   ofstream fout("OUTPUT.txt");
   int n; fin>>n; //***
   int i,j;
   int** mas=(int**)malloc(n*sizeof(int*));
   for (i=0; i<n; i++)
   {
      mas[i]=(int*)malloc(n*sizeof(int));
   }
 
   bool ru;
   int k=2;
 
   mas[0][0]=1;
   ru=true;
   i=1; j=0;
 
   while (k<=n*n)
   {
      mas[i][j]=k;
      if (ru)
      {
         i--; j++;
         if (i==-1 && j<n)
         {
            ru=false;
            i++;
         }
         else if ((i==-1 && j==n) || (j==n))
         {
            ru=false;
            i+=2; j--;
         }
      }
      else //ru==false
      {
         i++; j--;
         if (j==-1 && i<n)
         {
            ru=true;
            j++;
         }
         else if ((j==-1 && i==n) || (i==n))
         {
            ru=true;
            j+=2; i--;
         }
      }
      k++;
   }
 
   for (i=0; i<n; i++)
   {
      for (j=0; j<n; j++)
      {
         fout<<setw(4)<<mas[i][j]<<" ";
      }
      fout<<"\n";
   }
 
   fin.close();
   fout.close();
   return 0;
}