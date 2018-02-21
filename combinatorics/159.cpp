/*
http://acmp.ru/index.asp?main=task&id_task=159
По заданной перестановке требуется определить обратную.

Перестановкой из N элементов называется упорядоченный набор из N различных чисел от 1 до N. Количество различных перестановок порядка N равно PN = N!

Пусть у нас есть упорядоченное множество из N элементов. Перестановка задает преобразование этого множества. А именно, она говорит, что на i место нужно поставить ai элемент множества, где ai - i-тый элемент перестановки.

Обратной перестановкой к перестановке π называется такая перестановка π-1, что ππ-1 = π-1π = ε, где ε – тождественная перестановка. То есть если применить сначала перестановку π, а потом обратную к ней π-1, то в итоге получится такой результат, как если бы мы эти перестановки не применяли вообще. Такой же результат получится, если сначала применить обратную перестановку π-1, а потом прямую π.

Входные данные
В первой строке входного файла INPUT.TXT записано число 0 < N ≤ 20000 - порядок перестановки. Во второй строке записана сама перестановка.

Выходные данные
В выходной файл OUTPUT.TXT выведите обратную перестановку.
*/

#include <iostream>
#include <fstream>
using namespace std;
 
class elem
{
   public:
      int el[2][1];
      elem(int x=0, int y=0);
      elem & operator = (elem & app);
};
elem::elem(int x, int y)
{
   el[0][0]=x;
   el[1][0]=y;
}
 
elem& elem::operator = (elem & app)
{
   el[0][0]=app.el[0][0];
   el[1][0]=app.el[1][0];
   return *this;
}
 
class commutation
{
   private:
      elem* comm;
      int N;
   public:
      commutation(int n);
      void add_elem(int x,int y);
      void sort_down();
      void fprint_reverse(ofstream* fout);
};
commutation::commutation(int n)
{
   comm=new elem[n];
   N=n;
}
void commutation::add_elem(int x,int y)
{
   elem t(x+1,y);
   comm[x]=t;
}
void commutation::sort_down()
{
   int i,j;
   elem temp;
   for (i=1; i<N; i++)
   {
      temp=comm[i];
      j=i-1;
      while (j>=0 && comm[j].el[1][0]>temp.el[1][0])
      {
         comm[j+1]=comm[j];
         j--;
      }
      comm[j+1]=temp;
   }
}
void commutation::fprint_reverse(ofstream* fout)
{
   for (int i=0; i<N; (*fout)<<comm[i++].el[0][0]<<" ");
}
 
int main()
{
   int n,curr,i;
   ifstream fin("INPUT.txt");
   ofstream fout("OUTPUT.txt");
   fin>>n;
   commutation pi(n);
   for (i=0; i<n; i++)
   {
      fin>>curr;
      pi.add_elem(i,curr);
   }
   pi.sort_down();
   pi.fprint_reverse(&fout);
   return 0;
}