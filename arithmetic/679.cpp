/*
http://acmp.ru/index.asp?main=task&id_task=679
Дано натуральное число N. Представить его в виде суммы простых натуральных чисел так, чтобы произведение этих слагаемых было максимально.

Входные данные
В единственной строке входного файла INPUT.TXT записано одно натуральное число N (2 ≤ N ≤ 2 000 000 000).

Выходные данные
В единственную строку выходного файла OUTPUT.TXT нужно вывести простые числа по возрастанию с указанием их количества при разложении, т.е.: <число> <количество>.
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
  
int main()
{
      long long int n,k,l;
      fin>>n;
      k=n/3;
      l=0;
      if(n%3==1)
      {
        k=k-1;
        l=2;
      }
      if(n%3==2) l=1;
      if(l>0)
        fout<<"2 "<<l<<' ';
      if(k>0)
        fout<<"3 "<<k;
  
    return 0;
}