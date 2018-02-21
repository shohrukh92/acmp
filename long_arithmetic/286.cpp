/*
http://acmp.ru/index.asp?main=task&id_task=286
Программист Билл занимается разработкой программного обеспечения для новейшего робота-исследователя, которого учёные планируют отправить на Марс с целью поиска там следов разумной жизни. Модули, которые отвечают за передвижение робота и сбор проб грунта, Билл уже скачал из Интернета. Оставалось лишь научить робота отличать разумные формы жизни от неразумных. Для этого Боб несколько месяцев посещал программистские форумы, и, наконец, нашёл подходящий модуль. Теперь, чтобы определить, является ли тот или иной объект представителем внеземной расы, роботу достаточно сравнить два вещественных числа.

Однако за несколько часов до запуска корабля на Марс обнаружилось, что робот неправильно сравнивает вещественные числа! Чтобы исправить эту ошибку, учёные обратились за помощью к Вам.

Входные данные
Входной файл INPUT.TXT состоит из двух строк, в каждой из которых записано по одному вещественному числу без ведущих нулей. Целая и дробная части отделяются точкой, которая может быть опущена, если число целое. Каждое из чисел содержит не более 10000 цифр. Если число равно нулю, то знака минус в его записи нет.

Выходные данные
В выходной файл OUTPUT.TXT выведите один символ ‘<’, если первое число меньше второго, ‘>’, если больше, и ‘=’, если числа равны.
*/

#include <iostream>
#include <fstream>
#include <string.h>
 
using namespace std;
class real_num
{
   public:
      char num[10003];
      int len; //with decimal point
      int posp; //from 1
      real_num(ifstream* in);
};
 
real_num::real_num(ifstream* in)
{
   (*in).getline(num,10002); //***
   len=strlen(num);
   posp=0;
   int i;
   for (i=0; i<len; i++)
   {
      if (num[i]=='.')
      {
         posp=i+1;
         break;
      }
   }
   for (i=len; i<10003; num[i++]='0');
   if (!posp) { num[len]='.'; posp=len+1; }
}
 
int main()
{
   ifstream fin("input.txt");
   ofstream fout("output.txt");
   real_num a(&fin);
   real_num b(&fin);
   int i,max; char sign='?';
   a.len>b.len ? max=a.len : max=b.len;
 
   if (a.num[0]=='-' && b.num[0]!='-') fout<<"<";
   else if (b.num[0]=='-' && a.num[0]!='-') fout<<">";
   else if (a.num[0]=='-' && b.num[0]=='-')
   {
      if (a.posp>b.posp) fout<<"<";
      else if (a.posp<b.posp) fout<<">";
      else
      {
         for (i=0; i<max; i++)
         {
            if (a.num[i]<b.num[i])
            {
               sign='>';
               break;
            }
            else if (a.num[i]>b.num[i])
            {
               sign='<';
               break;
            }
         }
         if (sign=='?') sign='=';
         fout<<sign;
      }
   }
   else
   {
      if (a.posp>b.posp) fout<<">"; //****
      else if (a.posp<b.posp) fout<<"<";
      else
      {
         for (i=0; i<max; i++)
         {
            if (a.num[i]<b.num[i])
            {
               sign='<';
               break;
            }
            else if (a.num[i]>b.num[i])
            {
               sign='>';
               break;
            }
         }
         if (sign=='?') sign='=';
         fout<<sign;
      }
   }
 
   fin.close();
   fout.close();
   return 0;
}