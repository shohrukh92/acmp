/*
http://acmp.ru/index.asp?main=task&id_task=58
Входные данные
Первая строка входного файла INPUT.TXT содержит количество t (1 ≤ t ≤ 10) наборов входных данных. Далее следуют описания этих наборов. Описание каждого набора состоит из строки, содержащей числа n и m (1 ≤ n,m ≤ 100), и n строк, каждая из которых содержит по m чисел, разделенных пробелами. j-ое число в i+1-ой строке описания набора входных данных - элемент aij соответствующей таблицы. Гарантируется, что все aij равны либо нулю, либо единице.

Выходные данные
Для каждого набора входных данных выведите в файл OUTPUT.TXT единственную строку, содержащую слово «YES», если соответствующая таблица является симпатичной, и слово «NO» - в противном случае.
*/

#include <iostream>
#include <fstream>
#include <stdlib.h>
using namespace std;
 
void is_beautiful(bool **mas, int n, int m, ofstream* fout)
{
   int i,j;
   int s;
   for (i=0; i<n-1; i++)
   {
      for (j=0; j<m-1; j++)
      {
         s=(int)mas[i][j]+(int)mas[i][j+1]+(int)mas[i+1][j]+(int)mas[i+1][j+1];
         if (s==0 || s==4)
         {
            *fout<<"NO\n";
            return;
         }
      }
   }
   *fout<<"YES\n";
   return;
}
 
int main()
{
   ifstream fin("INPUT.txt");
   ofstream fout("OUTPUT.txt");
 
   int i,j; //counters for arrays
   int k; fin>>k; //how many arrays
   int t=1; //counter for "How many times"
   int n,m; //row, col of arrays
 
   while (t<=k)
   {
      fin>>n>>m; //row, col
      bool** mas=(bool**)malloc(n*sizeof(bool*));
      for (i=0; i<n; i++){
         *(mas+i)=(bool*)malloc(m*sizeof(bool)); }
 
      for (i=0; i<n; i++)
      {
         for (j=0; j<m; j++)
         {
            fin>>mas[i][j];
         }
      }
      is_beautiful(mas, n, m, &fout);
      t++;
      free(mas);
   }
 
   fin.close();
   fout.close();
   return 0;
}