/*
http://acmp.ru/index.asp?main=task&id_task=7
Главный вождь племени Абба не умеет считать. В обмен на одну из его земель вождь другого племени предложил ему выбрать одну из трех куч с золотыми монетами. Но вождю племени Абба хочется получить наибольшее количество золотых монет. Помогите вождю сделать правильный выбор!

Входные данные
В первой строке входного файла INPUT.TXT записаны три натуральных числа через пробел. Каждое из чисел не превышает 10100. Числа записаны без ведущих нулей.

Выходные данные
В выходной файл OUTPUT.TXT нужно вывести одно целое число — максимальное количество монет, которые может взять вождь.
*/

#include <iostream>
#include <fstream>
#include <string.h>
 
using namespace std;
int compare_huge(char* a, char* b, int lena, int lenb)
{
   if (lena>lenb) return 1;
   else if (lena<lenb) return -1;
   else
   {
      int i;
      for (i=0; i<lena; i++)
      {
         if (a[i]>b[i]) return 1;
         else if (a[i]<b[i]) return -1;
      }
      return 0;
   }
}
int main()
{
   ifstream fin ("INPUT.txt");
   ofstream fout ("OUTPUT.txt");
   char a[102], b[102], c[102];
   fin>>a>>b>>c;
   int lena,lenb,lenc;
   lena=strlen(a);
   lenb=strlen(b);
   lenc=strlen(c);
 
   if (compare_huge(a,b,lena,lenb)>=0 &&
       compare_huge(a,c,lena,lenc)>=0) fout<<a;
   else if (compare_huge(b,a,lenb,lena)>=0 &&
            compare_huge(b,c,lenb,lenc)>=0) fout<<b;
   else fout<<c;
   fin.close();
   fout.close();
   return 0;
}