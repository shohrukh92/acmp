/*
http://acmp.ru/index.asp?main=task&id_task=196
Требуется вывести квадрат, состоящий из N×N клеток, заполненных числами от 1 до N2 по спирали (см. примеры).

Входные данные
Во входном файле INPUT.TXT задано целое число N – размер квадратной матрицы (2 ≤ N ≤ 100).

Выходные данные
В выходной файл OUTPUT.TXT выведите матрицу, заполненную числами от 1 до N2 по спирали, при этом между числами может быть любое количество пробелов. Не допускается начинать спираль в ином, кроме верхнего левого, углу, закручивать спираль против часовой стрелки или изнутри наружу.
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
   int n;
   int i,j;

   fin>>n;
   int** mas=(int**)malloc(n*sizeof(int*));
   for (i=0; i<n; i++)
   {
      mas[i]=(int*)malloc(n*sizeof(int));
   }
   for (i=0; i<n; i++)
   {
      for (j=0; j<n; j++)
      {
         mas[i][j]=0;
      }
   }
 
 
   int k=1;
 
   i=0; j=0;
   int nl,nr,nd,nu;
   nl=-1; nd=n; nr=n; nu=0;
 
   bool l,r,d,u;
   l=false; r=true;
   u=false; d=false;
 
   while (k<=n*n)
   {
      if (r)
      {
         mas[i][j]=k; j++;
         if (j==nr)
         {
            r=false; d=true;
            j--; i++;
            nr--;
         }
      }
      else if (d)
      {
         mas[i][j]=k; i++;
         if(i==nd)
         {
            d=false; l=true;
            i--; j--;
            nd--;
         }
      }
      else if (l)
      {
         mas[i][j]=k; j--;
         if (j==nl)
         {
            l=false; u=true;
            j++; i--;
            nl++;
         }
      }
      else
      {
         mas[i][j]=k; i--;
         if (i==nu)
         {
            u=false; r=true;
            i++; j++;
            nu++;
         }
      }
      k++;
   }
 
   for (i=0; i<n; i++)
   {
      for (j=0; j<n; j++)
      {
         fout<<setw(8)<<mas[i][j]<<" ";
      }
      fout<<'\n';
   }
   fin.close();
   fout.close();

   return 0;
}