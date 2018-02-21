/*
http://acmp.ru/index.asp?main=task&id_task=245
Как показывает опыт, для создания успешной футбольной команды важны не только умения отдельных её участников, но и сплочённость команды в целом. Характеристикой умения игрока является показатель его профессионализма (ПП). Команда является сплочённой, если ПП каждого из игроков не превосходит суммы ПП любых двух других (в частности, любая команда из одного или двух игроков является сплоченной). Перед тренерским составом молодёжной сборной была поставлена задача сформировать сплоченную сборную с максимальной суммой ПП игроков (ограничений на количество игроков в команде нет).

Ваша задача состоит в том, чтобы помочь сделать правильный выбор из N человек, для каждого из которых известен его ПП.

Входные данные
В первой строке входного файла INPUT.TXT записано целое число N (0 ≤ N ≤ 30000). В последующих N строках записано по одному целому числу Pi (0 ≤ Pi ≤ 60000), представляющему собой ПП соответствующего игрока.

Выходные данные
В выходной файл OUTPUT.TXT выведите максимально возможную сумму ПП игроков сплоченной команды.
*/

#include <fstream>
#include <string>
#include <algorithm>
#include<math.h>
#include<iomanip>
#include <sstream>
using namespace std;
  
    ifstream fin("input.txt");
    ofstream fout("output.txt");
      long int a[30001],sum;
      long int n,i,j;
  
      void QuickSort( long int l, long int r)
      {
            long int x,w;
            i=l; j=r;
            x=a[(l+r)/2];
            do
            {
                  while(a[i]<x) i++;
                  while(x<a[j]) j--;
                  if(i<=j)
                  {
                        w=a[i]; a[i]=a[j]; a[j]=w;
                        i++; j--;
                  }
            }
            while(i<j);
            if(l<j) QuickSort(l,j);
            if(i<r) QuickSort(i,r);
  
      }
  
int main(){
  
      int n,max;
      long int c,l;
      fin>>n;
      for(int t=1; t<=n; t++)
      {
            fin>>a[t];
      }
      if(n==0) fout<<0;
      else if(n==1) fout<<a[1];
      else if(n==2) fout<<a[1]+a[2];
      else
      {
            QuickSort(1,n);
            i=1; j=2;
            sum=a[i]+a[j]; max=sum;
            while(j<n)
                  if(a[i]+a[i+1]>=a[j+1])
                  {
                       j=j+1;
                       sum=sum+a[j];
                       if(sum>max) max=sum;
                  }
                  else
                  {
                        sum=sum-a[i];
                        i++;
                  }
            fout<<max;
      }
  
    return 0;
}