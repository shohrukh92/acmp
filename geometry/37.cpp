/*
TODO fix it, Wrong answer in 20 test
http://acmp.ru/index.asp?main=task&id_task=37
Оператором А, действующим из множества Х в множество Y (или просто оператором из X в Y) называется правило, согласно которому каждому элементу x множества X сопоставляется элемент y=Ax из множества Y. Пусть X и Y – множества точек на плоскости. Оператор A из X в Y называется сжимающим с коэффициентом q, где q – вещественное число из полуинтервала [0, 1), если для любого x из X выполнено ||Ax|| ≤ q*||x|| (здесь ||x|| - норма точки x – расстояние от x до начала координат). Проще говоря, оператор называется сжимающим с коэффициентом q если он сопоставляет каждой точке точку, которая не менее, чем в q раз ближе к началу координат.

Для заданного оператора А требуется проверить является ли он сжимающим с коэффициентом q.

Входные данные
Первая строка входного файла INPUT.TXT содержит количество точек n (1 ≤ n ≤ 100) и число q (0 ≤ q < 1), заданное не более чем с 3 знаками после десятичной точки. Следующие n строк содержат по 4 целых числа, по модулю не превосходящих 1000, разделенные пробелами – координаты точки множества X и сопоставленной ей точки из множества Y.

Выходные данные
В выходной файл OUTPUT.TXT выведите одно слово: “Yes” если оператор является сжимающим с коэффициентом q и “No” в противном случае.
*/
#include <iostream>
#include <fstream>
#include <stdlib.h>
#include <math.h>
using namespace std;
 
typedef struct opera
{
   int xX,yX;
   int xY, yY;
   float modx, mody;
}elem;
 
int main()
{
   ifstream in("INPUT.txt");
   ofstream out("OUTPUT.txt");
   short n,i; float q;
   in>>n; in>>q;
   elem *mas=(elem *)malloc(n*sizeof(elem));
   for (i=0; i<n; i++)
   {
      in>>mas[i].xX>>mas[i].yX>>mas[i].xY>>mas[i].yY;
      mas[i].modx = sqrt((double)mas[i].xX*(double)mas[i].xX +
                         (double)mas[i].yX*(double)mas[i].yX);
      mas[i].mody = sqrt((double)mas[i].xY*(double)mas[i].xY +
                         (double)mas[i].yY*(double)mas[i].yY);
   }
   bool bobo=true;
   for (i=0; i<n; i++)
   {
      if (mas[i].modx*q < mas[i].mody)
      {
         out<<"No"; bobo=false; break;
      }
   }
   if (bobo) out<<"Yes";
 
   in.close();
   out.close();
   return 0;
}