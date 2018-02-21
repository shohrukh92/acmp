/*
http://acmp.ru/index.asp?main=task&id_task=323
Известно, что любое чётное число, большее 2, представимо в виде суммы 2 простых чисел, причём таких разложений может быть несколько. Впервые гипотезу о существовании данного разложения сформулировал математик Х. Гольдбах.

Требуется написать программу, производящую согласно утверждению Гольдбаха, разложение заданного чётного числа. Из всех пар простых чисел, сумма которых равна заданному числу, требуется найти пару, содержащую наименьшее простое число.

Входные данные
Входной файл INPUT.TXT содержит чётное число N (4 ≤ N ≤ 998).

Выходные данные
В выходной файл OUTPUT.TXT необходимо вывести два простых числа, сумма которых равна числу N. Первым выводится наименьшее число.
*/
#include <iostream>
#include <fstream>
 
using namespace std;
bool mas[1000];
 
void full_prime(int n)
{
   int j,i;
   for (i=0; i<=n; mas[i++]=true);
   for (i=2; i<=n; i++)
   {
      if (mas[i]==false) continue;
      for (j=2*i; j<=n; j++)
      {
         if (j%i==0) mas[j]=false;
      }
   }
   return;
}
int main()
{
   ifstream fin("INPUT.txt");
   ofstream fout("OUTPUT.txt");
   int n,i,j;
   fin>>n;
   full_prime(n);
   bool t=false;
   for (i=2; i<=n; i++)
   {
      if (t) break;
      if (mas[i])
      {
         for (j=i; j<=n; j++)
         {
            if (mas[j] && (j+i==n))
            {
               fout<<i<<" "<<j<<'\n';
               t=true;
               break; //return 0;
            }
         }
      }
   }
   fin.close();
   fout.close();
   return 0;
}