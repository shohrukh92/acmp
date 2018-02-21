/*
http://acmp.ru/index.asp?main=task&id_task=118
Существует легенда, что Иосиф Флавий - известный историк первого века - выжил и стал известным благодаря математической одаренности. В ходе иудейской войны он в составе отряда из 41 иудейского воина был загнан римлянами в пещеру. Предпочитая самоубийство плену, воины решили выстроиться в круг и последовательно убивать каждого третьего из живых до тех пор, пока не останется ни одного человека. Однако Иосиф наряду с одним из своих единомышленников счел подобный конец бессмысленным - он быстро вычислил спасительные места в порочном круге, на которые поставил себя и своего товарища. И лишь поэтому мы знаем его историю…

В нашем варианте мы начнем с того, что выстроим в круг N человек, пронумерованных числами от 1 до N, и будем исключать каждого k-ого до тех пор, пока не уцелеет только один человек.

Например, если N=10, K=3, то сначала умрет 3-й, потом 6-й, затем 9-й, затем 2-й, затем 7-й, потом 1-й, потом 8-й, за ним - 5-й, и потом 10-й. Таким образом, уцелеет 4-й.

Требуется написать программу, которая по заданным N и K будет определять номер уцелевшего человека.

Входные данные
Входной файл INPUT.TXT содержит два натуральных числа N и K. Ограничения: N ≤ 500, K ≤ 100.

Выходные данные
В выходной файл OUTPUT.TXT нужно вывести номер уцелевшего человека.
*/
#include <iostream>
#include <fstream>
#include <stdlib.h>
using namespace std;
 
typedef struct krug
{
   short num;
   struct krug *next;
} elem;
 
elem *add(elem *last, short n)
{
   elem *newelem = (elem*)malloc(sizeof(elem));
   newelem->num = n;
   newelem->next = last->next;
   last->next = newelem;
   return newelem;
}
 
elem *del( elem *predkogo, elem *kogo)
{
   predkogo->next = kogo->next;
   return kogo->next;
}
 
elem *find(elem *a, short k)
{
   elem *fin=a;
 
   short i=1;
   while (i!=k-1)
   {
      fin=fin->next;
      i++;
   }
   return fin;
}
 
int main()
{
  ifstream in("INPUT.txt");
  ofstream out("OUTPUT.txt");
  short N,K,i;
  in>>N>>K;

  elem first;
  first.num=1;
  first.next=&first;
 
  elem *fp=&first;
  for (i=2; i<=N; i++)
    fp = add(fp, i);
 
 
  elem *begin=&first;
 
  begin=find(begin, K);
 
  short j=0;
  while(j<N-1)
  {
      begin = del(begin, begin->next);
      begin=find(begin, K);
      j++;
  }
  out<<begin->num;
  in.close();
  out.close();

  return 0;
}