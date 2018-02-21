/*
http://acmp.ru/index.asp?main=task&id_task=18
Требуется вычислить факториал целого числа N. Факториал обозначают как N! и вычисляют по формуле:

N! = 1 * 2 * 3 * … * (N-1) * N, причем 0! = 1.

Так же допустимо рекуррентное соотношение: N! = (N-1)! * N

Входные данные
В единственной строке входного файла INPUT.TXT записано одно целое неотрицательное число N (N < 1000).

Выходные данные
В выходной файл OUTPUT.TXT нужно вывести одно целое число — значение N!.
*/
#include <iostream>
#include <fstream>
#include <cstdlib>
#include <cmath>
 
using namespace std;
 
class long_num //reversed
{
   public:
      int* num;
      int length;
      long_num(int n); //n!
      void multiply_num(int m); // num*m
      void print_num(ofstream* out)
      {
         for (int i=num[0]; i>=1; *out<<num[i--]);
         return;
      }
   private:
};
 
long_num::long_num(int n)
{
   int i; double len=0;
   for (i=1; i<=n; len=len+log10((double)i++));
   length=(int)len+1;
 
   num=(int*)malloc((length+1)*sizeof(int));
   num[0]=1;
   num[1]=1;
}
 
//multiply long num by short m
void long_num::multiply_num(int m)
{
   int i,r=0;
   for (i=1; i<=num[0]; i++)
   {
      r=r+num[i]*m;
      num[i]=r%10;
      r=r/10;
   }
   while (r)
   {
      num[0]++;
      num[num[0]]=r%10;
      r=r/10;
   }
   return;
}
 
int main()
{
   ifstream fin("INPUT.txt");
   ofstream fout("OUTPUT.txt");
   
   int n; fin>>n; 
   long_num nfact(n);
 
   int i;
   for (i=2; i<=n; i++)
      nfact.multiply_num(i);
 
   nfact.print_num(&fout);
 
   fin.close();
   fout.close();
   return 0;
}