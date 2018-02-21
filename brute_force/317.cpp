/*
http://acmp.ru/index.asp?main=task&id_task=317
Ириска весит X грамм, мандарин – Y грамм, пряник – Z грамм.

Требуется написать программу, которая определит, сколько различных вариантов подарков весом ровно W грамм может сделать Дед Мороз.

Входные данные
В единственной строке входного файла INPUT.TXT содержится четыре целых числа X, Y, Z и W (1 ≤ X, Y, Z ≤ 100, 1 ≤ W ≤ 1000).

Выходные данные
Выходной файл OUTPUT.TXT должен содержать одно целое число – количество вариантов подарков.
*/

#include <iostream>
#include <fstream>
using namespace std;
 
int main()
{
   int kx=0;
   ifstream in("INPUT.txt");
   ofstream out("OUTPUT.txt");
   short int x,y,z,w,i,j,k;
   in>>x>>y>>z>>w;//**
 
   for (i=0; i*x<=w; i++)
      for (j=0; j*y+i*x<=w; j++)
         for (k=0; i*x+j*y+k*z<=w; k++)
         {
            if ((i*x+j*y+k*z)==w) kx++;
         }
   out<<kx;
   in.close();
   out.close();
   return 0;
}