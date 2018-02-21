/*
TODO has Time limit exceeded error, it should be optimized
http://acmp.ru/index.asp?main=task&id_task=398
адано натуральное число x. Найдите число способов представить его в виде суммы четырех натуральных чисел: x = a + b + c + d, где a ≤ b ≤ c ≤ d.

Входные данные
Входной файл INPUT.TXT содержит целое число x (1 ≤ x ≤ 1500).

Выходные данные
В выходной файл OUTPUT.TXT выведите ответ на задачу.
*/

#include <iostream>
#include <fstream>
using namespace std;
 
int kx=0; //кол-во способов
unsigned short int x,mas[4]={1,1,1,1};
 
void summ(int i)
{
   unsigned short int j;
   if (i==4)
   {
      if (mas[0]+mas[1]+mas[2]+mas[3]==x) kx++;
      return;
   }
   else
   {
      for (j=mas[i-1]; j>=1; j--)
      {
         mas[i]=j;
         summ(i+1);
      }
   }
}
 
int main()
{
    ifstream in("INPUT.txt");
    ofstream out("OUTPUT.txt");
    unsigned short int j;
    in>>x;
    for (j=x-3; j>=1; j--)
    {
       mas[0]=j;
       summ(1);
    }
 
    out<<kx;
    in.close();
    out.close();
    return 0;
}